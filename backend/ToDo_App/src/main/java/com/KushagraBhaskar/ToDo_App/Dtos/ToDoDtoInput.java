package com.KushagraBhaskar.ToDo_App.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToDoDtoInput {
    private long id;
    private long userId;
    private String heading;
    private String description;
    private boolean completed = false;
}