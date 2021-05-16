package com.onssoftware.RelationalDbExercise.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

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
    @OneToOne(cascade = {CascadeType.PERSIST})
//    @JoinColumn(name = "Bismillah", referencedColumnName = "id")
    private Address address;

    public MyUser(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
