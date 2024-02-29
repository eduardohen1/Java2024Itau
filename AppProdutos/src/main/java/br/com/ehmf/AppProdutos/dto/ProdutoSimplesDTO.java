package br.com.ehmf.AppProdutos.dto;

public class ProdutoSimplesDTO {
	private Long id;
	private String codigoBarras;
	private Double preco;
	private Integer quantidade;
	
	public ProdutoSimplesDTO() {}

	public ProdutoSimplesDTO(Long id, String codigoBarras, Double preco, Integer quantidade) {
		this.id = id;
		this.codigoBarras = codigoBarras;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
