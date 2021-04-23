package br.ucsal.Estacionamento.repository;

import org.springframework.data.repository.CrudRepository;
import br.ucsal.Estacionamento.models.*;

public interface ClienteRepository extends CrudRepository<Cliente, String>{
	Cliente findByCodigo(long codigo);
}
