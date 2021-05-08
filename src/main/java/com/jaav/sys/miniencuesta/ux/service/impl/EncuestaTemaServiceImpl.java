package com.jaav.sys.miniencuesta.ux.service.impl;

import com.jaav.sys.miniencuesta.ux.model.api.EncuestaTemaResponse;
import com.jaav.sys.miniencuesta.ux.model.external.MeEncuestaTemaJson;
import com.jaav.sys.miniencuesta.ux.proxyclient.BusinessMiniEncuestaApi;
import com.jaav.sys.miniencuesta.ux.service.EncuestaTemaService;
import com.jaav.sys.miniencuesta.ux.utils.JsonViewAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class EncuestaTemaServiceImpl implements EncuestaTemaService {


    @Autowired
    BusinessMiniEncuestaApi businessMiniEncuestaApi;

    private JsonViewAssembler<MeEncuestaTemaJson, EncuestaTemaResponse> jsonAssemb =
            new JsonViewAssembler<MeEncuestaTemaJson, EncuestaTemaResponse>(EncuestaTemaResponse.class);

    private JsonViewAssembler<EncuestaTemaResponse, MeEncuestaTemaJson> jsonAssembInverso =
            new JsonViewAssembler<EncuestaTemaResponse, MeEncuestaTemaJson>(MeEncuestaTemaJson.class);



    @Override
    public Optional<EncuestaTemaResponse> obtenerPorId(String tema) throws IOException {
        Response<MeEncuestaTemaJson> response =
                businessMiniEncuestaApi.getTema(tema).execute();
        if (response.isSuccessful()) {
            return Optional.ofNullable(jsonAssemb.getJsonObject(response.body()));
        }else {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error in findByTema");
        }
    }

    @Override
    public List<EncuestaTemaResponse> listar() throws IOException {
        Response<List<MeEncuestaTemaJson>> response =
                businessMiniEncuestaApi.getTema().execute();
        if (response.isSuccessful()) {
            return jsonAssemb.getJsonList(response.body());
        }else {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error in listar");
        }
    }


}
