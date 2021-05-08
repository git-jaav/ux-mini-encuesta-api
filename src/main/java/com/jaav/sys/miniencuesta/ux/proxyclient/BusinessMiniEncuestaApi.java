package com.jaav.sys.miniencuesta.ux.proxyclient;

import com.jaav.sys.miniencuesta.ux.model.external.MeEncuestaAlternativaJson;
import com.jaav.sys.miniencuesta.ux.model.external.MeEncuestaPersonaRespuestaJson;
import com.jaav.sys.miniencuesta.ux.model.external.MeEncuestaTemaJson;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface BusinessMiniEncuestaApi {

    @GET("alternativa/tema/{enteCodigo}")
    public Call<List<MeEncuestaAlternativaJson>> getAlternativasTema(
            @Path("enteCodigo") String enteCodigo);


    @GET("respuesta/")
    public Call<List<MeEncuestaPersonaRespuestaJson>> getEncuestaPersonaRespuesta();

    @GET("respuesta/tema/{enteCodigo}")
    public Call<List<MeEncuestaPersonaRespuestaJson>> getEncuestaPersonaRespuesta(
            @Path("enteCodigo") String enteCodigo);

    @GET("respuesta/usuario/{codUsuario}/tema/{enteCodigo}")
    public Call<List<MeEncuestaPersonaRespuestaJson>> getEncuestaPersonaRespuesta(
            @Path("codUsuario") String codUsuario, @Path("tema") String tema);

    @POST("respuesta/")
    public Call<MeEncuestaPersonaRespuestaJson> saveEncuestaPersonaRespuesta(
            @Body MeEncuestaPersonaRespuestaJson request);

    @GET("tema/id/{id}")
    public Call<MeEncuestaTemaJson> getTema(@Path("id") String id);


    @GET("tema/")
    public Call<List<MeEncuestaTemaJson>> getTema();

}
