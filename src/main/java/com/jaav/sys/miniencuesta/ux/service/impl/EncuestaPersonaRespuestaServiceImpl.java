package com.jaav.sys.miniencuesta.ux.service.impl;

import com.jaav.sys.miniencuesta.ux.model.api.EncuestaPersonaRespuestaBean;
import com.jaav.sys.miniencuesta.ux.model.external.MeEncuestaPersonaRespuestaJson;
import com.jaav.sys.miniencuesta.ux.service.EncuestaPersonaRespuestaService;
import com.jaav.sys.miniencuesta.ux.proxyclient.BusinessMiniEncuestaApi;
import com.jaav.sys.miniencuesta.ux.utils.JsonViewAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class EncuestaPersonaRespuestaServiceImpl implements EncuestaPersonaRespuestaService {

    @Autowired
    BusinessMiniEncuestaApi businessMiniEncuestaApi;

    private JsonViewAssembler<MeEncuestaPersonaRespuestaJson, EncuestaPersonaRespuestaBean> jsonAssemb =
            new JsonViewAssembler<MeEncuestaPersonaRespuestaJson, EncuestaPersonaRespuestaBean>(EncuestaPersonaRespuestaBean.class);

    private JsonViewAssembler<EncuestaPersonaRespuestaBean, MeEncuestaPersonaRespuestaJson> jsonAssembInverso =
            new JsonViewAssembler<EncuestaPersonaRespuestaBean, MeEncuestaPersonaRespuestaJson>(MeEncuestaPersonaRespuestaJson.class);


    @Override
    public List<EncuestaPersonaRespuestaBean> findAll() throws IOException {
        Response<List<MeEncuestaPersonaRespuestaJson>> response =
                businessMiniEncuestaApi.getEncuestaPersonaRespuesta().execute();
        if (response.isSuccessful()) {
            return jsonAssemb.getJsonList(response.body());
        }else {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error in findAll");
        }
    }


    @Override
    public List<EncuestaPersonaRespuestaBean> findByTema(String tema) throws IOException {
        Response<List<MeEncuestaPersonaRespuestaJson>> response =
                businessMiniEncuestaApi.getEncuestaPersonaRespuesta(tema).execute();
        if (response.isSuccessful()) {
            return jsonAssemb.getJsonList(response.body());
        }else {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error in findByTema");
        }
    }

    @Override
    public List<EncuestaPersonaRespuestaBean> findByTemaUsuario(String tema, String usuario) throws IOException {
        Response<List<MeEncuestaPersonaRespuestaJson>> response =
                businessMiniEncuestaApi.getEncuestaPersonaRespuesta(tema, usuario).execute();
        if (response.isSuccessful()) {
            return jsonAssemb.getJsonList(response.body());
        }else {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error in findByTema");
        }
    }

    @Override
    public Optional<EncuestaPersonaRespuestaBean> save(EncuestaPersonaRespuestaBean objDao) throws IOException {
        Response<MeEncuestaPersonaRespuestaJson> response =
                businessMiniEncuestaApi.saveEncuestaPersonaRespuesta(jsonAssembInverso.getJsonObject(objDao)).execute();
        if (response.isSuccessful()) {
            return Optional.ofNullable(jsonAssemb.getJsonObject(response.body()));
        }else {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error in save");
        }

    }
}
