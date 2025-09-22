package com.KushagraBhaskar.ToDo_App.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToDoRequestDto {
    private long userId;
    private String heading;
    private String description;
    private boolean completed = false;
}