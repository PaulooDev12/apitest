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
        task.setNome(dto.nome());
        task.setDescricao(dto.descricao());
        return repository.save(task);
    }
    public TaskModel findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("tarefa nao encontrada"));
    }

    public List<TaskResDto> findAll() {
        List<TaskModel> tasks = repository.findAll();
        return tasks.stream()
                .map(TaskMapper::toDto)
                .collect(Collectors.toList());
    }
    public TaskModel update(Long id, TaskReqDto dto) {
        TaskModel task = repository.findById(id).orElseThrow(() -> new RuntimeException("tarefa nao encontrada"));
        task.setNome(dto.nome());
        task.setDescricao(dto.descricao());
        return repository.save(task);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}