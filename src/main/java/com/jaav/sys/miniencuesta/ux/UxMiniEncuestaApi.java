package com.jaav.sys.miniencuesta.ux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.jaav.sys"})
//@EnableConfigurationProperties
public class UxMiniEncuestaApi {

	public static void main(String[] args) {
		SpringApplication.run(UxMiniEncuestaApi.class, args);
	}

}
