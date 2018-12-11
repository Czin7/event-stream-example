package com.example.scheduler;

import com.example.model.UserCreationEvent;
import com.example.repo.UserReactiveRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CreateFakeLoginEvent {
    private static final Logger logger = LoggerFactory.getLogger(CreateFakeLoginEvent.class);
    private UserReactiveRepository userReactiveRepository;

    @Scheduled(fixedRate = 1000L)
    public void createUserCreationEvent() {
        UserCreationEvent userCreationEvent = new UserCreationEvent(null, "Wojtek", new Date());
        userReactiveRepository.save(userCreationEvent).subscribe(event ->
            logger.info("UserCreationEvent {} has been saved to mongodb.", userCreationEvent)
        );
    }

}


