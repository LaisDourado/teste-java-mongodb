package com.laisdourado.testejava.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laisdourado.testejava.domain.ListaTarefas;
import com.laisdourado.testejava.services.ListaTarefasService;

@RestController
@RequestMapping(value= "/listaTarefas")
public class ListaTarefasResource {

	@Autowired
	private ListaTarefasService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<ListaTarefas> findById(@PathVariable String id){
		ListaTarefas obj = service.findById(id);
		return ResponseEntity.ok().body(obj);		
	}	
}