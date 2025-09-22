package com.KushagraBhaskar.ToDo_App.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ToDos {

    @Id
    private long toDoId;
    private long userId;
    private String heading;
    private String description;
    private boolean completed;
}
