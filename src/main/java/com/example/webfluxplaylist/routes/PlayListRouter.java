package com.example.webfluxplaylist.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

/** Chamadas da API usando estilo funcional */

//@Configuration
public class PlayListRouter {

//    @Bean
    public RouterFunction<ServerResponse> route(PlayListHandler playListHandler){
        return RouterFunctions
                .route(GET("/playlist").and(accept(MediaType.APPLICATION_JSON)), playListHandler::findAll)
                .andRoute(GET("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)), playListHandler::findById)
                .andRoute(GET("/playlist/{genero}").and(accept(MediaType.APPLICATION_JSON)), playListHandler::findByGenero)
                .andRoute(POST("/playlist").and(accept(MediaType.APPLICATION_JSON)), playListHandler::save)
                .andRoute(DELETE("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)), playListHandler::remover);

    }
}
