package com.toDolist.apitest.Service;

import com.toDolist.apitest.Dto.TaskMapper;
import com.toDolist.apitest.Dto.TaskReqDto;
import com.toDolist.apitest.Dto.TaskResDto;
import com.toDolist.apitest.Model.TaskModel;
import com.toDolist.apitest.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }
    public TaskModel save(TaskReqDto dto) {
        TaskModel task = new TaskModel();
        task.setNome(dto.getNome());
        task.setDescricao(dto.getDescricao());
        return repository.save(task);
    }
    public TaskModel findById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<TaskResDto> findAll() {
        List<TaskModel> tasks = repository.findAll();
        return tasks.stream()
                .map(TaskMapper::toDto)
                .collect(Collectors.toList());
    }
}
