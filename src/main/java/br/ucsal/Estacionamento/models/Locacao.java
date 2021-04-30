package br.ucsal.Estacionamento.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Locacao implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long codigo;
	
	@OneToOne
	public Carro carro;

	@OneToOne
	public Cliente cliente;

	@OneToOne
	public Agencia agencia;

	
	public String data;

	
	public String seguro;

	@Override
	public String toString() {
		return "Locacao [codigo=" + codigo + ", carro=" + carro + ", cliente=" + cliente
				+ ", agencia=" + agencia + "]";
	}

}