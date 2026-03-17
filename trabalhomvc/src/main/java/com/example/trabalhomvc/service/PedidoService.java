package com.example.trabalhomvc.service;

import java.util.List;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.example.trabalhomvc.entidy.Pedido;

public interface PedidoService {
	void salvar(Pedido pedido);
	void editar(Pedido Pedido);
	void excluir(Long id);
	Pedido buscarPorId(Long id);
	List<Pedido> buscaTodos();
	public Page<Pedido> buscarPaginado(Pageable pageable);
}
