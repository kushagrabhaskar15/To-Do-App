package com.KushagraBhaskar.ToDo_App.Services;

import java.util.List;

import com.KushagraBhaskar.ToDo_App.Dtos.UserInputDto;
import com.KushagraBhaskar.ToDo_App.Dtos.UserOutputDto;

public interface UserServices {
    List<UserOutputDto> getAllUsers();
    UserOutputDto getUserById(Long id);
    UserOutputDto addUser(UserInputDto userInputDto);
    void deleteUser(Long id);
    UserOutputDto updateUser(Long Id, UserInputDto userInputDto);
    UserOutputDto updateUserMinorDetails(Long id, UserInputDto user);
}
