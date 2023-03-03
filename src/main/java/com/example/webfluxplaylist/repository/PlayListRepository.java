package com.example.webfluxplaylist.repository;

import com.example.webfluxplaylist.domain.PlayList;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlayListRepository extends ReactiveMongoRepository<PlayList, String> {
}
