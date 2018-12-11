package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
@AllArgsConstructor
public class UserCreationEvent {
    @Id
    private String id;
    private String login;
    private Date date;
}
