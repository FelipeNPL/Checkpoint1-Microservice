package br.com.fiap.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.ecommerce.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
