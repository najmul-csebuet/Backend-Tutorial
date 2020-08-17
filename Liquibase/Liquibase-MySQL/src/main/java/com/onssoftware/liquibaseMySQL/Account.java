package com.onssoftware.liquibaseMySQL;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Account {

    //https://thoughts-on-java.org/5-things-you-need-to-know-when-using-hibernate-with-mysql/
    /*
    If you’re working with a MySQL database, you should always use GenerationType.IDENTITY. It uses an autoincremented database column and is the most efficient approach available. You can do that by annotating your primary key attribute with @GeneratedValue(strategy = GenerationType.IDENTITY).
    * */
    @Id
//    @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name = "Najmul";
    private String address = "Mymensingh";
    private String testAddress = "Mymensingh";
}
