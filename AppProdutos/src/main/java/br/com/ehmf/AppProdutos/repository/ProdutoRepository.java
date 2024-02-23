package br.com.ehmf.AppProdutos.repository;

import org.springframework.stereotype.Repository;

import br.com.ehmf.AppProdutos.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}
