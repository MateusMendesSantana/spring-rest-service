package br.ucsal.Estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ucsal.Estacionamento.models.Agencia;
import br.ucsal.Estacionamento.models.Carro;
import br.ucsal.Estacionamento.repository.AgenciaRepository;
import br.ucsal.Estacionamento.repository.CarroRepository;

@RestController()
public class CarroController {
	@Autowired
	private CarroRepository repository;

	@RequestMapping(path = "/cars", method = RequestMethod.POST)
	public Carro create(Carro instance) {
		return repository.save(instance);
	}

	@RequestMapping(path = "/cars")
	public Iterable<Carro> list() {
		return repository.findAll();
	}

	@RequestMapping(path = "/cars/{id}", method = RequestMethod.DELETE)
	public Carro delete(@PathVariable("id") long id) {
		Carro instance = repository.findByCodigo(id);
		repository.delete(instance);
		return instance;
	}

	@RequestMapping(path = "/cars/{id}", method = RequestMethod.PUT)
	public Carro update(@PathVariable("id") long id) {
		Carro instance = repository.findByCodigo(id);
		return instance;
	}

	@RequestMapping(path = "/cars/{id}", method = RequestMethod.GET)
	public Carro findById(@PathVariable("id") long id) {
		return repository.findByCodigo(id);
	}
}
