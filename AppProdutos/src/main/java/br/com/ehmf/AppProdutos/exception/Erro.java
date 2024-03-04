package br.com.ehmf.AppProdutos.exception;

import java.time.LocalDateTime;

public class Erro {
	
	private String erro;
	private LocalDateTime time;
	private String sistema;
	
	public Erro() {}
	public Erro(String erro, String sistema) {
		this.erro = erro;
		this.sistema = sistema;
		this.time = LocalDateTime.now();
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getSistema() {
		return sistema;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	
	
	
}
