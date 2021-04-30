package br.ucsal.Estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ucsal.Estacionamento.LocacaoView;
import br.ucsal.Estacionamento.models.*;
import br.ucsal.Estacionamento.repository.*;

@RestController()
public class LocacaoController {
	
	@Autowired
	private LocacaoRepository repository;
	@Autowired
	private CarroRepository cr;
	@Autowired
	private ClienteRepository clr;
	@Autowired
	private AgenciaRepository ar;

	@RequestMapping(value = "/cadastrarLocacao", method = RequestMethod.POST)
	public Locacao cadastrarLocacao(LocacaoView locacao) {
		Carro carro = null;
		if (locacao.getCarro() != null) {
			carro = cr.findByCodigo(Long.parseLong(locacao.getCarro()));
		}
		
		Agencia agencia = null;
		if (locacao.getAgencia() != null) {
			agencia = ar.findByCodigo(Long.parseLong(locacao.getAgencia()));			
		}

		Cliente cliente = null;
		if (locacao.getCliente() != null) {
			cliente = clr.findByCodigo(Long.parseLong(locacao.getCliente()));			
		}						
		Locacao l = new Locacao();
		
		if (carro != null) {
			l.carro =carro;
		}
		
		if (agencia != null) {
			l.agencia = agencia;
		}
		
		if (cliente != null) {
			l.cliente = cliente;
		}

		l.data = locacao.getData();
		l.seguro = locacao.getSeguro();
		
		return repository.save(l);
	}

	@RequestMapping(path = "/leases", method = RequestMethod.POST)
	public Locacao create(Locacao instance) {
		return repository.save(instance);
	}

	@RequestMapping(path = "/leases")
	public Iterable<Locacao> list() {
		return repository.findAll();
	}

	@RequestMapping(path = "/leases/{id}", method = RequestMethod.DELETE)
	public Locacao delete(@PathVariable("id") long id) {
		Locacao instance = repository.findByCodigo(id);
		repository.delete(instance);
		return instance;
	}

	@RequestMapping(path = "/leases/{id}", method = RequestMethod.PUT)
	public Locacao update(@PathVariable("id") long id) {
		Locacao instance = repository.findByCodigo(id);
		return instance;
	}

	@RequestMapping(path = "/leases/{id}", method = RequestMethod.GET)
	public Locacao findById(@PathVariable("id") long id) {
		return repository.findByCodigo(id);
	}
}
