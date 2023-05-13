package com.laisdourado.testejava.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.laisdourado.testejava.domain.Pessoa;

@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, String>{

}
