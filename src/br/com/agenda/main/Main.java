package br.com.agenda.main;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.models.Contato;

public class Main {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Samus");
		contato.setIdade(32);
		contato.setDataCadastro(new Date());
		contato.setId(3);
		
		ContatoDAO contatoDao = new ContatoDAO();
		// contatoDao.save(contato);
		contatoDao.update(contato);
		
		// Visualização de Dados utilizando for each 
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("Nome do Contato:" + c.getNome());
		}
	}
}
