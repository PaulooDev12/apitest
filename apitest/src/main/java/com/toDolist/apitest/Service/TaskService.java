package com.toDolist.apitest.Service;

import com.toDolist.apitest.Model.TaskModel;
import com.toDolist.apitest.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository repository;
    public void setRepository(TaskRepository repository) {
        this.repository = repository;
    }
    public TaskModel save(TaskModel taskModel) {
        return repository.save(taskModel);
    }
    public TaskModel findById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
    public List<TaskModel> findAll() {
        return repository.findAll();
    }
}
