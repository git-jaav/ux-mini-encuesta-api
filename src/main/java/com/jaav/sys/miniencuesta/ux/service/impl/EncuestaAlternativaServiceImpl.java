package com.jaav.sys.miniencuesta.ux.service.impl;

import com.jaav.sys.miniencuesta.ux.model.api.EncuestaAlternativaResponse;
import com.jaav.sys.miniencuesta.ux.service.EncuestaAlternativaService;
import com.jaav.sys.miniencuesta.ux.utils.JsonViewAssembler;
import com.jaav.sys.miniencuesta.ux.model.external.MeEncuestaAlternativaJson;
import com.jaav.sys.miniencuesta.ux.proxyclient.BusinessMiniEncuestaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import java.io.IOException;
import java.util.List;

@Service
public class EncuestaAlternativaServiceImpl implements EncuestaAlternativaService {

    @Autowired
    BusinessMiniEncuestaApi businessMiniEncuestaApi;

    private JsonViewAssembler<MeEncuestaAlternativaJson, EncuestaAlternativaResponse> jsonAssemb =
            new JsonViewAssembler<MeEncuestaAlternativaJson, EncuestaAlternativaResponse>(EncuestaAlternativaResponse.class);

    private JsonViewAssembler<EncuestaAlternativaResponse, MeEncuestaAlternativaJson> jsonAssembInverso =
            new JsonViewAssembler<EncuestaAlternativaResponse, MeEncuestaAlternativaJson>(MeEncuestaAlternativaJson.class);


    @Override
    public List<EncuestaAlternativaResponse> listarTemaCodigo(String enteCodigo) throws IOException {
        Response<List<MeEncuestaAlternativaJson>> response =
                businessMiniEncuestaApi.getAlternativasTema(enteCodigo).execute();
        if (response.isSuccessful()) {
            return jsonAssemb.getJsonList(response.body());
        }else {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }
    }


}
