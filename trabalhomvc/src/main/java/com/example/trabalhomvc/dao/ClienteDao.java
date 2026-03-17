package com.example.trabalhomvc.dao;

import java.util.List;

import com.example.trabalhomvc.entidy.Cliente;

public interface ClienteDao {
	abstract void save(Cliente cliente);
	void update(Cliente cliente);
	void delete(Long id);
	Cliente findById(Long id);
	List<Cliente> findAll();
}
