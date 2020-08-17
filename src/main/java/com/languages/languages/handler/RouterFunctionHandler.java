package com.languages.languages.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;

@Configuration
public class RouterFunctionHandler {

    @Bean
    public RouterFunction<?> endpoints(){
        return route(GET("/hi2"),
                request -> ok().body(just("Hello from reactive"), String.class)
        );
    }

}
