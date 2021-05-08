package com.jaav.sys.miniencuesta.ux.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EncuestaTemaResponse {

    private String enteCodigo;
    private String enteDetalles;
    private String enteEstado;
    private String enteTema;

}
