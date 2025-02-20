package Todos.App.Todos.App.services;

import Todos.App.Todos.App.dto.TodoDto;
import Todos.App.Todos.App.entities.TodoEntity;
import Todos.App.Todos.App.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        TodoEntity todo = new TodoEntity(
                null,
                todoDto.getTitle(),
                todoDto.getDescription(),
                todoDto.isCompleted()
        );
        todo = todoRepository.save(todo);
        return new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getCompleted()
        );
    }

    @Override
    public List<TodoDto> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(todo -> new TodoDto(
                        todo.getId(),
                        todo.getTitle(),
                        todo.getDescription(),
                        todo.getCompleted()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto getTodoById(Long id) {
        TodoEntity todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        return new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getCompleted()
        );
    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {
        TodoEntity todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());
        todo = todoRepository.save(todo);
        return new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getCompleted()
        );
    }

    @Override
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}
