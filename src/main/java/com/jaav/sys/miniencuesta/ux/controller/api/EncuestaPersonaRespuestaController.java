package com.jaav.sys.miniencuesta.ux.controller.api;

import com.jaav.sys.miniencuesta.ux.model.api.EncuestaPersonaRespuestaBean;
import com.jaav.sys.miniencuesta.ux.service.EncuestaPersonaRespuestaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
//@CrossOrigin
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/api/ux/miniencuesta/v1/respuesta")
public class EncuestaPersonaRespuestaController {

    private static final Logger logger = LoggerFactory.getLogger(EncuestaPersonaRespuestaController.class);

    @Autowired
    private EncuestaPersonaRespuestaService encuestaAlternativaService;



    @GetMapping(value = "/" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "listar" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = EncuestaPersonaRespuestaBean[].class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<List<EncuestaPersonaRespuestaBean>> obtenerTodos(Pageable pageable){
        try {
            return new ResponseEntity<>(
                    encuestaAlternativaService.findAll(), HttpStatus.OK);
        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/tema/{enteCodigo}" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "listar por tema" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = EncuestaPersonaRespuestaBean[].class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<List<EncuestaPersonaRespuestaBean>> listarTemaCodigo(
            @PathVariable String enteCodigo){
        try {
            return new ResponseEntity<>(
                    encuestaAlternativaService.findByTema(enteCodigo), HttpStatus.OK);
        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/pag/{iniPag}/{sizePag}/tema/{enteCodigo}" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "listr por tema y paginado" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = EncuestaPersonaRespuestaBean[].class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<List<EncuestaPersonaRespuestaBean>> listarTemaCodigo(
            @PathVariable(name = "enteCodigo") String enteCodigo,
            @PathVariable(name = "iniPag") Integer iniPag,
            @PathVariable(name = "sizePag") Integer sizePag){
        try {
            /*MeEncuestaPersonaRespuesta filtro = new MeEncuestaPersonaRespuesta();
            MeEncuestaAlternativa altFiltro = new MeEncuestaAlternativa();
            altFiltro.setEnteCodigo(enteCodigo);
            filtro.setMeEncuestaAlternativa(altFiltro);
            filtro.setInicio(iniPag);
            filtro.setNumeroFilas(sizePag);
            List<MeEncuestaPersonaRespuesta> lista = meEncuestaAlternativaService.listar(filtro, true);

            if(Optional.ofNullable(lista).isPresent() && !lista.isEmpty()){
                int cuentaTotal = meEncuestaAlternativaService.contarListado(filtro);
                lista.stream().forEach(c -> {c.setContadorTotal(cuentaTotal);});
            }*/
            return new ResponseEntity<>(
                    encuestaAlternativaService.findByTema(enteCodigo), HttpStatus.OK);

        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/usuario/{codUsuario}/tema/{enteCodigo}" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "listar por usuario y por tema" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = EncuestaPersonaRespuestaBean[].class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<List<EncuestaPersonaRespuestaBean>> obtenerPorCodigoUsuario(
            @PathVariable String codUsuario , @PathVariable String enteCodigo
    ){
        try {

            return new ResponseEntity<>(
                    encuestaAlternativaService.findByTemaUsuario(enteCodigo,codUsuario),
                    HttpStatus.OK);
        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
