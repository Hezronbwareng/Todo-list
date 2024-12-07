package com.hezron.todo_list_app.service;

import com.hezron.todo_list_app.model.TodoItem;
import com.hezron.todo_list_app.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoItemRepository todoItemRepository;

    public List<TodoItem> findAll(){
        return todoItemRepository.findAll();
    }
    public TodoItem save(TodoItem todoItem){
        return todoItemRepository.save(todoItem);
    }
    public TodoItem findById(Long id){
        return todoItemRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        todoItemRepository.deleteById(id);

    }
}
