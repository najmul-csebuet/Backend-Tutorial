package com.onssoftware.DataJpaTutorial.OneToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    //@OneToOne(mappedBy = "address")
    //private Account account;
}
