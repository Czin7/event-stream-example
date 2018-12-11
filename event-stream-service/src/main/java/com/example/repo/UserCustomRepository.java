package com.example.repo;

import com.example.aop.LogExecutionTime;
import com.example.model.UserCreationEvent;
import com.example.constants.UserCreationEventConstans;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserCustomRepository {
    private MongoTemplate mongoTemplate;

    @LogExecutionTime
    public List<UserCreationEvent> findAllBetweenAsList(Date from, Date to) {
        Query query = new Query();
        Criteria criteria = Criteria.where(UserCreationEventConstans.DATE).lt(to).gt(from);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, UserCreationEvent.class);
    }
}
