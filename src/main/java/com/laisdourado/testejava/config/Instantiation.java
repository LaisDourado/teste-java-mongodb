package com.laisdourado.testejava.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.laisdourado.testejava.domain.ListaTarefas;
import com.laisdourado.testejava.domain.Pessoa;
import com.laisdourado.testejava.dto.TarefasDTO;
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
		
		TarefasDTO t1 = new TarefasDTO(null, "Java-criação de tabelas", "Criar duas tabelas", sdf.parse("16/05/2023"), "Financeiro", 20.00, new proprietarioDTO(cassandra), "Finalizado");
		TarefasDTO t2 = new TarefasDTO(null, "Java-edição de tabelas", "edite uma tabela", sdf.parse("12/05/2023"), "Financeiro", 4.00, new proprietarioDTO(mario), "Finalizado");
		TarefasDTO t3 = new TarefasDTO(null, "Java-deleção de tabelas", "Delete duas tabelas", sdf.parse("05/05/2023"), "Administrativo", 10.00, new proprietarioDTO(natalia), "Pendente");
		TarefasDTO t4 = new TarefasDTO(null, "Java-atualização de tabelas", "Atualize seis tabelas", sdf.parse("15/05/2023"), "Administrativo", 12.00, null, "Pendente");
		
		lista1.getTarefas().addAll(Arrays.asList(t1,t2,t4));
		lista2.getTarefas().addAll(Arrays.asList(t3));

		listaTarefaRepository.saveAll(Arrays.asList(lista1, lista2));
		
		mario.getListaTarefas().addAll(Arrays.asList(lista1,lista2));
		pessoaRepository.save(mario);
	}
		
}
