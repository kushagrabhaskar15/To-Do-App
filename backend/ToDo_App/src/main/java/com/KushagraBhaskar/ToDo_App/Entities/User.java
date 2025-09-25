package com.KushagraBhaskar.ToDo_App.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String Name;

    @Email
    private String email;

    @OneToMany(mappedBy = "user")
    private List<ToDos> toDosList;
}
