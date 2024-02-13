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

    public Task getTask(Long taskId) {
        Task task = taskRepository.findTaskById(taskId).orElseThrow(() ->
                        new TaskNotFoundException("Task with id " + taskId + " does not exist!"));

        return task;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }


    public void deleteTask(Long taskId) {
        //Checks if task exists
        getTask(taskId);
        taskRepository.deleteById(taskId);
    }

    public Task updateTask(Long taskId, String description, Long priority) {

        Task task = taskRepository.findTaskById(taskId).orElseThrow(() -> new TaskNotFoundException("Task with id " + taskId + " does not exist!"));

        task.setDescription(description);
        task.setPriority(priority);

        return taskRepository.save(task);
    }

}
