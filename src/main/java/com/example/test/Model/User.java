package com.example.test.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    String id;
    String name;

    public User(String name) {
        this.name = name;
    }
}
