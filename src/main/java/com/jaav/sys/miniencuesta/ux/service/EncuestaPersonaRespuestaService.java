package com.jaav.sys.miniencuesta.ux.service;

import com.jaav.sys.miniencuesta.ux.model.api.EncuestaPersonaRespuestaBean;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EncuestaPersonaRespuestaService {

    List<EncuestaPersonaRespuestaBean> findAll()  throws IOException;
    List<EncuestaPersonaRespuestaBean> findByTema(String tema)  throws IOException ;
    List<EncuestaPersonaRespuestaBean> findByTemaUsuario(String tema, String usuario) throws IOException ;
    Optional<EncuestaPersonaRespuestaBean> save(EncuestaPersonaRespuestaBean objDao) throws Exception;

}
