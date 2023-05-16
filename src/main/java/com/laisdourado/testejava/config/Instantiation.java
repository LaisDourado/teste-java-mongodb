package com.laisdourado.testejava.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.laisdourado.testejava.domain.ListaTarefas;
import com.laisdourado.testejava.domain.Pessoa;
import com.laisdourado.testejava.dto.proprietarioDTO;
import com.laisdourado.testejava.repository.ListaTarefaRepository;
import com.laisdourado.testejava.repository.PessoaRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ListaTarefaRepository listaTarefaRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		pessoaRepository.deleteAll();
		listaTarefaRepository.deleteAll();
		
		Pessoa natalia = new Pessoa(null,"Natalia Silva","Administrativo");
		Pessoa mario = new Pessoa(null,"Mario Cezar","Finaceiro");
		Pessoa cassandra = new Pessoa(null,"Cassandra Sousa","Administrativo");

		pessoaRepository.saveAll(Arrays.asList(natalia, mario, cassandra));
		
		ListaTarefas lista1 = new ListaTarefas(null,sdf.parse("15/05/2023"), "Teste1 - Java", "Criação de tarefas", new proprietarioDTO(mario));
		ListaTarefas lista2 = new ListaTarefas(null,sdf.parse("14/05/2023"), "Teste2 - Java", "Alteração de tarefas",new proprietarioDTO(mario));
		
		listaTarefaRepository.saveAll(Arrays.asList(lista1, lista2));
	}
		
}
