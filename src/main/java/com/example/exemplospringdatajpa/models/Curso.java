package com.example.exemplospringdatajpa.models;

import com.example.exemplospringdatajpa.validations.NomeCurso;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NomeCurso(message = "Nome inválido. [Exemplo curso01]")
    @Column(length = 200, nullable = false)
    private String nome;

    @Max(value=3000, message="Ch máximo é 3000")
    @Min(value=1000, message="Ch mínimo é 1000")
    @Column()
    private Integer cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "categoriaCurso_id")
    private CategoriaCurso categoriaCurso;

    // @OneToMany(mappedBy = "curso")
    // private List<Estudante> estudantes;

    

}
