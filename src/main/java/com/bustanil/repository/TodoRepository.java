package com.bustanil.repository;

import com.bustanil.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("select count (id) from Todo where completed = false ")
    int countLeft();

    @Query("select count (id) from Todo where completed = true ")
    int countDone();

    @Query("select t from Todo t where t.completed = false ")
    List showActive();

    @Query("select t from Todo t where t.completed = true ")
    List showDone();

}
