package com.example.exemplospringdatajpa.dtos;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaCursoDTO {
    
    private Long id;
    private String nome;
}
