package com.KushagraBhaskar.ToDo_App.Services;

import java.util.List;

import com.KushagraBhaskar.ToDo_App.Dtos.AddUserRequestDto;
import com.KushagraBhaskar.ToDo_App.Dtos.UserDto;

public interface UserServices {
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserDto addUser(AddUserRequestDto addUserRequestDto);
    void deleteUser(Long id);
    UserDto updateUser(Long Id, AddUserRequestDto addUserRequestDto);
}
