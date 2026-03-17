package com.example.trabalhomvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.trabalhomvc.entidy.Produto;
import com.example.trabalhomvc.service.ProdutoService;
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoService service;
	
	@GetMapping("/cadastro")
	public String cadastro(Produto produto) {
		return "produtos/cadastro";
		
	}
	
	@PostMapping("/salvar")
    public String salvar(Produto produto) {
        service.salvar(produto);
        return "redirect:/produtos/lista";
    }

    @PostMapping("/editar")
    public String editar(Produto produto) {
        service.editar(produto);
        return "redirect:/produtos/lista";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        service.excluir(id);
        return "redirect:/produtos/lista";
    }
	
	@GetMapping("/lista")
    public String listar(ModelMap model) {
        model.addAttribute("produtos", service.buscaTodos());
        return "produtos/lista";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView preEditar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("produtos/cadastro");
        mv.addObject("produto", service.buscarPorId(id));
        return mv;
    }
}
