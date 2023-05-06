package com.example.exemplospringdatajpa.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.exemplospringdatajpa.constraint.NomeCursoConstraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NomeCursoConstraint.class)
public @interface NomeCurso {
    String message() default "Nome do curso fora do padrão";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
