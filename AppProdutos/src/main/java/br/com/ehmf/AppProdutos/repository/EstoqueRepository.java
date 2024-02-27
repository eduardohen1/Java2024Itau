package br.com.ehmf.AppProdutos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ehmf.AppProdutos.model.Estoque;
import br.com.ehmf.AppProdutos.model.Produto;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

	Optional<Estoque> findByProduto(Optional<Produto> findProduto);

	@Query("SELECT e FROM Estoque e WHERE e.quantidade <= :quantidade")
	List<Estoque> findEstoqueQuantidadeLessThan(Integer quantidade);
	
	

}
