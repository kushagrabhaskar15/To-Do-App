package com.KushagraBhaskar.ToDo_App.Services.impl;

import com.KushagraBhaskar.ToDo_App.Dtos.UserInputDto;
import com.KushagraBhaskar.ToDo_App.Dtos.UserOutputDto;
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
    public List<UserOutputDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return   users
                .stream()
                .map(user -> modelMapper.map(user, UserOutputDto.class))
                .toList();
    }

    @Override
    public UserOutputDto getUserById(Long Id){
        User user =  userRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("User Not Found with the entered Id: "+Id+"!"));
        return  modelMapper.map(user, UserOutputDto.class);
    }

    @Override
    public UserOutputDto addUser(UserInputDto userInputDto){
        User user = modelMapper.map(userInputDto, User.class);
        User newUser = userRepository.save(user);
        return modelMapper.map(newUser, UserOutputDto.class);
    }

    @Override
    public void deleteUser(Long Id){
        if(!userRepository.existsById(Id)){
            throw new IllegalArgumentException("User With this Id does not Exist!");
        }
        userRepository.deleteById(Id);
    }

    @Override
    public UserOutputDto updateUser(Long Id, UserInputDto newUser){
        User existingUser = userRepository.findById(Id)
                            .orElseThrow(()-> new IllegalArgumentException("No User with such id!"));

        existingUser.setUserName(newUser.getUserName());
        existingUser.setName(newUser.getName());
        existingUser.setEmail(newUser.getEmail());
        return modelMapper.map(existingUser, UserOutputDto.class);
    }

    @Override
    public UserOutputDto updateUserMinorDetails(Long id, UserInputDto user) {
        return null;
    }

}
