package com.toDolist.apitest.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FuncionarioReqDto
        (@NotBlank
         @NotNull
         @Size(min = 2, max = 100)
         String nome,

         @NotNull
         @NotBlank
         @Size(min = 1, max = 100)
         String curso) {
}