package edu.ait.ma.jpaexample.controllers;

import edu.ait.ma.jpaexample.entities.Task;
import edu.ait.ma.jpaexample.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks-page")
    private Page<Task> getTaskByPage(Pageable pageable){
        Page<Task> taskPage = taskRepository.findAll(pageable);
        return taskPage;
    }

    @GetMapping("/tasks-list")
    private List<Task> getTaskByList(){
        List<Task> taskPage = taskRepository.findAll();
        return taskPage;
    }

    @GetMapping("/tasks-slice")
    private Slice<Task> getTaskBySlice(Pageable pageable){
        Slice<Task> taskPage = taskRepository.findByDescriptionLike("%Test%",pageable);
        return taskPage;
    }

    @GetMapping("/tasks-by-priority")
    private List<Task> getTaskByPriority(){
        List<Task> taskPage = taskRepository.findByPriority(1, Sort.by("targetDate").descending());
        return taskPage;
    }
}
