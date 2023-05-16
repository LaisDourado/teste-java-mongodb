package com.laisdourado.testejava.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laisdourado.testejava.domain.Tarefa;
import com.laisdourado.testejava.dto.TarefasDTO;
import com.laisdourado.testejava.resources.util.URL;
import com.laisdourado.testejava.services.ListaTarefasService;

@RestController
@RequestMapping(value= "/tarefas")
public class TarefaResource {

	@Autowired
	private ListaTarefasService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> findById(@PathVariable String id){
		Tarefa obj = service.findById(id);
		return ResponseEntity.ok().body(obj);		
	}	
	
	@GetMapping("/titulo")
	public ResponseEntity<List<Tarefa>> findByTitulo(@RequestParam(value="text",defaultValue="")String text){
		text = URL.decodeParam(text);
		List<Tarefa> list = service.findbytitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody TarefasDTO objDto){
		Tarefa obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("alocar/{id}")
	public ResponseEntity<Void> alocarTarefa(@PathVariable String id){
		service.alocarTarefa(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("finalizar/{id}")
	public ResponseEntity<Void> finalizarTarefa(@PathVariable String id){
		service.finalizaTarefa(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("pendentes")
	public ResponseEntity<List<Tarefa>> findByTitulo(){
		List<Tarefa> list = service.tarefasSemPessoas();
		return ResponseEntity.ok().body(list);
	}
	
	
}
