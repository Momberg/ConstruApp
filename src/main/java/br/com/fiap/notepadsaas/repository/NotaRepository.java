package br.com.fiap.notepadsaas.repository;

import br.com.fiap.notepadsaas.model.Nota;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface NotaRepository extends MongoRepository<Nota, String> {

    List<Nota> findByTitulo(String titulo);

}
