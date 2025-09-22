package com.KushagraBhaskar.ToDo_App.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDtoInput {
    private String userName;
    private String name;
    private String email;
}
