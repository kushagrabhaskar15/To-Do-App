package com.KushagraBhaskar.ToDo_App.Services.impl;

import com.KushagraBhaskar.ToDo_App.Dtos.AddUserRequestDto;
import com.KushagraBhaskar.ToDo_App.Dtos.UserDto;
import com.KushagraBhaskar.ToDo_App.Entities.User;
import com.KushagraBhaskar.ToDo_App.Repositories.UserRepository;
import com.KushagraBhaskar.ToDo_App.Services.UserServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServices {

    public final UserRepository userRepository;
    public final ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return   users
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();
    }

    @Override
    public UserDto getUserById(Long Id){
        User user =  userRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("User Not Found with the entered Id: "+Id+"!"));
        return  modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto addUser(AddUserRequestDto addUserRequestDto){
        User user = modelMapper.map(addUserRequestDto, User.class);
        User newUser = userRepository.save(user);
        return modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long Id){
        if(!userRepository.existsById(Id)){
            throw new IllegalArgumentException("User With this Id does not Exist!");
        }
        userRepository.deleteById(Id);
    }

}
