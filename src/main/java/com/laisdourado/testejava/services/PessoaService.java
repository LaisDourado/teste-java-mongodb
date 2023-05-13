package com.laisdourado.testejava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laisdourado.testejava.domain.Pessoa;
import com.laisdourado.testejava.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
	public List<Pessoa> findAll(){
		return repo.findAll();
	}
}
