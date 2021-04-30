package br.ucsal.Estacionamento.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Type;

@Entity
public class Carro implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long codigo;

	public String renavam;
	public String modelo;
	public String marca;
	public String potencia;
	public String anofab;
	public String anomod;
	public String cor;
	@Type(type = "numeric_boolean")
	public boolean combgasolina;
	@Type(type = "numeric_boolean")
	public boolean combetanol;
	@Type(type = "numeric_boolean")
	public boolean abs;
	public String dataaquisicao;
	public String localizacao;
	public String porcentnivelcomb;
	@Type(type = "numeric_boolean")
	public boolean combdiesel;
	@Type(type = "numeric_boolean")
	public boolean combgnv;
	@Type(type = "numeric_boolean")
	public boolean arcondicionado;
	@Type(type = "numeric_boolean")
	public boolean vidroeletrico;
	@Type(type = "numeric_boolean")
	public boolean gps;
	@Type(type = "numeric_boolean")
	public boolean travas;
	@Type(type = "numeric_boolean")
	public boolean alarme;
	
	@OneToOne
	public Locacao locacao;
}