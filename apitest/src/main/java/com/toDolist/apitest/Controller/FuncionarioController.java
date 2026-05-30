package com.toDolist.apitest.Controller;

import com.toDolist.apitest.Dto.FuncionarioReqDto;
import com.toDolist.apitest.Dto.FuncionarioResDto;
import com.toDolist.apitest.Model.FuncionarioModel;
import com.toDolist.apitest.Service.FunctionaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private FunctionaryService funcionarioService;

    public FuncionarioController(FunctionaryService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }
    @PostMapping("/postarcandidato")
    public ResponseEntity<FuncionarioModel> criar(FuncionarioReqDto funcionarioDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.salvar(funcionarioDto));
    }
    @GetMapping("/listarcandidatos")
    public ResponseEntity<List<FuncionarioResDto>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.listar());
    }
}
