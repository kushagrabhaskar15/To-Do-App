package com.KushagraBhaskar.ToDo_App.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOutputDto {
    private long id;
    private String userName;
    private String name;

    @Email
    @NotBlank(message = "email is required!")
    private String email;
}
