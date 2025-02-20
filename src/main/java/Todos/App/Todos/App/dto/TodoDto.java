package Todos.App.Todos.App.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
}
