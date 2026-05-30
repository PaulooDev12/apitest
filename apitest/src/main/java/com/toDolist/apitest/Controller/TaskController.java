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
}
