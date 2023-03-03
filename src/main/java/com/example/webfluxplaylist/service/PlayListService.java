package com.example.webfluxplaylist.service;

import com.example.webfluxplaylist.domain.PlayList;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayListService {

    Flux<PlayList> findAll();
    Flux<PlayList>findByGenero(String genero);
    Mono<PlayList> findById(String id);
    Mono<PlayList> save(PlayList playList);
    Mono<Void> remover(String id);
}
