package com.laisdourado.testejava.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.laisdourado.testejava.dto.proprietarioDTO;

@Document
public class ListaTarefas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private Date data;
	private String titulo;
	private String texto;
	private proprietarioDTO proprietario;
	
	public ListaTarefas() {
	}

	public ListaTarefas(String id, Date data, String titulo, String texto, proprietarioDTO proprietario) {
		super();
		this.id = id;
		this.data = data;
		this.titulo = titulo;
		this.texto = texto;
		this.proprietario = proprietario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public proprietarioDTO getProprietario() {
		return proprietario;
	}

	public void setProprietario(proprietarioDTO proprietario) {
		this.proprietario = proprietario;
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
		ListaTarefas other = (ListaTarefas) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
