package com.jaav.sys.miniencuesta.ux.service;

import com.jaav.sys.miniencuesta.ux.model.api.EncuestaTemaResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EncuestaTemaService {

    Optional<EncuestaTemaResponse> obtenerPorId(String id)  throws IOException;
    List<EncuestaTemaResponse> listar() throws IOException;



}
