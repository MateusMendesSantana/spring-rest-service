package br.ucsal.Estacionamento.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente implements Serializable {

	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long codigo;

	public String nome;
	public String numerodocumento;
	public String tipodocumento;
	public String rg;
	public String datanascimento;
	public String naturalidade;
	public String endrua;
	public String endnumero;
	public String endcomplemento;
	public String endbairro;
	public String endcidade;
	public String endunidadefederativa;
	public String endcep;
	public String telefone;
	public String email;

	@OneToOne
	public Locacao locacao;
}