package br.ucsal.Estacionamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class AppController {
	@Autowired
	private ClienteService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Cliente> listClientes = service.listall();
		model.addAttribute("listClientes", listClientes);
		
		return "index";
	}
}
