package com.KushagraBhaskar.ToDo_App.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequestDto {
    private String userName;
    private String name;
    private String email;
}
