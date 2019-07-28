package br.com.orube.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.orube.domain.Cliente;

@RepositoryRestResource(path = "clientes", collectionResourceRel = "clientes", itemResourceRel = "cliente")
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
