package com.example.webfluxplaylist.service;

import com.example.webfluxplaylist.domain.PlayList;
import com.example.webfluxplaylist.repository.PlayListRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayListServiceImpl implements PlayListService{

    private final PlayListRepository repository;

    public PlayListServiceImpl(PlayListRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<PlayList> findAll() {
        return repository.findAll();
    }

    @Override
    public Flux<PlayList> findByGenero(String genero) {
        var list = this.findAll();
        return list.filter(element -> element.getGenero().equals(genero));
    }

    @Override
    public Mono<PlayList> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<PlayList> save(PlayList playList) {
        return repository.save(playList);
    }

    @Override
    public Mono<Void> remover(String id) {
        return repository.deleteById(id);
    }
}
