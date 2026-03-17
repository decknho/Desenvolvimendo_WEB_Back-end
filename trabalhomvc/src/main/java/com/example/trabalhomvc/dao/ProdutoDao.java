package com.example.trabalhomvc.dao;

import java.util.List;

import com.example.trabalhomvc.entidy.Produto;

public interface ProdutoDao {
	abstract void save(Produto produto);
	void update(Produto produto);
	void delete(Long id);
	Produto findById(Long id);
	List<Produto> findAll();
	List<Produto> findActive();
}
