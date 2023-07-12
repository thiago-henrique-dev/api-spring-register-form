package br.com.provider.trilhaProvider.acompanhamento.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.provider.trilhaProvider.acompanhamento.Models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByName(String name);

}
