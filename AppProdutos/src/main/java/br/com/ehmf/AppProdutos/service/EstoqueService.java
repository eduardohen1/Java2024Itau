package br.com.ehmf.AppProdutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ehmf.AppProdutos.model.Estoque;
import br.com.ehmf.AppProdutos.model.Produto;
import br.com.ehmf.AppProdutos.repository.EstoqueRepository;
import br.com.ehmf.AppProdutos.repository.ProdutoRepository;
import br.com.ehmf.AppProdutos.service.interfaces.EstoqueServiceInterface;

@Service
public class EstoqueService implements EstoqueServiceInterface {

	private EstoqueRepository estoqueRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	public EstoqueService(EstoqueRepository estoqueRepository) {
		this.estoqueRepository = estoqueRepository;
	}
		
	@Override
	public Estoque save(Estoque estoque) {
		
		//verificar se o produto existe, caso não, avisar:
		if(estoque.getProduto().getId() != null) {
			Optional<Produto> findProduto = produtoRepository.findById(estoque.getProduto().getId());
			if(findProduto.isEmpty()) {
				System.out.println("Produto não encontrado.");
				return null;
			}else {
				estoque.setProduto(findProduto.get());
				return estoqueRepository.save(estoque);
			}
		}else {
			System.out.println("Produto vazio.");
			return null;
		}
	}

	@Override
	public Optional<Estoque> getById(Long id) {
		return estoqueRepository.findById(id);
	}

	@Override
	public List<Estoque> getAll() {
		return estoqueRepository.findAll();
	}

	@Override
	public Estoque update(Estoque estoque) {
		Optional<Estoque> findEstoque = estoqueRepository.findById(estoque.getId());
		if(findEstoque.isPresent()) {
			Estoque updateEstoque = findEstoque.get(); //setId
			updateEstoque.setProduto(findEstoque.get().getProduto()); //evitar de atualizar o produto no estoque
			updateEstoque.setQuantidade(estoque.getQuantidade());
			return estoqueRepository.save(updateEstoque);
		}
		return estoque;
	}

	@Override
	public void delete(Long id) {
		estoqueRepository.deleteById(id);
	}

	@Override
	public Estoque addQuantidade(Produto produto, int quantidade) {
		//encontrar o id do produto 
		Optional<Produto> findProduto = produtoRepository.findById(produto.getId());
		if(findProduto.isPresent()) {
			//encontrar o estoque
			Optional<Estoque> findEstoque = estoqueRepository.findByProduto(findProduto);
			if(findEstoque.isPresent()) {				
				//atualizar o campo quantidade
				Estoque updateEstoque = findEstoque.get(); //setId
				updateEstoque.setProduto(findEstoque.get().getProduto()); //evitar de atualizar o produto no estoque				
				//adiciono a qte que será acrescida no meu bd
				int qteAtualizar = findEstoque.get().getQuantidade() + quantidade;				
				updateEstoque.setQuantidade(qteAtualizar);
				//gravar
				return estoqueRepository.save(updateEstoque);
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	@Override
	public Estoque delQuantidade(Produto produto, int quantidade) {
		//encontrar o id do produto 
		Optional<Produto> findProduto = produtoRepository.findById(produto.getId());
		if(findProduto.isPresent()) {
			//encontrar o estoque
			Optional<Estoque> findEstoque = estoqueRepository.findByProduto(findProduto);
			if(findEstoque.isPresent()) {				
				//atualizar o campo quantidade
				Estoque updateEstoque = findEstoque.get(); //setId
				updateEstoque.setProduto(findEstoque.get().getProduto()); //evitar de atualizar o produto no estoque				
				//adiciono a qte que será acrescida no meu bd
				int qteAtualizar = findEstoque.get().getQuantidade() - quantidade;
				if(qteAtualizar < 0) {
					System.out.println("Estoque negativo.");
					return null;
				}else {
					updateEstoque.setQuantidade(qteAtualizar);
					//gravar
					return estoqueRepository.save(updateEstoque);
				}
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	@Override
	public List<Estoque> findEstoqueQuantidade(Integer quantidade) {
		List<Estoque> listEstoque = estoqueRepository.findEstoqueQuantidadeLessThan(quantidade);
		if(listEstoque.size() > 0) {
			return listEstoque;
		}
		return null;
	}
}
