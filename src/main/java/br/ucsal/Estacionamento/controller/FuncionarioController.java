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

import br.ucsal.Estacionamento.models.Carro;
import br.ucsal.Estacionamento.models.Funcionario;
import br.ucsal.Estacionamento.repository.CarroRepository;
import br.ucsal.Estacionamento.repository.FuncionarioRepository;

@RestController()
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository repository;

	@RequestMapping(path = "/funcionarios", method = RequestMethod.POST)
	public Funcionario create(Funcionario instance) {
		return repository.save(instance);
	}

	@RequestMapping(path = "/funcionarios")
	public Iterable<Funcionario> list() {
		return repository.findAll();
	}

	@RequestMapping(path = "/funcionarios/{id}", method = RequestMethod.DELETE)
	public Funcionario delete(@PathVariable("id") long id) {
		Funcionario instance = repository.findByCodigo(id);
		repository.delete(instance);
		return instance;
	}

	@RequestMapping(path = "/funcionarios/{id}", method = RequestMethod.PUT)
	public Funcionario update(@PathVariable("id") long id) {
		Funcionario instance = repository.findByCodigo(id);
		return instance;
	}

	@RequestMapping(path = "/funcionarios/{id}", method = RequestMethod.GET)
	public Funcionario findById(@PathVariable("id") long id) {
		return repository.findByCodigo(id);
	}

}
