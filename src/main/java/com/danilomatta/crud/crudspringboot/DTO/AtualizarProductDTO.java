package com.danilomatta.crud.crudspringboot.DTO;

import jakarta.validation.constraints.NotBlank;

public record AtualizarProductDTO(@NotBlank String nome, @NotBlank String descricao) {
}
