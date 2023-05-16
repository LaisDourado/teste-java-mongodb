package com.laisdourado.testejava.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.laisdourado.testejava.domain.ListaTarefas;

@Repository
public interface ListaTarefaRepository extends MongoRepository<ListaTarefas, String>{

}

