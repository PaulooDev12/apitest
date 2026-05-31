package com.toDolist.apitest.Controller;

import com.toDolist.apitest.Dto.FuncionarioReqDto;
import com.toDolist.apitest.Dto.FuncionarioResDto;
import com.toDolist.apitest.Model.FuncionarioModel;
import com.toDolist.apitest.Service.FunctionaryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FunctionaryService funcionarioService;

    public FuncionarioController(FunctionaryService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/postarcandidato")
    public ResponseEntity<FuncionarioModel> criar(@Valid @RequestBody FuncionarioReqDto funcionarioDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.salvar(funcionarioDto));
    }

    @GetMapping("/listarcandidatos")
    public ResponseEntity<List<FuncionarioResDto>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.listar());
    }
}