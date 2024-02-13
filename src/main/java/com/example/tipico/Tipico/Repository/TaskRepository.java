package com.example.tipico.Tipico.Repository;

import com.example.tipico.Tipico.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


    Optional<Task> findTaskById(Long id);

}

