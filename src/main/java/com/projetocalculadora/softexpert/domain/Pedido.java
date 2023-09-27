package com.projetocalculadora.softexpert.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Double meuValorTotal;
	private List<DadosDoAmigo> amigos = new ArrayList<DadosDoAmigo>();
	private boolean porcentagemAcrescimo;
	private Double acrescimo;
	private boolean porcentagemDesconto;
	private Double desconto;
	
	public Double getMeuValorTotal() {
		return meuValorTotal;
	}
	public void setMeuValorTotal(Double meuValorTotal) {
		this.meuValorTotal = meuValorTotal;
	}
	public Double getAcrescimo() {
		return acrescimo;
	}
	public void setAcrescimo(Double acrescimo) {
		this.acrescimo = acrescimo;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public List<DadosDoAmigo> getAmigos() {
		return amigos;
	}
	public void setAmigos(List<DadosDoAmigo> amigos) {
		this.amigos = amigos;
	}
	public boolean isPorcentagemAcrescimo() {
		return porcentagemAcrescimo;
	}
	public void setPorcentagemAcrescimo(boolean porcentagemAcrescimo) {
		this.porcentagemAcrescimo = porcentagemAcrescimo;
	}
	public boolean isPorcentagemDesconto() {
		return porcentagemDesconto;
	}
	public void setPorcentagemDesconto(boolean porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	
}
