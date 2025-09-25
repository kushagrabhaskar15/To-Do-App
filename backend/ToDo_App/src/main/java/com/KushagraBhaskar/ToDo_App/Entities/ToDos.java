package com.KushagraBhaskar.ToDo_App.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "to_dos")
public class ToDos {

    @Id
    private long toDoId;
    private String heading;
    private String description;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name="user_id",
                nullable = false)
    private User user;
}
