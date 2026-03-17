package com.example.trabalhomvc.entidy;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name="PRODUTO")
@SuppressWarnings("serial")
public class Produto extends AbstractEntity<Long>{
	@Column(nullable = false)
    private String nome;
	
	@Column(nullable = false)
    private BigDecimal preco;
	
	@Column(nullable = false)
    private Boolean estoque;
	
	 public Produto() {
	    }
	 
	 
	 public Produto(String nome, BigDecimal preco, Boolean estoque) {
	        this.nome = nome;
	        this.preco = preco;
	        this.estoque = estoque;
	    }
	 
	 public String getNome() {
	        return nome;
	    }

	    public BigDecimal getPreco() {
	        return preco;
	    }

	    public Boolean getEstoque() {
	        return estoque;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public void setPreco(BigDecimal preco) {
	        this.preco = preco;
	    }

	    public void setEstoque(Boolean estoque) {
	        this.estoque = estoque;
	    }
}
