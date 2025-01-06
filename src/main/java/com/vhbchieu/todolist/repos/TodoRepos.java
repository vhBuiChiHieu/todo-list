package com.vhbchieu.todolist.repos;

import com.vhbchieu.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepos extends JpaRepository<Todo, Long> {
}
