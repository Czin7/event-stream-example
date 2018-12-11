package com.example.service;

import com.example.model.UserCreationEvent;
import com.example.repo.UserCustomReactiveRepository;
import com.example.repo.UserReactiveRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Date;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserCreationService {
    private UserReactiveRepository employeeRepository;
    private UserCustomReactiveRepository userCustomReactiveRepository;

    public Flux<UserCreationEvent> getUserByLogin(String login) {
        return employeeRepository.findByLogin(login);
    }

    public Flux<UserCreationEvent> getUserCreationEventsBetween(Date from, Date to) {
        return userCustomReactiveRepository.findAllBetween(from, to);
    }
}
