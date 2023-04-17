package com.luv2code.cruddemo.entity;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

//jpa
@Entity
@Table(name = "student")
public class Student {

    //defines the fields
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



}
