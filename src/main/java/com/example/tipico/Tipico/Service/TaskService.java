package com.example.tipico.Tipico.Service;

import com.example.tipico.Tipico.Exceptions.InvalidTaskException;
import com.example.tipico.Tipico.Exceptions.TaskNotFoundException;
import com.example.tipico.Tipico.Repository.TaskRepository;
import com.example.tipico.Tipico.Model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task findTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findTaskById(id);
        return optionalTask.orElse(null);
    }

    public List<com.example.tipico.Tipico.Model.Task> findAll() {
        return taskRepository.findAll();
    }

    public Task save(Task task) {
        // Additional business logic/validation can be added here before saving
        return taskRepository.save(task);
    }



    public Task updateTask(Long taskId, String description, Long priority) {

        Task task = taskRepository.findTaskById(taskId).orElseThrow(() -> new TaskNotFoundException("Task with id " + taskId + " does not exist!"));

        validateTaskFields(description);

        task.setDescription(description);
        task.setPriority(priority);

        return taskRepository.save(task);
    }

    private void validateTaskFields(String description) {
        if (description == null) {
            throw new InvalidTaskException("Task description is required");
        }
    }


}
