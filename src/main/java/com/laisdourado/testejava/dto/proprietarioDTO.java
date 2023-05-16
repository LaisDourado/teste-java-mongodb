package com.laisdourado.testejava.dto;

import java.io.Serializable;

import com.laisdourado.testejava.domain.Pessoa;

public class proprietarioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nome;
	
	public proprietarioDTO() {
	}
	
	public proprietarioDTO(Pessoa obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
