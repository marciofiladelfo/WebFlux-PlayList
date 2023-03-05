package com.example.webfluxplaylist.routes;

import com.example.webfluxplaylist.domain.PlayList;
import com.example.webfluxplaylist.service.PlayListServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/** Chamadas da API usando estilo funcional */
@Component
public class PlayListHandler {

    private PlayListServiceImpl service;

    public PlayListHandler(PlayListServiceImpl playListService) {
        this.service = playListService;
    }

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), PlayList.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request){
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findById(id), PlayList.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        final Mono<PlayList> playListMono = request.bodyToMono(PlayList.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playListMono.flatMap(service::save), PlayList.class));
    }

    public Mono<ServerResponse> findByGenero(ServerRequest request){
        String genero = request.pathVariable("genero");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findByGenero(genero), PlayList.class);
    }

    public Mono<ServerResponse> remover(ServerRequest request){
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.remover(id), PlayList.class);
    }
}
