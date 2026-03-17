package com.example.trabalhomvc.entidy;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name="CLIENTE")
@SuppressWarnings("serial")
public class Cliente extends AbstractEntity<Long>{
	@Column(name="nome", nullable=false, length=60)
	private String nome;
	
	@Column( nullable=false, name="cliente_desde", columnDefinition="DATE")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate clienteDesde;

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
	
	
}
