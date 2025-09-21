package com.KushagraBhaskar.ToDo_App.Services.impl;

import com.KushagraBhaskar.ToDo_App.Dtos.UserDto;
import com.KushagraBhaskar.ToDo_App.Repositories.UserRepository;
import com.KushagraBhaskar.ToDo_App.Services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServices {

    public final UserRepository userRepository;
    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }
}
