package br.com.eduardohmf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import br.com.eduardohmf.conta.ContaBancaria;
import br.com.eduardohmf.exception.LimiteCreditoExcedidoException;
import br.com.eduardohmf.poo.Aluno;
import br.com.eduardohmf.poo.Carro;

public class Principal {

	public static void lerArquivo(String nome) throws FileNotFoundException {
		FileInputStream file = new FileInputStream(nome);
	}
	
	public static void main(String[] args) {
		System.out.println("Bom dia turma!!!");
		
		try {
			int divisao = 10 / 0;
		} catch (ArithmeticException e) {
			System.out.println(" - Erro: " + e.getMessage() + "\n - - " + e.getStackTrace());
		}
				
		System.out.println("Saiu da divisao por zero");
		System.out.println("----------------------------------");
		
		try {
			int[] numeros = {0,1,2};
			
			int valor1 = 0;
			for(int i = 0; i <= 2; i++) {
				valor1 = numeros[i];			
				int valor2 = 10 / valor1;
				System.out.println("Valor2 = " + valor2);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(" - Erro ao buscar posicao no array: " + e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println(" - Erro em calculo: " + e.getMessage());
		}
		System.out.println("** Continuou 01");
		System.out.println("----------------------------------");
		
		try {
			lerArquivo("");
		} catch (FileNotFoundException e) {
			System.out.println(" - Erro ao ler arquivo: " + e.getMessage());
			//e.printStackTrace();
		}
		System.out.println("** Continuou 02");
		System.out.println("----------------------------------");
		
		ContaBancaria conta = new ContaBancaria();
		try {
			conta.fazerSaque(1500.0);
		} catch (LimiteCreditoExcedidoException e) {
			System.out.println(e.getMessage());
			System.out.println("Quantia excedida: " + e.getQuantiaExcedida());
		}
		
		/*
		boolean condicao = true;
		if(!condicao) {
			System.out.println("Condição verdadeira");
		}else {
			System.out.println("Condição falsa");
		}
		
		int x = 5;
		if(x > 5) {
			System.out.println("x > 5");
		}else if(x < 5) {
			System.out.println("x < 5");
		}else {
			System.out.println("x == 5");
		}
		
		//case
		int z = 2;
		switch(z) {
			case 1: System.out.println("z == 1"); break;
			case 2:
			case 3:
				System.out.println("z == 2 ou z == 3");
				break;
			case 10:
				System.out.println("z == 10");
				break;
			default:
				System.out.println("default");
				break;
		}
		System.out.println("----------------------------------");
		Carro carro = new Carro("VERDE", "BYD", "PLUS");
		System.out.println(carro.toString());
		System.out.println("----------------------------------");
				
		carro.setCor("AZUL");
		System.out.println(carro.toString());
		
		System.out.println("----------------------------------");
		
		// o carro do jão será um Fiat Mobi... 
		Carro jao = new Carro("FIAT", "MOBI");
		System.out.println(jao.toString());
		*/
		
		/*
		System.out.println("----------------------------------");
		
		Aluno aluno1 = new Aluno("0001","08/02/2024","Fulano","fulano@indra.com");		
		System.out.println(aluno1.toString());
		
		System.out.println("----------------------------------");
		
		Aluno aluno2 = new Aluno("0002","08/02/2024","Beltrano","beltrano@indra.com","61 00000-0000");
		System.out.println(aluno2.toString());
		
		System.out.println("----------------------------------");
		*/
		
	}

}