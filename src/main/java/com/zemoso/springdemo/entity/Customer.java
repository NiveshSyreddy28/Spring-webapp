package com.zemoso.springdemo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public @Data class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Customer() {
    }
}
