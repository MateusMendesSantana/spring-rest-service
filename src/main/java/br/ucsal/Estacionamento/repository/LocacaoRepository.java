package br.ucsal.Estacionamento.repository;

import org.springframework.data.repository.CrudRepository;
import br.ucsal.Estacionamento.models.*;

public interface LocacaoRepository extends CrudRepository<Locacao, String>{
	Locacao findByCodigo(long codigo);
}
