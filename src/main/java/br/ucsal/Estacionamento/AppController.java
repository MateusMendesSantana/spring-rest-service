package br.ucsal.Estacionamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ucsal.Estacionamento.models.Cliente;
import br.ucsal.Estacionamento.repository.ClienteRepository;

import java.util.List;

@Controller
public class AppController {
	@Autowired
	private ClienteRepository repo;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Cliente> listClientes = (List<Cliente>) repo.findAll();
		model.addAttribute("listClientes", listClientes);
		
		return "index";
	}
}
