package com.projetocalculadora.softexpert.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetocalculadora.softexpert.domain.Pedido;
import com.projetocalculadora.softexpert.domain.RetornoCalculo;
import com.projetocalculadora.softexpert.services.CalculoService;



@RestController
@RequestMapping(value="/calculo")
public class CalculadoraResource {
	
	@Autowired
	private CalculoService service;

	@RequestMapping(value="/{nome}", method=RequestMethod.GET)
	public String find(@PathVariable String nome) {
		return nome;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<RetornoCalculo> caculaValoresIndividuais(@RequestBody Pedido obj) {
		RetornoCalculo dadosPagamento = service.calculaValoresIndividuais(obj);
		return ResponseEntity.ok().body(dadosPagamento);
	}
}
