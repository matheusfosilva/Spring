package br.com.sdconecta.estagio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class EstagioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstagioApplication.class, args);
	}

}
