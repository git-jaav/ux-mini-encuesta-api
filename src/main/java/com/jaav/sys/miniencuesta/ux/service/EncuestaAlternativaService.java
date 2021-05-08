package com.jaav.sys.miniencuesta.ux.service;

import com.jaav.sys.miniencuesta.ux.model.api.EncuestaAlternativaResponse;

import java.io.IOException;
import java.util.List;

public interface EncuestaAlternativaService {

    public List<EncuestaAlternativaResponse> listarTemaCodigo(String enteCodigo) throws IOException;

}
