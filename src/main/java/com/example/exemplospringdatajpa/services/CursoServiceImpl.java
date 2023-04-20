package com.example.exemplospringdatajpa.services;

import org.springframework.stereotype.Service;

import com.example.exemplospringdatajpa.dtos.CursoDTO;
import com.example.exemplospringdatajpa.models.CategoriaCurso;
import com.example.exemplospringdatajpa.models.Curso;
import com.example.exemplospringdatajpa.repositories.CategoriaCursoRepository;
import com.example.exemplospringdatajpa.repositories.CursoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final CategoriaCursoRepository categoriaCursoRepository;

    @Override
    public Long inserir(CursoDTO cursoDTO) {
        CategoriaCurso categ = categoriaCursoRepository.findById(cursoDTO.getCategoriaCursoId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Curso curso = new Curso();
        curso.setNome(cursoDTO.getNome());
        curso.setCargaHoraria(cursoDTO.getCargaHoraria());
        curso.setCategoriaCurso(categ);

        Curso cursoGerado = cursoRepository.save(curso);
        return cursoGerado.getId();
    }

}
