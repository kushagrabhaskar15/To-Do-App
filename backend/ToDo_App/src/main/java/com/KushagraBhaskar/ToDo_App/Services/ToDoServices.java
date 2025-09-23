package com.KushagraBhaskar.ToDo_App.Services;

import com.KushagraBhaskar.ToDo_App.Dtos.AddToDoRequestDto;
import com.KushagraBhaskar.ToDo_App.Dtos.ToDoDto;

import java.util.List;

public interface ToDoServices {
    List<ToDoDto> getToDos();
    List<ToDoDto> getToDoByHeading(String heading);
    ToDoDto addTodo(AddToDoRequestDto addToDoRequestDto);
    void deleteToDo(Long id);

}
