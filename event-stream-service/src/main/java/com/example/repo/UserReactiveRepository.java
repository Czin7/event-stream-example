package com.example.repo;

import com.example.aop.LogExecutionTime;
import com.example.model.UserCreationEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Date;

@Repository
public interface UserReactiveRepository extends ReactiveMongoRepository<UserCreationEvent, String> {
    @Tailable
    public Flux<UserCreationEvent> findByLogin(String login);
    @LogExecutionTime
    public Flux<UserCreationEvent> findByDateBetween(Date from, Date to);

}
