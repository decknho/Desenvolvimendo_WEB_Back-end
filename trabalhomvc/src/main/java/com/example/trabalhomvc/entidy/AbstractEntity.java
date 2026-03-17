package com.example.trabalhomvc.entidy;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@SuppressWarnings({ "serial", "hiding" })
@MappedSuperclass
public abstract class AbstractEntity <Long extends Serializable> implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AbstractEntity [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity <?> other = (AbstractEntity <?>) obj;
		return Objects.equals(id, other.id);
	}

}
