package com.jaav.sys.miniencuesta.ux.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EncuestaAlternativaResponse {

    private Integer enaltId;
    private String enaltEstado;
    private String enaltOpcion;
    private String enteCodigo;

}
