package com.languages.languages.handler;

import com.languages.languages.domain.Language;
import com.languages.languages.repository.LanguageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@CrossOrigin(origins = "*")
@Configuration
public class RouterFunctionHandler {

    @Autowired
    private LanguageRepository languageRepository;

    @Bean
    public RouterFunction<?> endpoints(){
        return route(GET("/insert"), this::simpleInsert
        ).andRoute( GET("/languages"), this::findAll
        ).andRoute( GET("/"),
                request -> ok().body(Mono.just("Welcome, go to /languages URI"), String.class) );
    }

    @Cacheable("languages")
    private Mono<ServerResponse> findAll(ServerRequest request){
        return ServerResponse.ok().body( languageRepository.findAll(), Language.class );
    }

    private Mono<ServerResponse> simpleInsert(ServerRequest request){
        List<String> used = new ArrayList<>();
        used.add("web");
        used.add("standalone");
        used.add("mobile");
        Language java = new Language();
        java.setName("Java");
        java.setLongDescription("java is an OOP language");
        java.setImagePath("https://i2.wp.com/smartpos.com.co/wp-content/uploads/2018/10/191bf3e6-f5e5-4430-abb9-2294aa3bb728-java-logo-512x512.png");
        java.setUsed(used);

        Mono<Language> languageMono = languageRepository.save(java);

        return ServerResponse.ok().body( languageMono, Language.class );
    }

}
