package com.onssoftware.querydslMongo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Entity
@Document
@Getter
@Setter
public class Account {

    @Id
    private Long id;
    private String name;
}
