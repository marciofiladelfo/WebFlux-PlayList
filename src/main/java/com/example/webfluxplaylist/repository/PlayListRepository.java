package com.example.webfluxplaylist.repository;

import com.example.webfluxplaylist.domain.PlayList;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface PlayListRepository extends ReactiveMongoRepository<PlayList, String> {

    Flux<PlayList> findByGenero(String genero);

}
