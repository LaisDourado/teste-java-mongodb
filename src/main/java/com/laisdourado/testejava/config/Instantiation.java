package com.laisdourado.testejava.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.laisdourado.testejava.domain.Pessoa;
import com.laisdourado.testejava.repository.PessoaRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public void run(String... args) throws Exception {
		pessoaRepository.deleteAll();
		Pessoa natalia = new Pessoa(null,"Natalia Silva","Administrativo");
		Pessoa mario = new Pessoa(null,"Mario Cezar","Finaceiro");
		Pessoa cassandra = new Pessoa(null,"Cassandra Sousa","Administrativo");
		
		pessoaRepository.saveAll(Arrays.asList(natalia, mario, cassandra));
	}
		
}
