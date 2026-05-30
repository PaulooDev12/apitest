package com.toDolist.apitest.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskReqDto {
    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    private String nome;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @NotNull
    @NotBlank
    @Size(min = 2, max = 2000)
    private String descricao;
}
