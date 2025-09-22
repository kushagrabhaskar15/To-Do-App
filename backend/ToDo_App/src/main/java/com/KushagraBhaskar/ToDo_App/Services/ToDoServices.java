package com.KushagraBhaskar.ToDo_App.Services;

import com.KushagraBhaskar.ToDo_App.Dtos.ToDoDto;

import java.util.List;

public interface ToDoServices {
    List<ToDoDto> getToDos(Long Id);
}
