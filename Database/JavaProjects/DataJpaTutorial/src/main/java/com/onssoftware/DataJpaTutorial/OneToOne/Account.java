package com.onssoftware.DataJpaTutorial.OneToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotEmpty(message = "Name can't be empty")
    private String name;

    //@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    //@OneToOne(cascade = {CascadeType.ALL})
    //@JoinColumn(name = "Test")
    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @NotBlank
    @Column(name = "address", nullable = false)
    private Address address;
}
