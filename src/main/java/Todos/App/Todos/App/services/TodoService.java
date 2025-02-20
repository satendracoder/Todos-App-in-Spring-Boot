package Todos.App.Todos.App.services;

import Todos.App.Todos.App.dto.TodoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {

    TodoDto createTodo(TodoDto todoDto);
    List<TodoDto> getAllTodos();
    TodoDto getTodoById(Long id);
    TodoDto updateTodo(Long id, TodoDto todoDto);
    void deleteTodoById(Long id);
}
