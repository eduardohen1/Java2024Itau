package br.com.ehmf.App.Contatos.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class Pessoa {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "logradouro", nullable = true)
	private String endereco;
	
	@Column(name = "cep", nullable = true, length = 10) //
	private String cep;
	
	@Column(name = "municipio", nullable = true)
	private String cidade;
	
	@Column(name = "uf", nullable = true, length = 2)
	private String uf;
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy="contato",
			targetEntity = Contato.class)
	private List<Contato> contatos;
	
	public Pessoa() {}

	public Pessoa(Long id, String nome, String endereco, String cep, String cidade, String uf) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "[id = " + this.id +
				", nome = " + this.nome +
				", endereco = " + this.endereco +
				", cep = " + this.cep +
				", cidade = " + this.cidade +
				", uf = " + this.uf + "]";
	}
	
}
