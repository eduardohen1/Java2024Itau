package br.com.eduardohmf.poo;

public class Pessoa {
	
	private String nome;
	private String email;
	private String telefone;
	
	//construtor:
	public Pessoa(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	public Pessoa(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.telefone = "-";
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Nome = " + this.nome + "\nE-mail = " + this.email;
	}
	

}
