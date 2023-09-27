package com.projetocalculadora.softexpert.domain;

import java.io.Serializable;


public class RetornoValores implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double valorDoAmigo;
	private String linkPagamento;
	private String cpf;

	public String getLinkPagamento() {
		return linkPagamento;
	}
	public void setLinkPagamento(String linkPagamento) {
		this.linkPagamento = linkPagamento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Double getValorDoAmigo() {
		return valorDoAmigo;
	}
	public void setValorDoAmigo(Double valorDoAmigo) {
		this.valorDoAmigo = valorDoAmigo;
	}
	
}
