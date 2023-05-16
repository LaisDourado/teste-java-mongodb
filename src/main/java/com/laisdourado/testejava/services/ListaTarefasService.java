package com.laisdourado.testejava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laisdourado.testejava.domain.ListaTarefas;
import com.laisdourado.testejava.repository.ListaTarefaRepository;
import com.laisdourado.testejava.services.exception.ObjectNotFoundException;

@Service
public class ListaTarefasService {

	@Autowired
	private ListaTarefaRepository repo;
	
	public ListaTarefas findById(String id) {
		Optional<ListaTarefas> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<ListaTarefas> findbytitle(String text){
		return repo.findByTituloContainingIgnoreCase(text);
	}
}

