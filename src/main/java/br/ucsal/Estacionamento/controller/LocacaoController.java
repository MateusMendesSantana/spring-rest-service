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
	private CarroRepository carRepository;
	@Autowired
	private ClienteRepository clientRepository;
	@Autowired
	private AgenciaRepository agenciaRepository;

	@RequestMapping(path = "/leases", method = RequestMethod.POST)
	public Locacao create(Locacao instance) {
		if (instance.carro != null) {
			instance.carro = carRepository.findByCodigo(instance.carro.codigo);
		}
		
		if (instance.agencia != null) {
			instance.agencia = agenciaRepository.findByCodigo(instance.agencia.codigo);			
		}

		if (instance.cliente != null) {
			instance.cliente = clientRepository.findByCodigo(instance.cliente.codigo);			
		}						
		
		instance.data = instance.data;
		instance.seguro = instance.seguro;
		
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
		return repository.findByCodigo(id);
	}

	@RequestMapping(path = "/leases/{id}", method = RequestMethod.GET)
	public Locacao findById(@PathVariable("id") long id) {
		return repository.findByCodigo(id);
	}
}
