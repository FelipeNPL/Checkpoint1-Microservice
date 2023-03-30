package br.com.fiap.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.ecommerce.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
