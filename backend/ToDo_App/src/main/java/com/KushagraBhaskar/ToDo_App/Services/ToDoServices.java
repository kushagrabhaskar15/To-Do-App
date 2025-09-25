package com.KushagraBhaskar.ToDo_App.Services;

import com.KushagraBhaskar.ToDo_App.Dtos.ToDoInputDto;
import com.KushagraBhaskar.ToDo_App.Dtos.ToDoOutputDto;

import java.util.List;

public interface ToDoServices {
    List<ToDoOutputDto> getToDos();
    List<ToDoOutputDto> getToDoByHeading(String heading);
    ToDoOutputDto addTodo(ToDoInputDto toDoInputDto);
    void deleteToDo(Long id);

}
