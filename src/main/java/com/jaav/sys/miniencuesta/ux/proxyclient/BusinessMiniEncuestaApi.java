package com.jaav.sys.miniencuesta.ux.proxyclient;

import com.jaav.sys.miniencuesta.ux.model.external.MeEncuestaAlternativaJson;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface BusinessMiniEncuestaApi {

    @GET("alternativa/tema/{enteCodigo}")
    public Call<List<MeEncuestaAlternativaJson>> getAlternativasTema(
            @Path("enteCodigo") String enteCodigo);

}
