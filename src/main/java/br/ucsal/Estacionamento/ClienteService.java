package br.ucsal.Estacionamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	public List <Cliente>listall() {
		return repo.findAll();
	}
	
	public void save(Cliente cliente) {
		repo.save(cliente);
		
	}
	
	public Cliente get(Long id_cliente) {
		return repo.findById(id_cliente).get();
		
	}
	
	public void delete(Long id_cliente) {
		repo.deleteById(id_cliente);
	}
	

}
