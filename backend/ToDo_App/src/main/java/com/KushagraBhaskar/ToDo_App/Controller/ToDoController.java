package com.KushagraBhaskar.ToDo_App.Controller;

import com.KushagraBhaskar.ToDo_App.Repositories.ToDoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ToDoController {

    public final ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/")
    String Hello(){
        return "Chal Gaya!";
    }
}
