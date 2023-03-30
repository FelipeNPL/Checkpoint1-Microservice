package br.com.fiap.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.ecommerce.models.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
