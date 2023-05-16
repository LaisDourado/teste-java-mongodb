package com.laisdourado.testejava.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laisdourado.testejava.domain.Tarefa;
import com.laisdourado.testejava.domain.Pessoa;
import com.laisdourado.testejava.dto.PessoaDTO;
import com.laisdourado.testejava.services.PessoaService;

@RestController
@RequestMapping(value= "/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaService service;
	
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> findAll(){
		List<Pessoa> list  = service.findAll();
		List<PessoaDTO> listDto = list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
		// falta total horas gastas
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaDTO> findById(@PathVariable String id){
		Pessoa obj = service.findById(id);
		return ResponseEntity.ok().body(new PessoaDTO(obj));		
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody PessoaDTO objDto){
		Pessoa obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody PessoaDTO objDto, @PathVariable String id){
		Pessoa obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

}
