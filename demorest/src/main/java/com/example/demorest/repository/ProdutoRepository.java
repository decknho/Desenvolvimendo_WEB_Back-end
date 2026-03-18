package com.example.demorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demorest.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {

}
