package org.example.taskmanagement.repository;

import org.example.taskmanagement.modele.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
