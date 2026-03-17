package com.example.trabalhomvc.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.trabalhomvc.entidy.Cliente;
import com.example.trabalhomvc.service.ClienteService;
@Controller
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteService service;
	
	@GetMapping("/cadastro")
	public String cadastro(Cliente cliente) {
		return "clientes/cadastro";
		
	}
	
	@PostMapping("/salvar")
    public String salvar(Cliente cliente) {
		cliente.setClienteDesde(LocalDate.now()); // data automática
        service.salvar(cliente);
        return "redirect:/clientes/lista";
    }

    @PostMapping("/editar")
    public String editar(Cliente cliente) {
        service.editar(cliente);
        return "redirect:/clientes/lista";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        service.excluir(id);
        return "redirect:/clientes/lista";
    }
	
	@GetMapping("/lista")
    public String listar(ModelMap model) {
        model.addAttribute("clientes", service.buscaTodos());
        return "clientes/lista";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView preEditar(@PathVariable("id") Long id) {
    	
        ModelAndView mv = new ModelAndView("clientes/cadastro");
        
        mv.addObject("cliente", service.buscarPorId(id));
        
        return mv;
    }
}
