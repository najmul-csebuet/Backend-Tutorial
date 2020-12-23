package com.example.JpaAnnotationsDemo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ModelA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelA", fetch = FetchType.LAZY)
    private List<ModelB> list;

    public ModelA(String name) {
        this.name = name;
        list = new ArrayList<>();
    }
}
