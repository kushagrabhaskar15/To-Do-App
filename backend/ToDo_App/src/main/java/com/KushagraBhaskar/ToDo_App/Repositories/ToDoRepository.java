package com.KushagraBhaskar.ToDo_App.Repositories;

import com.KushagraBhaskar.ToDo_App.Entities.ToDos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDos, Long> {
    List<ToDos> findAllByHeadingEqualsIgnoreCase(String heading);
}
