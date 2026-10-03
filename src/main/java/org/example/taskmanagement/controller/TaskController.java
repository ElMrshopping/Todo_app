package org.example.taskmanagement.controller;

import org.example.taskmanagement.modele.Task;
import org.example.taskmanagement.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id).orElseThrow(
                () -> new RuntimeException("Task not found with id: " + id)
        );
    }

    @DeleteMapping("{id}")
    public void deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }
    @PutMapping("{id}")
    public Task updateTaskById(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }
    @PostMapping
    public void createTask(@RequestBody Task task) {
        taskService.createTask(task);
    }
}
