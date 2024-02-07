package com.example.tipico.Tipico.Service;

import com.example.tipico.Tipico.Config.SetupConfig;
import com.example.tipico.Tipico.Repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class SetupService {

    private final TaskRepository taskRepository;

    public SetupService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void setupApplication() {
        SetupConfig setupConfig = new SetupConfig();
        setupConfig.setupTasks(taskRepository);
    }
}
