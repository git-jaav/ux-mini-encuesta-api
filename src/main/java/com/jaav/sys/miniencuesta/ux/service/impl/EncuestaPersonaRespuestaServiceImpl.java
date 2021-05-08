package com.jaav.sys.miniencuesta.ux.service.impl;

import com.jaav.sys.miniencuesta.ux.model.api.EncuestaPersonaRespuestaBean;
import com.jaav.sys.miniencuesta.ux.service.EncuestaPersonaRespuestaService;
import com.jaav.sys.miniencuesta.ux.proxyclient.BusinessMiniEncuestaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncuestaPersonaRespuestaServiceImpl implements EncuestaPersonaRespuestaService {

    @Autowired
    BusinessMiniEncuestaApi businessMiniEncuestaApi;

    @Override
    public List<EncuestaPersonaRespuestaBean> findAll() {
        return null;
    }

    @Override
    public List<EncuestaPersonaRespuestaBean> findByTema(String tema) {
        return null;
    }

    @Override
    public List<EncuestaPersonaRespuestaBean> findByTemaUsuario(String tema, String usuario) {
        return null;
    }

    @Override
    public Optional<EncuestaPersonaRespuestaBean> save(EncuestaPersonaRespuestaBean objDao) throws Exception {
        return Optional.empty();
    }
}
