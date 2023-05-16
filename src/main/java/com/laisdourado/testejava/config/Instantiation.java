package com.laisdourado.testejava.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.laisdourado.testejava.domain.Pessoa;
import com.laisdourado.testejava.domain.Tarefa;
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
				
		Tarefa t1 = new Tarefa(null, "Java-criação de tabelas", "Criar duas tabelas", sdf.parse("16/05/2023"), "Financeiro", 20.00, mario, true);
		Tarefa t2= new Tarefa(null, "Java-edição de tabelas", "edite uma tabela", sdf.parse("12/05/2023"), "Financeiro", 4.00,  mario, true);
		Tarefa t3= new Tarefa(null, "Java-deleção de tabelas", "Delete duas tabelas", sdf.parse("05/05/2023"), "Administrativo", 10.00, cassandra, false);
		Tarefa t4= new Tarefa(null, "Java-atualização de tabelas", "Atualize seis tabelas", sdf.parse("15/05/2023"), "Administrativo", 12.00, natalia, false);
		
		listaTarefaRepository.saveAll(Arrays.asList(t1, t2,t3,t4));
	}
		
}
