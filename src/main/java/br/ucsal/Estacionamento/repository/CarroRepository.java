package br.ucsal.Estacionamento.repository;

import org.springframework.data.repository.CrudRepository;
import br.ucsal.Estacionamento.models.*;

public interface CarroRepository extends CrudRepository<Carro, String>{
	Carro findByCodigo(long codigo);

}