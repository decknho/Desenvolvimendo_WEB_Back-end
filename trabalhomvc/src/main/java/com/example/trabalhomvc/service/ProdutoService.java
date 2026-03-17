package com.example.trabalhomvc.service;

import java.util.List;

import com.example.trabalhomvc.entidy.Produto;

public interface ProdutoService {
	void salvar(Produto produto);
	void editar(Produto produto);
	void excluir(Long id);
	Produto buscarPorId(Long id);
	List<Produto> buscaTodos();
	List<Produto> buscarDisponiveis();
}
