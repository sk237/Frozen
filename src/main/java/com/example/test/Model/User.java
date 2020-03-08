package com.example.test.Model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@Builder
@Getter
public class User {
    @Id
    String id;
    String name;
}
