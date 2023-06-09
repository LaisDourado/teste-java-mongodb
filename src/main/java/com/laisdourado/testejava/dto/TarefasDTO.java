package com.laisdourado.testejava.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.laisdourado.testejava.domain.Tarefa;

public class TarefasDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String titulo;
	private String descricao;
	private Date prazo;
	private String departamento;
	private Double duracao;
	private String idPessoaAlocada;
	private boolean finalizado;
	
	public TarefasDTO() {
	}

	public TarefasDTO(Tarefa obj) {
		id = obj.getId();
		titulo = obj.getTitulo();
		descricao = obj.getDescricao();
		prazo = obj.getPrazo();
		departamento = obj.getDepartamento();
		duracao = obj.getDuracao();
		idPessoaAlocada = Objects.nonNull(obj.getPessoaAlocada()) ? obj.getPessoaAlocada().getId() : null;
		finalizado = obj.isFinalizado();
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

	public String getIdPessoaAlocada() {
		return idPessoaAlocada;
	}

	public void setPessoa_alocada(String idPessoaAlocada) {
		this.idPessoaAlocada = idPessoaAlocada;
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

}
