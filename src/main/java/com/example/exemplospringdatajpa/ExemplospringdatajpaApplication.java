package com.example.exemplospringdatajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.exemplospringdatajpa.models.CategoriaCurso;
import com.example.exemplospringdatajpa.models.Curso;
import com.example.exemplospringdatajpa.models.Produto;
import com.example.exemplospringdatajpa.repositories.CategoriaCursoRepository;
import com.example.exemplospringdatajpa.repositories.CursoRepository;
import com.example.exemplospringdatajpa.repositories.ProdutoRepository;

@SpringBootApplication
public class ExemplospringdatajpaApplication {

	@Bean
	public CommandLineRunner init(
		@Autowired CursoRepository cursoRepository,
		@Autowired CategoriaCursoRepository categoriaCursoRepository,
		@Autowired ProdutoRepository produtoRepository
		) {
		return args -> {
			// CategoriaCurso novaCategoria;
			// CategoriaCurso listarCategoria;
			
			// Curso novoCurso;
			// List<Curso> cursos;

			Produto listarProduto;
			Produto novoProduto;
			List<Produto> produtos;

			System.out.println("*** INSERINDO NOVO PRODUTO***");
			novoProduto = new Produto((long)0, "Sabre de Luz", 2800.00);
			novoProduto = produtoRepository.save(novoProduto);
			novoProduto = new Produto((long)0, "Esfera do Dragão", 7300.00);
			novoProduto = produtoRepository.save(novoProduto);

			// System.out.println("*** LISTAR TODOS OS PRODUTOS ***");
			// produtos = produtoRepository.findAll();
			// produtos.forEach(c -> {System.out.println("Produto: "+c.getNome());});

			System.out.println("*** LISTAR VALORES ACIMA DE 5000.00 ***");
			listarProduto = produtoRepository.findByPrecoGreaterThan(5000.00);
			System.out.println(listarProduto.getNome() + " | Valor: " + listarProduto.getPreco());

			System.out.println("*** LISTAR VALORES ACIMA DE 5000.00 ***");
			listarProduto = produtoRepository.findByPrecoLessThan(5000.00);
			System.out.println(listarProduto.getNome() + " | Valor: " + listarProduto.getPreco());

			System.out.println("*** ---------------------- || ---------------------- ***");

			// System.out.println("*** INSERINDO CATEGORIA CURSO ***");
			// novaCategoria = new CategoriaCurso((long)0, "Tecnologo", null);
			// novaCategoria = categoriaCursoRepository.save(novaCategoria);
			


			// System.out.println("*** INSERINDO CURSO ***");
			// novoCurso = new Curso((long) 0, "Analise e Desenvolvimento de Sistemas", 2100, novaCategoria);
			// novoCurso = cursoRepository.save(novoCurso);
			
			// novoCurso = new Curso((long) 1, "Jogos Digitais", 2100, novaCategoria);
			// novoCurso = cursoRepository.save(novoCurso);

			// System.out.println("*** LISTAR TODOS OS CURSO ***");
			// cursos = cursoRepository.findAll();
			// cursos.forEach(c -> {System.out.println(c.getNome());});
			
			// System.out.println("*** LISTAR POR NOME DO CURSO ***");
			// cursos = cursoRepository.findByNome("Jogos Digitais");
			// cursos.forEach(c -> {System.out.println("Curso:" + c.getNome());});
			
			// System.out.println("*** LISTAR POR NOME DO CURSO [LIKE] ***");
			// cursos = cursoRepository.findByNomeLike("A%");
			// cursos.forEach(c -> {System.out.println("Curso:" + c.getNome());});
			
			// System.out.println("*** LISTAR CATEGORIA 1 ***");
			// listarCategoria = categoriaCursoRepository.findCategoriaCursoFetchCursos((long) 1);
			// System.out.println(listarCategoria.getNome() + " | Cursos: " + listarCategoria.getCursos());
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ExemplospringdatajpaApplication.class, args);
	}

}
