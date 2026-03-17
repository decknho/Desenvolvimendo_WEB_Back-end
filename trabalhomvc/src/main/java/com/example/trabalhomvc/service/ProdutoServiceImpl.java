package com.example.trabalhomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.trabalhomvc.dao.ProdutoDao;
import com.example.trabalhomvc.entidy.Produto;

@Service
@Transactional(readOnly=false)
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired
	private ProdutoDao dao;
	
	@Override
	public void salvar(Produto produto) {
		// TODO Auto-generated method stub
		if (produto.getId() == null) {
			dao.save(produto);
    	} else {
    		dao.update(produto);
    	}
	}

	@Override
	public void editar(Produto produto) {
		// TODO Auto-generated method stub
		dao.update(produto);
		
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Produto buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Produto> buscaTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Produto> buscarDisponiveis() {
		// TODO Auto-generated method stub
		return dao.findActive();
	}

}