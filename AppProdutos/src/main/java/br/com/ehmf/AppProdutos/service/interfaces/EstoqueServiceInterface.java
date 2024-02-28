package br.com.ehmf.AppProdutos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.ehmf.AppProdutos.model.Estoque;
import br.com.ehmf.AppProdutos.model.Produto;

public interface EstoqueServiceInterface {
	
	Estoque save(Estoque estoque);
	Optional<Estoque> getById(Long id);
	List<Estoque> getAll();
	Estoque update(Estoque estoque);
	void delete(Long id);
	Estoque addQuantidade(Produto produto, int quantidade);
	Estoque delQuantidade(Produto produto, int quantidade);
	List<Estoque> findEstoqueQuantidade(Integer quantidade);
	List<Estoque> findEstoqueQuantidadeGreaterThan(Integer quantidade);
	
}
