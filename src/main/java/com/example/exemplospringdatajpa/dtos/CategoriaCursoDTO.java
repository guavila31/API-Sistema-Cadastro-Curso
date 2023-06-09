package com.example.exemplospringdatajpa.dtos;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaCursoDTO {
    
    private Long id;
    private String nome;
}
