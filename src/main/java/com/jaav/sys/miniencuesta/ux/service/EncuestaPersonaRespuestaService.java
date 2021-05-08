package com.jaav.sys.miniencuesta.ux.service;

import com.jaav.sys.miniencuesta.ux.model.api.EncuestaPersonaRespuestaBean;

import java.util.List;
import java.util.Optional;

public interface EncuestaPersonaRespuestaService {

    List<EncuestaPersonaRespuestaBean> findAll();
    List<EncuestaPersonaRespuestaBean> findByTema(String tema);
    List<EncuestaPersonaRespuestaBean> findByTemaUsuario(String tema, String usuario);
    Optional<EncuestaPersonaRespuestaBean> save(EncuestaPersonaRespuestaBean objDao) throws Exception;

}
