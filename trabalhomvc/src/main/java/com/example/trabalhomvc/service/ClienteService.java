package com.example.trabalhomvc.service;

import java.util.List;

import com.example.trabalhomvc.entidy.Cliente;

public interface ClienteService {
	void salvar(Cliente cliente);
	void editar(Cliente cliente);
	void excluir(Long id);
	Cliente buscarPorId(Long id);
	List<Cliente> buscaTodos();
}
