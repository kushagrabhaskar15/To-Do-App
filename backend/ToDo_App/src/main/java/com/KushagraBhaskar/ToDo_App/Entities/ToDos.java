package com.KushagraBhaskar.ToDo_App.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDos {

    @Id
    private long id;

    private long userId;
    private String heading;
    private String description;
    private boolean completed;
}
