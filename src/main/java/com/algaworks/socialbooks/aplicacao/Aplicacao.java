package com.algaworks.socialbooks.aplicacao;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.http.RequestEntity;

import com.algaworks.socialbooks.client.LivrosClient;
import com.algaworks.socialbooks.client.domain.Livro;

public class Aplicacao {
	
	public static void main(String[] args) throws ParseException {
		
		LivrosClient cliente = new LivrosClient("http://localhost:8080", "algaworks", "leo123");
		
		List<Livro> listaLivros = cliente.listar();
		
		for(Livro livro :listaLivros){
			System.out.println("Livro: " + livro.getNome());
		}
		Livro livro = new Livro();
		
		livro.setNome("A cabana");
		livro.setEditora("algaworks");
		
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(publicacao.parse("01/01/2011"));
		
		livro.setResumo("livro de desenvolvimento api");
		
		String localizacao = cliente.salvar(livro);
		
		System.out.println("URI do livro salvo: " + localizacao);
		
		Livro livrobuscado = cliente.buscar(localizacao);
		System.out.println("Livro buscado: " + livrobuscado.getNome());
		
	}
	
	
}
