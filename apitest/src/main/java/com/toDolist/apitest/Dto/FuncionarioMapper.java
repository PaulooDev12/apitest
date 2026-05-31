package com.toDolist.apitest.Dto;

import com.toDolist.apitest.Model.FuncionarioModel;

public class FuncionarioMapper {

    public static FuncionarioResDto pDto(FuncionarioModel funcionario) {
        return new FuncionarioResDto(
                funcionario.getNome()
        );
    }
}