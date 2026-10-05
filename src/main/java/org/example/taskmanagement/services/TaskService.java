package org.example.taskmanagement.services;

import org.example.taskmanagement.exception.TaskNotFoundException;
import org.example.taskmanagement.modele.Task;
import org.example.taskmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Long id, Task updatedtask) throws TaskNotFoundException {
        Task existingTask = taskRepository.findById(id).orElseThrow(
                () -> new TaskNotFoundException(id)
        );
        existingTask.setTitle(updatedtask.getTitle());
        existingTask.setDescription(updatedtask.getDescription());
        existingTask.setPriority(updatedtask.getPriority());
        existingTask.setStatus(updatedtask.getStatus());
        existingTask.setDueDate(updatedtask.getDueDate());
        return taskRepository.save(existingTask);
    }
}
