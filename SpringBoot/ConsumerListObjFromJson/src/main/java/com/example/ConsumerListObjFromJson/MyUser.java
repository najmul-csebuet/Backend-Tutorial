package com.example.ConsumerListObjFromJson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MyUser {
    private int id;
    private String name;
    private int age;

    public MyUser(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private List<MyAccount> accountList;
}
