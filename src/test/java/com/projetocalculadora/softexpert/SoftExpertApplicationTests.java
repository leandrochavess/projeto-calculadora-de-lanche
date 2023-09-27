package com.projetocalculadora.softexpert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.projetocalculadora.softexpert.domain.DadosDoAmigo;
import com.projetocalculadora.softexpert.domain.Pedido;
import com.projetocalculadora.softexpert.domain.RetornoCalculo;
import com.projetocalculadora.softexpert.domain.RetornoValores;
import com.projetocalculadora.softexpert.services.CalculoService;

@SpringBootTest
class SoftExpertApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
    public void testCalculaValoresIndividuais() {
        
        Pedido pedido = new Pedido();
        pedido.setMeuValorTotal(50.0);
        pedido.setPorcentagemAcrescimo(true);
        pedido.setAcrescimo(10.0);
        pedido.setPorcentagemDesconto(false);
        pedido.setDesconto(5.0);

        DadosDoAmigo amigo1 = new DadosDoAmigo();
        amigo1.setValorTotal(30.0);
        amigo1.setCpf("123456789");
        pedido.getAmigos().add(amigo1);

        DadosDoAmigo amigo2 = new DadosDoAmigo();
        amigo2.setValorTotal(20.0);
        amigo2.setCpf("987654321");
        pedido.getAmigos().add(amigo2);

        CalculoService calculoService = new CalculoService();
        RetornoCalculo resultado = calculoService.calculaValoresIndividuais(pedido);

        assertNotNull(resultado);
        assertEquals(2, resultado.getAmigos().size());

        RetornoValores retornoAmigo1 = resultado.getAmigos().get(0);
        assertEquals("123456789", retornoAmigo1.getCpf());
        assertEquals(31.5, retornoAmigo1.getValorDoAmigo(), 0.01);

        RetornoValores retornoAmigo2 = resultado.getAmigos().get(1);
        assertEquals("987654321", retornoAmigo2.getCpf());
        assertEquals(21.0, retornoAmigo2.getValorDoAmigo(), 0.01);
        
        assertEquals(52.5, resultado.getMeuValor(), 0.01);
    }

}
