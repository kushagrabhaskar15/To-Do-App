package com.KushagraBhaskar.ToDo_App.Services.impl;

import com.KushagraBhaskar.ToDo_App.Dtos.ToDoDto;
import com.KushagraBhaskar.ToDo_App.Entities.ToDos;
import com.KushagraBhaskar.ToDo_App.Repositories.ToDoRepository;
import com.KushagraBhaskar.ToDo_App.Services.ToDoServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoServices {

    public final ToDoRepository toDoRepository;
    public final ModelMapper modelMapper;

    @Override
    List<ToDoDto> getToDos(Long Id){
        List<ToDos> allToDos = toDoRepository.findAll();
        return   allToDos
                .stream()
                .map(todo->modelMapper.map(allToDos, ToDoDto.class))
                .toList();
    }
}
