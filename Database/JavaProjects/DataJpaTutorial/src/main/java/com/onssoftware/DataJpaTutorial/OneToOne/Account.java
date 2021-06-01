package com.onssoftware.DataJpaTutorial.OneToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    //@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    //@OneToOne(cascade = {CascadeType.ALL})
    //@JoinColumn(name = "Test")
    @OneToOne(cascade = {CascadeType.ALL})
    private Address address;
}
