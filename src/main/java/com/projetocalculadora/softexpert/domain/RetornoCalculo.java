package com.projetocalculadora.softexpert.domain;

import java.util.ArrayList;
import java.util.List;

public class RetornoCalculo {

	private Double meuValor;
	private List<RetornoValores> amigos = new ArrayList<RetornoValores>();
	
	public Double getMeuValor() {
		return meuValor;
	}
	public void setMeuValor(Double meuValor) {
		this.meuValor = meuValor;
	}
	public List<RetornoValores> getAmigos() {
		return amigos;
	}
	public void setAmigos(List<RetornoValores> amigos) {
		this.amigos = amigos;
	}
}
