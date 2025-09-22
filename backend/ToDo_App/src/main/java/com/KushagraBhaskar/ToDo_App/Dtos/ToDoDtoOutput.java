package com.KushagraBhaskar.ToDo_App.Dtos;

import lombok.Data;

@Data
public class ToDoDtoOutput {
    private long id;
    private long userId;
    private String heading;
    private String description;
    private boolean completed = false;
}
