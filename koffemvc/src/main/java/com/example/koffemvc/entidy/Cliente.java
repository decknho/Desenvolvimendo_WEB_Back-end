package com.example.koffemvc.entidy;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate clienteDesde;
	
	
	//constructor
	public Cliente(long id, String nome, LocalDate clienteDesde) {
		super();
		this.id = id;
		this.nome = nome;
		this.clienteDesde = clienteDesde;
	}
	
	
	//getters & setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getClienteDesde() {
		return clienteDesde;
	}
	public void setClienteDesde(LocalDate clienteDesde) {
		this.clienteDesde = clienteDesde;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", clienteDesde=" + clienteDesde + "]";
	}
	
	
	//hashCode & equals
	@Override
	public int hashCode() {
		return Objects.hash(clienteDesde, id, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(clienteDesde, other.clienteDesde) && id == other.id && Objects.equals(nome, other.nome);
	}
}
