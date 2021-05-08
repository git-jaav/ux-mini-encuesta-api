package com.jaav.sys.miniencuesta.ux.service;

import com.jaav.sys.miniencuesta.ux.model.api.EncuestaTemaResponse;

import java.util.List;
import java.util.Optional;

public interface EncuestaTemaService {

    Optional<EncuestaTemaResponse> obtenerPorId(String id);
    List<EncuestaTemaResponse> listar();



}
