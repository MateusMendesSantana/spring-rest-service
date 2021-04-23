package br.ucsal.Estacionamento.repository;

import org.springframework.data.repository.CrudRepository;
import br.ucsal.Estacionamento.models.*;

public interface FuncionarioRepository extends CrudRepository<Funcionario, String>{
	Funcionario findByCodigo(long codigo);

}
