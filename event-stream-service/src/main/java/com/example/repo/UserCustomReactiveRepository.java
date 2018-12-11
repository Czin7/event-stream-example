package com.example.repo;


import com.example.aop.LogExecutionTime;
import com.example.model.UserCreationEvent;

import com.example.constants.UserCreationEventConstans;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Date;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserCustomReactiveRepository {
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @LogExecutionTime
    public Flux<UserCreationEvent> findAllBetween(Date from, Date to) {
        Query query = new Query();
        Criteria criteria = Criteria.where(UserCreationEventConstans.DATE).lt(to).gt(from);
        query.addCriteria(criteria);
        return reactiveMongoTemplate.find(query, UserCreationEvent.class);
    }

}
