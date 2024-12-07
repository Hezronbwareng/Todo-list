package com.hezron.todo_list_app.repository;

import com.hezron.todo_list_app.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
