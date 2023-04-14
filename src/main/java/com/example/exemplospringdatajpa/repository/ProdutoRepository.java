package com.example.exemplospringdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.exemplospringdatajpa.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    // @Query("select p from Produto p where p.preco > :preco ")
    // Produto findProdutoMaioresQue(@Param("preco") Double preco);

    Produto findByPrecoGreaterThan(Double preco);
    Produto findByPrecoLessThan(Double preco);

    // Produto findByPrecoGreaterLessThan(Double preco);
    
}
