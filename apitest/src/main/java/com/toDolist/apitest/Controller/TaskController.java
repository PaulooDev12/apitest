package com.toDolist.apitest.Controller;

import com.toDolist.apitest.Dto.TaskReqDto;
import com.toDolist.apitest.Dto.TaskResDto;
import com.toDolist.apitest.Model.TaskModel;
import com.toDolist.apitest.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/post")
    public ResponseEntity<TaskModel> post(@Valid @RequestBody TaskReqDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(dto));
    }

    @GetMapping("/lista")
    public ResponseEntity<List<TaskResDto>> lista() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll());
    }

    @GetMapping("/buscarid:{id}")
    public ResponseEntity<TaskResDto> get(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
    }

    @PutMapping("/editar:{id}")
    public ResponseEntity<TaskModel> put(@PathVariable Long id, @Valid @RequestBody TaskReqDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(id, dto));
    }

    @DeleteMapping("/deletar:{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/buscarnome:{nome}")
    public ResponseEntity<List<TaskResDto>> findByNome(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findByNomeContaing(nome));
    }
    @GetMapping("/buscardescricao:{descricao}")
    public ResponseEntity<List<TaskResDto>> findByDescricao(@PathVariable String descricao) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findByDescricaoContaining(descricao));
    }
}