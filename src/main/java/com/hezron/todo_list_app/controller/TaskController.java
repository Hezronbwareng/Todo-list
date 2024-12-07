package com.hezron.todo_list_app.controller;


import com.hezron.todo_list_app.model.TodoItem;
import com.hezron.todo_list_app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TaskController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<TodoItem> getAllTodos(){
        return todoService.findAll();
    }

    @PostMapping
    public TodoItem createTodo(@RequestBody TodoItem todoItem){
        return todoService.save(todoItem);
    }

    @GetMapping("/{id}")
    public TodoItem getTodoById(@PathVariable Long id){
        return todoService.findById(id);
    }

    @PostMapping("/{id}")
    public TodoItem updateTodo(@PathVariable Long id, @RequestBody TodoItem todoItem){
        TodoItem existingTodo = todoService.findById(id);
        if(existingTodo != null){
            existingTodo.setTitle(todoItem.getTitle());
            existingTodo.setDescription(todoItem.getDescription());
            existingTodo.setCompleted(todoItem.isCompleted());

            return todoService.save(existingTodo);
        } else {
            throw new RuntimeException("Todo item not found for ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteById(id);
    }

}
