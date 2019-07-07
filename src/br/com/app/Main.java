package br.com.app;

import java.util.ArrayList;
import java.util.List;

import br.com.listavip.Convidado;
import br.com.listavip.ConvidadoService;

public class Main {

	public static void main(String[] args) {

		System.out.println("Mostrando Lista de Convidados ...");
		System.out.println(" ");
		
		List<Convidado> convidados = new ArrayList<>();
		
		convidados = new ConvidadoService().obterTodos();   
		   
		
		
		for (Convidado convidado : convidados) {

			System.out.println(convidado.getNome());

		}

	}

}
