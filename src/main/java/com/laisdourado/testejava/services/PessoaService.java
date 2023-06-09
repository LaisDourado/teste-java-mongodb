package com.laisdourado.testejava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laisdourado.testejava.domain.Pessoa;
import com.laisdourado.testejava.dto.PessoaDTO;
import com.laisdourado.testejava.repository.PessoaRepository;
import com.laisdourado.testejava.services.exception.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
	public List<Pessoa> findAll(){
		return repo.findAll();
	}
	public List<Pessoa> findAllByDepartamento(String departamento){
		return repo.findByDepartamento(departamento);
	}
	
	public Pessoa findById(String id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Pessoa insert(Pessoa obj){
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);;
	}
	
	public Pessoa update(Pessoa entity) {

	     Pessoa newObj = repo.findById(entity.getId()).get();

	     updateData(newObj, entity);

	     return repo.save(newObj);

	}
	private void updateData(Pessoa newObj, Pessoa obj) {
		
		newObj.setNome(obj.getNome());
		newObj.setDepartamento(obj.getDepartamento());
		
	}

	public Pessoa fromDTO(PessoaDTO objDto){
		return new Pessoa(objDto.getId(),objDto.getNome(),objDto.getDepartamento());
	}
}

