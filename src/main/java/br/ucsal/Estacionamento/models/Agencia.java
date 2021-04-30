package br.ucsal.Estacionamento.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Agencia implements Serializable {

	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long codigo;

	public String nomefantasia;
	public String cnpj;
	public String inscricaoestadual;
	public String endrua;
	public String endnumero;
	public String endcomplemento;
	public String endbairro;
	public String endcidade;
	public String endunidadefederativa;
	public String endcep;
	public String telefone;
	public String gerenteresponsavel;

	@OneToOne
	public Locacao locacao;
}