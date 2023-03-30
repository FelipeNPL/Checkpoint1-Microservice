package br.com.fiap.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.ecommerce.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
