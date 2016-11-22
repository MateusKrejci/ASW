package br.edu.ifsp.taskfacil.app;

public class Teste {

	public static void main(String[] args) {

		boolean validaEmail = "mateus.krejci@live.com.br".matches("\\w+(\\.)?\\w+@\\w+\\.\\w{2,3}(\\.\\w{2,3})?");
		System.out.println(validaEmail);
	}

}
