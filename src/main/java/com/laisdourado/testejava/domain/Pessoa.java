package com.laisdourado.testejava.domain;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	//id, nome, departamento e  lista de tarefas
	private String id;
	private String nome;
	private String departamento;

	public Pessoa() {		
	}

	public Pessoa(String id, String nome, String departamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.departamento = departamento;
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

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
