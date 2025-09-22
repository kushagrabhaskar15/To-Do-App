package com.KushagraBhaskar.ToDo_App.Services;

import com.KushagraBhaskar.ToDo_App.Dtos.UserDtoInput;

import java.util.List;

public interface UserServices {
    List<UserDtoInput> getAllUsers();
}
