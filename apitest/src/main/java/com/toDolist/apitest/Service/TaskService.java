package com.toDolist.apitest.Service;

import com.toDolist.apitest.Dto.TaskMapper;
import com.toDolist.apitest.Dto.TaskReqDto;
import com.toDolist.apitest.Dto.TaskResDto;
import com.toDolist.apitest.Model.TaskModel;
import com.toDolist.apitest.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
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
    public TaskResDto findById(Long id) {
        TaskModel task = repository.findById(id).orElseThrow(() -> new RuntimeException("tarefa nao encontrada"));
        return TaskMapper.toDto(task);
    }

    public List<TaskResDto> findAll() {
        List<TaskModel> tasks = repository.findAll();
        return tasks.stream()
                .map(TaskMapper::toDto)
                .toList();
    }
    public List<TaskResDto> findByNomeContaing(String nome) {
        List<TaskModel> tasks = repository.findByNomeContaining(nome);
        return tasks.stream()
                .map(TaskMapper::toDto)
                .toList();
    }
    public List<TaskResDto> findByDescricaoContaining(String descricao) {
        List<TaskModel> tasks = repository.findByDescricaoContainingIgnoreCase(descricao);
        return tasks.stream()
                .map(TaskMapper::toDto)
                .toList();
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