package com.example.trabalhomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.trabalhomvc.dao.PedidoDao;
import com.example.trabalhomvc.entidy.Pedido;


@Service
@Transactional(readOnly=false)
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoDao dao;
	
	@Override
	public void salvar(Pedido pedido) {
		// TODO Auto-generated method stub
		if (pedido.getId() == null) {
			dao.save(pedido);
    	} else {
    		dao.update(pedido);
    	}
	}

	@Override
	public void editar(Pedido pedido) {
		// TODO Auto-generated method stub
		dao.update(pedido);
		
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Pedido buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Pedido> buscaTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Page<Pedido> buscarPaginado(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}