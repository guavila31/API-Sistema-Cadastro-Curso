package com.example.exemplospringdatajpa.services;


import java.util.List;

import com.example.exemplospringdatajpa.dtos.CursoDTO;
import com.example.exemplospringdatajpa.dtos.DadosCursoDTO;

public interface CursoService {
    
    Long inserir(CursoDTO cursoDTO);
    DadosCursoDTO obterCursoPorId(Long id);

    void remover(Long id);
    void editar(Long id, CursoDTO dto);
    List<DadosCursoDTO> obterTodos();
}
