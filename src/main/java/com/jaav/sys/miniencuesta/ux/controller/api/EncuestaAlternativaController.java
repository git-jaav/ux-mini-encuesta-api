package com.jaav.sys.miniencuesta.ux.controller.api;

import com.jaav.sys.miniencuesta.ux.model.api.EncuestaAlternativaResponse;
import com.jaav.sys.miniencuesta.ux.service.EncuestaAlternativaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ux/miniencuesta/v1/alternativa")
public class EncuestaAlternativaController {


    private static final Logger logger = LoggerFactory.getLogger(EncuestaAlternativaController.class);

    @Autowired
    private EncuestaAlternativaService encuestaAlternativaService;


    @GetMapping(value = "/tema/{enteCodigo}" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "listar las alternativas" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = EncuestaAlternativaResponse[].class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<List<EncuestaAlternativaResponse>> listarTemaCodigo(
            @PathVariable(name = "enteCodigo") String enteCodigo){
        try {
            return new ResponseEntity<>(
                    encuestaAlternativaService.listarTemaCodigo(enteCodigo), HttpStatus.OK);
        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
