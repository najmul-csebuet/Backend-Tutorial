package com.onssoftware.RelationalDbExercise.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

//    @OneToOne(orphanRemoval = true)
//    @OneToOne(cascade = {CascadeType.PERSIST})
//    @JoinColumn(name = "Bismillah", referencedColumnName = "id")
    @OneToMany(cascade = {CascadeType.PERSIST})
    private Set<Address> addressSet;

    public MyUser(String name, Address address) {
        this.name = name;
        this.addressSet = new HashSet<>(Collections.singletonList(address));
    }

    public MyUser(String name, List<Address> addressSet) {
        this.name = name;
        this.addressSet = new HashSet<>(addressSet);
    }
}
