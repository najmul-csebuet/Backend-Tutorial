package com.onssoftware.RelationalDbExercise.model;

import lombok.AllArgsConstructor;
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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String houseNo;
    private String road;
    private String city;

    @ManyToOne
    private MyUser myUser;

    public Address(String houseNo, String road, String city) {
        this.houseNo = houseNo;
        this.road = road;
        this.city = city;
    }
}
