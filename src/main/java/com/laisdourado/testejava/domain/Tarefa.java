package com.laisdourado.testejava.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Tarefa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id	
	private String id;
	private String titulo;
	private String descricao;
	private Date prazo;
	private String departamento;
	private Double duracao;
	private Pessoa pessoaAlocada;
	private boolean finalizado;
		
	public Tarefa() {
	}

	public Tarefa(String id, String titulo, String descricao, Date prazo, String departamento, Double duracao,
			Pessoa pessoaAlocada, boolean finalizado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.prazo = prazo;
		this.departamento = departamento;
		this.duracao = duracao;
		this.pessoaAlocada = pessoaAlocada;
		this.finalizado = finalizado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getPrazo() {
		return prazo;
	}

	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Double getDuracao() {
		return duracao;
	}

	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}

	public Pessoa getPessoaAlocada() {
		return pessoaAlocada;
	}

	public void setPessoaAlocada(Pessoa pessoaAlocada) {
		this.pessoaAlocada = pessoaAlocada;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Tarefa other = (Tarefa) obj;
		return Objects.equals(id, other.id);
	}
	
	

}