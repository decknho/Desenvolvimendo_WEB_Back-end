package com.example.trabalhomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.trabalhomvc.dao.ClienteDao;
import com.example.trabalhomvc.entidy.Cliente;

@Service
@Transactional(readOnly=false)
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDao dao;
	
	@Override
	public void salvar(Cliente clientes) {
		// TODO Auto-generated method stub
		if(clientes.getId() == null) {
	        dao.save(clientes);
	    } else {
	        dao.update(clientes);
	    }
	}

	@Override
	public void editar(Cliente clientes) {
		// TODO Auto-generated method stub
		dao.update(clientes);
		
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cliente> buscaTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}