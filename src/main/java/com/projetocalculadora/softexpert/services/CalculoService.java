package com.projetocalculadora.softexpert.services;


import org.springframework.stereotype.Service;

import com.projetocalculadora.softexpert.domain.DadosDoAmigo;
import com.projetocalculadora.softexpert.domain.Pedido;
import com.projetocalculadora.softexpert.domain.RetornoCalculo;
import com.projetocalculadora.softexpert.domain.RetornoValores;
import com.projetocalculadora.softexpert.utils.Util;

@Service
public class CalculoService {
	
	public RetornoCalculo calculaValoresIndividuais(Pedido pedido){
		
		
		RetornoCalculo retornoValores = new RetornoCalculo();

		Double valorTotalPedido = pedido.getMeuValorTotal();
		
		for (DadosDoAmigo listaCalculo : pedido.getAmigos()) {
			valorTotalPedido += listaCalculo.getValorTotal();
		}
		
		for (DadosDoAmigo item : pedido.getAmigos()) {
			
			Double proporcao =  (item.getValorTotal() * 100) / valorTotalPedido;
			Double totalComAcrescimoDesconto = valorTotalPedido;
			if (pedido.isPorcentagemAcrescimo()) {
				totalComAcrescimoDesconto += totalComAcrescimoDesconto * (pedido.getAcrescimo()/100);
			} else {
				totalComAcrescimoDesconto += pedido.getAcrescimo();
			}
			
			if (pedido.isPorcentagemDesconto()) {
				totalComAcrescimoDesconto -= totalComAcrescimoDesconto * (pedido.getDesconto()/100);
			} else {
				totalComAcrescimoDesconto -= pedido.getDesconto();
			}
			
			RetornoValores retornoDoAmigo = new RetornoValores();
			retornoDoAmigo.setCpf(item.getCpf());
			retornoDoAmigo.setValorDoAmigo(Util.limitaDuasCasasDecimais((proporcao / 100) * totalComAcrescimoDesconto));
			
			//Aqui seria chamado um serviço pra consumo da api picpay - https://appws.picpay.com/ecommerce/public/payments
			//O qrCode abaixo foi retirado de um exemplo de retorno da api picpay 
			//https://picpay.github.io/picpay-docs-digital-payments/checkout/resources/api-reference/
			retornoDoAmigo.setLinkPagamento(Util.QR_CODE);
			
			retornoValores.getAmigos().add(retornoDoAmigo);
			
		}
		
		Double minhaProporcao =  (pedido.getMeuValorTotal() * 100) / valorTotalPedido;
		
		if (pedido.isPorcentagemAcrescimo()) {
			valorTotalPedido += valorTotalPedido * (pedido.getAcrescimo()/100);
		} else {
			valorTotalPedido += pedido.getAcrescimo();
		}
		
		if (pedido.isPorcentagemDesconto()) {
			valorTotalPedido -= valorTotalPedido * (pedido.getDesconto()/100);
		} else {
			valorTotalPedido -= pedido.getDesconto();
		}
		
		retornoValores.setMeuValor(Util.limitaDuasCasasDecimais((minhaProporcao / 100) * valorTotalPedido));
		
		return retornoValores;
		}
	
	
}
