package com.toDolist.apitest.Dto;

public class TaskResDto {
    private String nome;

    public TaskResDto(String descricao, String nome) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String descricao;
}
