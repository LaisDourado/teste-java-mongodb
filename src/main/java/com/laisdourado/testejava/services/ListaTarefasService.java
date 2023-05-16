package com.laisdourado.testejava.services;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.laisdourado.testejava.domain.Pessoa;
import com.laisdourado.testejava.domain.Tarefa;
import com.laisdourado.testejava.dto.TarefasDTO;
import com.laisdourado.testejava.repository.ListaTarefaRepository;
import com.laisdourado.testejava.services.exception.ObjectNotFoundException;

@Service
public class ListaTarefasService {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	@Autowired
	private ListaTarefaRepository repo;
	
	@Autowired
	private PessoaService pessoaService;
	
	public Tarefa findById(String id) {
		Optional<Tarefa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Tarefa> findbytitle(String text){
		return repo.findByTituloContainingIgnoreCase(text);
	}
	
	public Tarefa insert(Tarefa obj) {
		return repo.insert(obj);
	}

	public Tarefa fromDTO(TarefasDTO objDto) {
		Pessoa pessoa = pessoaService.findById(objDto.getIdPessoaAlocada());
		return new Tarefa(objDto.getId(), 
							objDto.getTitulo(), 
							objDto.getDescricao(), 
							objDto.getPrazo(), 
							objDto.getDepartamento(), 
							objDto.getDuracao(), 
							pessoa, 
							objDto.isFinalizado());
	}	
	
	public Tarefa update(Tarefa obj) {
		return repo.save(obj);			   
	}

	public void alocarTarefa(String id) {
		Tarefa obj = this.findById(id);
		List<Pessoa> listaPessoas = pessoaService.findAllByDepartamento(obj.getDepartamento());
		Random rand = new Random();
		obj.setPessoaAlocada(listaPessoas.get(rand.nextInt(listaPessoas.size())));
		obj = this.update(obj);
	}
	
	public void finalizaTarefa(String id) {
		Tarefa obj = this.findById(id);
		obj.setFinalizado(true);
		obj = this.update(obj);
	}
	
	public List<Tarefa> tarefasSemPessoas() {
		return repo.findByFinalizadoFalseAndPessoaAlocadaIsNull(PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "prazo")));
	}
	
}

