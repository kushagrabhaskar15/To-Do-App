package com.KushagraBhaskar.ToDo_App.Controller;


import com.KushagraBhaskar.ToDo_App.Dtos.UserInputDto;
import com.KushagraBhaskar.ToDo_App.Dtos.UserOutputDto;
import com.KushagraBhaskar.ToDo_App.Services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    public final UserServices userServices;

    @GetMapping
    ResponseEntity<List<UserOutputDto>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userServices.getAllUsers());
    }

    @GetMapping("/{id}")
    ResponseEntity<UserOutputDto> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userServices.getUserById(id));
    }

    @PostMapping
    ResponseEntity<UserOutputDto> addUserData(@RequestBody UserInputDto userInputDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userServices.addUser(userInputDto));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userServices.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<UserOutputDto> updateUser(@PathVariable Long id,
                                             @RequestBody UserInputDto userInputDto){
        return ResponseEntity.status(HttpStatus.OK).body(userServices.updateUser(id, userInputDto));
    }


}
