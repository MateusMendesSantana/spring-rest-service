package br.ucsal.Estacionamento.repository;

import org.springframework.data.repository.CrudRepository;
import br.ucsal.Estacionamento.models.*;

public interface AgenciaRepository extends CrudRepository<Agencia, String>{
	Agencia findByCodigo(long codigo);

}
