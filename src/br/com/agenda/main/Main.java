package br.com.agenda.main;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.models.Contato;

public class Main {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Steven");
		contato.setIdade(13);
		contato.setDataCadastro(new Date());
		
		ContatoDAO contatoDao = new ContatoDAO();
		contatoDao.save(contato);
		
		// Visualização de Dados
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("Nome do Contato:" + c.getNome());
		}
	}
}
