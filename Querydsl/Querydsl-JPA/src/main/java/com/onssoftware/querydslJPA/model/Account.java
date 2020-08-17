package com.onssoftware.querydslJPA.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Account {

    @Id
    private Long id;
    private String name;
}
