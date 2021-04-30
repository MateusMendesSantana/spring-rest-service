package br.ucsal.Estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import br.ucsal.Estacionamento.models.Agencia;
import br.ucsal.Estacionamento.models.Cliente;
import br.ucsal.Estacionamento.repository.AgenciaRepository;
import br.ucsal.Estacionamento.repository.ClienteRepository;

@RestController()
public class AgenciaController {
	@Autowired
	private AgenciaRepository repository;

	@RequestMapping(path = "/agencies", method = RequestMethod.POST)
	public Agencia create(@RequestBody Agencia instance) {
		return repository.save(instance);
	}

	@RequestMapping(path = "/agencies")
	public Iterable<Agencia> list() {
		return repository.findAll();
	}

	@RequestMapping(path = "/agencies/{id}", method = RequestMethod.DELETE)
	public Agencia delete(@PathVariable("id") long id) {
		Agencia instance = repository.findByCodigo(id);
		repository.delete(instance);
		return instance;
	}

	@RequestMapping(path = "/agencies/{id}", method = RequestMethod.PUT)
	public Agencia update(@PathVariable("id") long id) {
		Agencia instance = repository.findByCodigo(id);
		return instance;
	}

	@RequestMapping(path = "/agencies/{id}", method = RequestMethod.GET)
	public Agencia findById(@PathVariable("id") long id) {
		return repository.findByCodigo(id);
	}

}
