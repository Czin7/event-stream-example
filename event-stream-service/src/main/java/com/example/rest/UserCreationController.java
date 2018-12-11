package com.example.rest;

import com.example.model.UserCreationEvent;
import com.example.service.UserCreationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Date;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserCreationController {
    private UserCreationService userCreationService;

    @CrossOrigin
    @GetMapping(value = "/userCreationEvent/{login}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<UserCreationEvent> getUserByLogin(@PathVariable(value = "login") String login) {
        return userCreationService.getUserByLogin(login);
    }

    @CrossOrigin
    @GetMapping(value = "/userCreationEvent/between/{from}/{to}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<UserCreationEvent> getUserCreationEventsBetween(@PathVariable(value = "from") Date from, @PathVariable(value = "to") Date to) {
        return userCreationService.getUserCreationEventsBetween(from, to);
    }
}
