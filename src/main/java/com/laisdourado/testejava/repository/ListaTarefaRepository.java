package com.laisdourado.testejava.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.laisdourado.testejava.domain.Tarefa;

@Repository
public interface ListaTarefaRepository extends MongoRepository<Tarefa, String>{

	List<Tarefa> findByTituloContainingIgnoreCase(String text);
	
	List<Tarefa> findByFinalizadoFalseAndPessoaAlocadaIsNull(Pageable page);
	
}

