package com.example.exemplospringdatajpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemplospringdatajpa.dtos.CursoDTO;
import com.example.exemplospringdatajpa.services.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long inserir (CursoDTO cursoDTO){
        return cursoService.inserir(cursoDTO);
    }

}
