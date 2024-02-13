package com.danilomatta.crud.crudspringboot.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(@NotBlank String nome, @NotBlank String descricao, @NotNull double preco) {
}
