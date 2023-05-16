package com.laisdourado.testejava.dto;

import java.io.Serializable;
import java.util.Date;

public class TarefasDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//id, título, descrição, prazo, departamento, duração, pessoa alocada e se já foi finalizado.

	private String id;
	private String titulo;
	private String descricao;
	private Date prazo;
	private String departamento;
	private Double duracao;
	private proprietarioDTO pessoa_alocada;
	private String status;
	
	public TarefasDTO() {
	}

	public TarefasDTO(String id, String titulo, String descricao, Date prazo, String departamento, Double duracao,
			proprietarioDTO pessoa_alocada, String status) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.prazo = prazo;
		this.departamento = departamento;
		this.duracao = duracao;
		this.pessoa_alocada = pessoa_alocada;
		this.status = status;
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

	public proprietarioDTO getPessoa_alocada() {
		return pessoa_alocada;
	}

	public void setPessoa_alocada(proprietarioDTO pessoa_alocada) {
		this.pessoa_alocada = pessoa_alocada;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
