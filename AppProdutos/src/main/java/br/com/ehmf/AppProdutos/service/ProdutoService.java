package br.com.ehmf.AppProdutos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ehmf.AppProdutos.dto.ProdutoDTO;
import br.com.ehmf.AppProdutos.dto.ProdutoSimplesDTO;
import br.com.ehmf.AppProdutos.model.Produto;
import br.com.ehmf.AppProdutos.repository.ProdutoRepository;
import br.com.ehmf.AppProdutos.service.interfaces.ProdutoServiceInterface;

@Service
public class ProdutoService implements ProdutoServiceInterface {

	private ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Override
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public Optional<Produto> getById(Long id) {
		return produtoRepository.findById(id);
	}

	@Override
	public List<Produto> getAll() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto update(Produto produto) {
		Optional<Produto> findProduto = produtoRepository.findById(produto.getId());
		
		//se ele existir, vou atualizar:
		if(findProduto.isPresent()) {
			Produto updateProduto = findProduto.get(); //setId
			updateProduto.setCodigoBarras(produto.getCodigoBarras());
			updateProduto.setNome(produto.getNome());
			updateProduto.setPreco(produto.getPreco());
			return produtoRepository.save(updateProduto);
		}
		return produto;		
	}

	@Override
	public void delete(Long id) {
		produtoRepository.deleteById(id);		
	}
	
	@Override
	public List<ProdutoDTO> findProdutosAndQuantidade() {
		List<Object[]> listResult = produtoRepository.findProdutosAndQuantidade();
		List<ProdutoDTO> listProdutoDTO = new ArrayList<>();
		//iteracao no listResult e lancando no listProdutoDTO
		for(Object[] result : listResult) {
			ProdutoDTO produtoDTO = new ProdutoDTO();
			produtoDTO.setId( ((Long)result[0]).longValue() );
			produtoDTO.setCodigoBarras( (String)result[1] );
			produtoDTO.setNome( (String)result[2] );
			produtoDTO.setPreco( ((Double)result[3]).doubleValue() );
			produtoDTO.setQuantidade( ((Integer)result[4]).intValue() );
			
			listProdutoDTO.add(produtoDTO);			
		}		
		//List<ProdutoDTO> listProdutoDTO = produtoRepository.findProdutosAndQuantidade();
		if(listProdutoDTO.size() > 0)
			return listProdutoDTO;
		return null;
	}
	
	@Override
	public List<ProdutoSimplesDTO> findProdutoSimplesAndQuantidade() {
		List<Object[]> listResult = produtoRepository.findProdutosSimplesAndQuantidade();
		List<ProdutoSimplesDTO> listProdutoSimplesDTO = new ArrayList<>();
		
		listResult.forEach(result -> {
			listProdutoSimplesDTO.add(returnProdutoSimples(result));
		});
		
		if(listProdutoSimplesDTO.size() > 0)
			return listProdutoSimplesDTO;
		return null;
	}
	
	private ProdutoSimplesDTO returnProdutoSimples(Object[] result) {
		ProdutoSimplesDTO produtoSimplesDTO = new ProdutoSimplesDTO();
		if(result != null) {
			produtoSimplesDTO.setId( ((Long)result[0]).longValue() );
			produtoSimplesDTO.setCodigoBarras( (String)result[1] );
			produtoSimplesDTO.setPreco( ((Double)result[2]).doubleValue() );
			produtoSimplesDTO.setQuantidade( ((Integer)result[3]).intValue() );
		}
		return produtoSimplesDTO;
	}
	
}
