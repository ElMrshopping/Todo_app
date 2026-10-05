package org.example.taskmanagement.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.taskmanagement.Enum.Priority;
import org.example.taskmanagement.Enum.Status;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    @NotBlank(message = "Title is required")
   private String title;
   private String description;
    @NotNull(message = "Status is required")
   @Enumerated(EnumType.STRING)
   private Status status;
    @NotNull(message = "Priority is required")
   @Enumerated(EnumType.STRING)
   private Priority priority;
   @Column(updatable = false)
   @CreationTimestamp
   private LocalDate creationDate;
   @NotNull(message = "Due date is required")
   @FutureOrPresent(message = "Due date cannot be in the past")
   private LocalDate dueDate;

    public Task() {

    }

    public Task(Long id, String title, String description, Status status, Priority priority,  LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }


}
