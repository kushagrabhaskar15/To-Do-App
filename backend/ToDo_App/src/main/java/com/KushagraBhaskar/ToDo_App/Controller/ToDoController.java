package com.KushagraBhaskar.ToDo_App.Controller;

import com.KushagraBhaskar.ToDo_App.Dtos.ToDoInputDto;
import com.KushagraBhaskar.ToDo_App.Dtos.ToDoOutputDto;
import com.KushagraBhaskar.ToDo_App.Services.ToDoServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class ToDoController {

    public final ToDoServices toDoServices;

    @GetMapping
    ResponseEntity<List<ToDoOutputDto>> getTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(toDoServices.getToDos());
    }

    @GetMapping("/{heading}")
    ResponseEntity<List<ToDoOutputDto>> getToDoByHeading(@PathVariable String heading){
        return ResponseEntity.ok(toDoServices.getToDoByHeading(heading));
    }

    @PostMapping
    ResponseEntity<ToDoOutputDto> addTodo(@RequestBody ToDoInputDto toDoInputDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toDoServices.addTodo(toDoInputDto));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteToDo(@PathVariable Long id){
        toDoServices.deleteToDo(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
