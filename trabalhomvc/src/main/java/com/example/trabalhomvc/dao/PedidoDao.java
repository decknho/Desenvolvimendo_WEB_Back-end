package com.example.trabalhomvc.dao;

import java.util.List;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.example.trabalhomvc.entidy.Pedido;

public interface PedidoDao {
	abstract void save(Pedido pedido);
	void update(Pedido pedido);
	void delete(Long id);
	Pedido findById(Long id);
	List<Pedido> findAll();
	public Page<Pedido> listPage(Pageable pageable);
}
