package com.KushagraBhaskar.ToDo_App.Services.impl;

import com.KushagraBhaskar.ToDo_App.Dtos.ToDoInputDto;
import com.KushagraBhaskar.ToDo_App.Dtos.ToDoOutputDto;
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
    public List<ToDoOutputDto> getToDos() {
        List<ToDos> allToDos = toDoRepository.findAll();
        return allToDos
                .stream()
                .map(toDos -> modelMapper.map(allToDos, ToDoOutputDto.class))
                .toList();
    }

    @Override
    public List<ToDoOutputDto> getToDoByHeading(String heading){
        return  toDoRepository.findAllByHeadingEqualsIgnoreCase(heading)
                .stream()
                .map(toDos -> modelMapper.map(toDos, ToDoOutputDto.class))
                .toList();
    }

    @Override
    public ToDoOutputDto addTodo(ToDoInputDto toDoInputDto){
        ToDos toDos = modelMapper.map(toDoInputDto,ToDos.class);
        ToDos newToDos = toDoRepository.save(toDos);
        return modelMapper.map(newToDos, ToDoOutputDto.class);
    }

    @Override
    public void deleteToDo(Long id) {
        if(!toDoRepository.existsById(id)){
            throw new IllegalArgumentException("The Todo Does Not Exist");
        }
        toDoRepository.deleteById(id);
    }

}