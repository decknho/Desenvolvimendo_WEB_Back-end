package com.example.koffemvc.entidy;

import java.util.Objects;

public class Pedido {
	private Long id;
	private Long clienteId;
	private Long produtoId;
	private Integer quantidade;
	
	
	//constructor
	public Pedido(Long id, Long clienteId, Long produtoId, Integer quantidade) {
		super();
		this.id = id;
		this.clienteId = clienteId;
		this.produtoId = produtoId;
		this.quantidade = quantidade;
	}

	
	//toString
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", clienteId=" + clienteId + ", produtoId=" + produtoId + ", quantidade="
				+ quantidade + "]";
	}

	
	//getters & setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	
	//hashCode & equals
	@Override
	public int hashCode() {
		return Objects.hash(clienteId, id, produtoId, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(clienteId, other.clienteId) && Objects.equals(id, other.id)
				&& Objects.equals(produtoId, other.produtoId) && Objects.equals(quantidade, other.quantidade);
	}
}
