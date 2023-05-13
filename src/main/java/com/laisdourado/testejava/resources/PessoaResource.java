package com.laisdourado.testejava.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laisdourado.testejava.domain.Pessoa;

@RestController
@RequestMapping(value= "/pessoa")
public class PessoaResource {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> findAll(){
		Pessoa maria = new Pessoa("1","Ana maria","Administrativo");
		Pessoa pedro = new Pessoa("2","Mario Cezar","Financeiro");
		List<Pessoa> list  = new ArrayList<>();
		list.addAll(Arrays.asList(maria,pedro));
		return ResponseEntity.ok().body(list);
	}
}
