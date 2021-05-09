package com.jaav.sys.miniencuesta.ux.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jaav.sys.miniencuesta.ux.proxyclient.BusinessMiniEncuestaApi;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class ProxyClientConfig {


    @Autowired
    ApplicationProperties applicationProperties;

    //@Autowired
    //private LoggingInterceptor loggingInterceptor;
    @Value("${application.http-client.business-me.url}")
    private String baseUrlBusinessMe;

    @Bean
    @Autowired
    public Retrofit retrofit(OkHttpClient client, Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrlBusinessMe)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    @Bean
    public OkHttpClient client() {
        final OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        final OkHttpClient builtClient = okHttpClientBuilder.build();

        return builtClient;
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder().setLenient().create();
    }


    // Create a Bean for svcInvestmentClient and add it to SpringContext.
    @Bean
    public BusinessMiniEncuestaApi businessMiniEncuestaApi() {
        return retrofit(client(),gson())
                .create(BusinessMiniEncuestaApi.class);
    }

    /*
    // Create Retrofit instance of svcInvestment
    private Retrofit createHttpClient(String baseUrl,String connectionTimeout,String readTimeout,
                                      ObjectMapper objectMapper) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(Integer.parseInt(connectionTimeout), TimeUnit.MILLISECONDS)
                .readTimeout(Integer.parseInt(readTimeout),TimeUnit.MILLISECONDS);
        return new Retrofit.Builder()
                .baseUrl("http://localhost/api/business/miniencuesta/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

    }*/

}
