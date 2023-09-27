package com.projetocalculadora.softexpert.domain;

import java.io.Serializable;

public class DadosDoAmigo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double valorTotal;
	private String cpf;
	
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
