package com.example.tipico.Tipico.Config;

import com.example.tipico.Tipico.Model.Task;
import com.example.tipico.Tipico.Repository.TaskRepository;

import java.util.List;

public class SetupConfig {

    public Task task;

    public Task task2;

    public void setupTasks(TaskRepository taskRepository) {
        task = new Task(
                "Talla hij",
                10L
        );

        task2 = new Task(
                "Tal exx l ustja hij",
                20L
        );

        taskRepository.saveAll(List.of(task, task2));
    }
}
