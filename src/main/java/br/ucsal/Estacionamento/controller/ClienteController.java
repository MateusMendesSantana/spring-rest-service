package br.ucsal.Estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.ucsal.Estacionamento.models.Cliente;
import br.ucsal.Estacionamento.repository.ClienteRepository;

@Controller()
public class ClienteController {
	@Autowired
	private ClienteRepository repository;

	@RequestMapping(path = "/clients", method = RequestMethod.POST)
	public Cliente create(Cliente cliente) {
		return repository.save(cliente);
	}

	@RequestMapping(path = "/clients")
	public Iterable<Cliente> list() {
		return repository.findAll();
	}

	@RequestMapping(path = "/clients/{id}", method = RequestMethod.DELETE)
	public Cliente delete(@PathVariable("id") long id) {
		Cliente cliente = repository.findByCodigo(id);
		repository.delete(cliente);
		return cliente;
	}

	@RequestMapping(path = "/clients/{id}", method = RequestMethod.PUT)
	public Cliente update(@PathVariable("id") long id) {
		Cliente cliente = repository.findByCodigo(id);
		return cliente;
	}

	@RequestMapping(path = "/clients/{id}", method = RequestMethod.GET)
	public Cliente findById(@PathVariable("id") long id) {
		return repository.findByCodigo(id);
	}
}
