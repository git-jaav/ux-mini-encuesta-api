package com.jaav.sys.miniencuesta.ux.service.impl;

import com.jaav.sys.miniencuesta.ux.model.api.EncuestaTemaResponse;
import com.jaav.sys.miniencuesta.ux.service.EncuestaTemaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncuestaTemaServiceImpl implements EncuestaTemaService {

    @Override
    public Optional<EncuestaTemaResponse> obtenerPorId(String id) {
        return Optional.empty();
    }

    @Override
    public List<EncuestaTemaResponse> listar() {
        return null;
    }
}
