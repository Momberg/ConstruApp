package br.com.fiap.notepadsaas.repository;

import br.com.fiap.notepadsaas.model.Servico;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServicoRepository extends MongoRepository<Servico, String> {

    List<Servico> findListByTipoServico(String tipo);

    List<Servico> findListByLocalServico(String local);

    List<Servico> findListByIdPrestador(String id);

}
