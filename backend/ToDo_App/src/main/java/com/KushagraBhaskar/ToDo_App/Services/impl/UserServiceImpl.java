package com.KushagraBhaskar.ToDo_App.Services.impl;

import com.KushagraBhaskar.ToDo_App.Dtos.AddUserRequestDto;
import com.KushagraBhaskar.ToDo_App.Dtos.UserDto;
import com.KushagraBhaskar.ToDo_App.Entities.Users;
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
        List<Users> users = userRepository.findAll();
        return   users
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();
    }

    @Override
    public UserDto getUserById(Long Id){
        Users user =  userRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("User Not Found with the entered Id: "+Id+"!"));
        return  modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto addUser(AddUserRequestDto addUserRequestDto){
        Users user = modelMapper.map(addUserRequestDto, Users.class);
        Users newUser = userRepository.save(user);
        return modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long Id){
        if(!userRepository.existsById(Id)){
            throw new IllegalArgumentException("User With this Id does not Exist!");
        }
        userRepository.deleteById(Id);
    }

    @Override
    public UserDto updateUser(Long Id,AddUserRequestDto newUser){
        if(!userRepository.existsById(Id)){
            throw new IllegalArgumentException("User with this Id does not exist!");
        }

        Users existingUser = userRepository.findById(Id)
                            .orElseThrow(()-> new IllegalArgumentException("No User with such id!"));

        existingUser.setUserName(newUser.getUserName());
        existingUser.setName(newUser.getName());
        existingUser.setEmail(newUser.getEmail());
        return modelMapper.map(existingUser, UserDto.class);
    }

}
