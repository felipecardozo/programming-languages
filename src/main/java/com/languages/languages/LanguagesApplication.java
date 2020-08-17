package com.languages.languages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class LanguagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LanguagesApplication.class, args);
	}

}
