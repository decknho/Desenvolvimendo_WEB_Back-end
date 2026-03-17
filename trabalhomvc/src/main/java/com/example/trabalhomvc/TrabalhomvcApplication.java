package com.example.trabalhomvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.trabalhomvc.entidy.Cliente;
import com.example.trabalhomvc.entidy.Pedido;
import com.example.trabalhomvc.entidy.Produto;
import com.example.trabalhomvc.service.ClienteService;
import com.example.trabalhomvc.service.ProdutoService;
import com.example.trabalhomvc.service.PedidoService;

@SpringBootApplication
public class TrabalhomvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhomvcApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(PedidoService pedidoService,
	                       ClienteService clienteService,
	                       ProdutoService produtoService) {
	    return args -> {
	    	
	    	if (pedidoService.buscaTodos().isEmpty()) {
	            Cliente cliente = clienteService.buscarPorId(1L);
	            Produto produto = produtoService.buscarPorId(1L);

	            if (cliente != null && produto != null) {

		            Pedido pedido = new Pedido();
		            pedido.setCliente(cliente);
		            pedido.setProduto(produto);
		            pedido.setQuantidade(2);
	
		            pedidoService.salvar(pedido); 
	            }
	        } 
	    };
	}
}
