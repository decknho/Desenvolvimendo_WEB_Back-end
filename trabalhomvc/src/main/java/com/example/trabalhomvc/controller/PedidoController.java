package com.example.trabalhomvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.trabalhomvc.entidy.Cliente;
import com.example.trabalhomvc.entidy.Pedido;
import com.example.trabalhomvc.entidy.Produto;
import com.example.trabalhomvc.service.ClienteService;
import com.example.trabalhomvc.service.PedidoService;
import com.example.trabalhomvc.service.ProdutoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired
	private PedidoService service;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/cadastro")
	public String cadastro(ModelMap model) {

	    model.addAttribute("pedido", new Pedido());    
	    model.addAttribute("clientes", clienteService.buscaTodos());
	    model.addAttribute("produtos", produtoService.buscarDisponiveis());

	    return "pedidos/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Pedido pedido, ModelMap model) {

	    Cliente cliente = clienteService.buscarPorId(pedido.getClienteId());
	    Produto produto = produtoService.buscarPorId(pedido.getProdutoId());
	    
	    if (cliente == null) {
	        model.addAttribute("erro", "Cliente não encontrado.");
	        model.addAttribute("clientes", clienteService.buscaTodos());
	        model.addAttribute("produtos", produtoService.buscarDisponiveis());
	        return "pedidos/cadastro";
	    }

	    if (produto == null) {
	        model.addAttribute("erro", "Produto não encontrado.");
	        model.addAttribute("clientes", clienteService.buscaTodos());
	        model.addAttribute("produtos", produtoService.buscarDisponiveis());
	        return "pedidos/cadastro";
	    }

	    if (!produto.getEstoque()) {
	        model.addAttribute("erro", "Produto indisponível.");
	        model.addAttribute("clientes", clienteService.buscaTodos());
	        model.addAttribute("produtos", produtoService.buscarDisponiveis());
	        return "pedidos/cadastro";
	    }

	    pedido.setCliente(cliente);
	    pedido.setProduto(produto);

	    service.salvar(pedido);

	    return "redirect:/pedidos/lista";
	}

    @PostMapping("/editar")
    public String editar(Pedido pedido) {
        service.editar(pedido);
        return "redirect:/pedidos/lista";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        service.excluir(id);
        return "redirect:/pedidos/lista";
    }
	
	@GetMapping("/lista")
    public String listar(ModelMap model) {
        model.addAttribute("pedidos", service.buscaTodos());
        return "pedidos/lista";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView preEditar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("pedidos/cadastro");
        mv.addObject("pedido", service.buscarPorId(id));
        return mv;
    }
}
