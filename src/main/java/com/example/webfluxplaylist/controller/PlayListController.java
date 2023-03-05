package com.example.webfluxplaylist.controller;

import com.example.webfluxplaylist.domain.PlayList;
import com.example.webfluxplaylist.service.PlayListServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@RestController
@RequestMapping("/playlist")
@Slf4j
public class PlayListController {

    private final PlayListServiceImpl service;

    public PlayListController(PlayListServiceImpl playListService) {
        this.service = playListService;
    }

    Sinks.Many<PlayList> sinks = Sinks.many().replay().latest();

    @GetMapping
    public Flux<PlayList> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<PlayList>> buscarPorId(@PathVariable String id) {
        Mono<PlayList> buscar = service.findById(id);
        return buscar
                .map(element -> ResponseEntity.ok().body(element))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PlayList> salvar(@Valid @RequestBody PlayList playList) {
        return service.save(playList)
                .doOnNext(element -> sinks.tryEmitNext(element));
    }

    @GetMapping("/{genero}")
    public Flux<ResponseEntity<PlayList>> buscarPorGenero(@PathVariable String genero) {
        Flux<PlayList> buscar = service.findByGenero(genero);
        return buscar
                .map(element -> ResponseEntity.ok().body(element))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> apagar(@PathVariable String id) {
        return service.remover(id);
    }

}
