package com.KushagraBhaskar.ToDo_App.Repositories;

import com.KushagraBhaskar.ToDo_App.Entities.ToDos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDos, Long> {
}
