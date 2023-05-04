package com.example.exemplospringdatajpa.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.stereotype.Service;

import com.example.exemplospringdatajpa.dtos.CategoriaCursoDTO;
import com.example.exemplospringdatajpa.dtos.CursoDTO;
import com.example.exemplospringdatajpa.dtos.DadosCursoDTO;
import com.example.exemplospringdatajpa.exceptions.RegraNegocioException;
import com.example.exemplospringdatajpa.models.CategoriaCurso;
import com.example.exemplospringdatajpa.models.Curso;
import com.example.exemplospringdatajpa.repositories.CategoriaCursoRepository;
import com.example.exemplospringdatajpa.repositories.CursoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final CategoriaCursoRepository categoriaCursoRepository;

    @Override
    @Transactional
    public Long inserir(CursoDTO cursoDTO) {
        CategoriaCurso categ = categoriaCursoRepository.findById(cursoDTO.getCategoriaCursoId())
                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));

        Curso curso = new Curso();
        curso.setNome(cursoDTO.getNome());
        curso.setCargaHoraria(cursoDTO.getCargaHoraria());
        curso.setCategoriaCurso(categ);

        Curso cursoGerado = cursoRepository.save(curso);
        return cursoGerado.getId();
    }

    @Override
    public DadosCursoDTO obterCursoPorId(Long id) {
        return cursoRepository.findById(id).map((Curso c) -> {
            return DadosCursoDTO.builder()
                    .id(c.getId())
                    .nome(c.getNome())
                    .cargaHoraria(c.getCargaHoraria())
                    .categoria(CategoriaCursoDTO.builder()
                            .id(c.getCategoriaCurso().getId())
                            .nome(c.getCategoriaCurso().getNome())
                            .build())
                    .build();
        })
                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado"));
    }

    @Override
    @Transactional
    public void remover(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void editar(Long id, CursoDTO dto) {
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Curso não encontrado"));
        CategoriaCurso categoriaCurso = categoriaCursoRepository.findById(dto.getCategoriaCursoId())
                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));
        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());
        curso.setCategoriaCurso(categoriaCurso);
        cursoRepository.save(curso);
    }

    @Override
    public List<DadosCursoDTO> obterTodos() {
        return cursoRepository.findAll().stream().map((Curso curso) -> {
            return DadosCursoDTO.builder()
                    .id(curso.getId())
                    .nome(curso.getNome())
                    .cargaHoraria(curso.getCargaHoraria())
                    .categoria(CategoriaCursoDTO.builder()
                            .id(curso.getCategoriaCurso().getId())
                            .nome(curso.getCategoriaCurso().getNome())
                            .build())
                    .build();
        }).collect(Collectors.toList());
    }
}
