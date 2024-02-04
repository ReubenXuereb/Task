package com.example.tipico.Tipico.Controller;

import com.example.tipico.Tipico.Service.TaskService;
import com.example.tipico.Tipico.Model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }



    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId,
                                           @RequestBody(required = true) String description,
                                           @RequestBody Long priority) {

        Task updatedTaskResult = taskService.updateTask(taskId, description, priority);
        return ResponseEntity.ok(updatedTaskResult);

    }
}
