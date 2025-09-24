package com.KushagraBhaskar.ToDo_App.Repositories;

import com.KushagraBhaskar.ToDo_App.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {


}
