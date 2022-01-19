package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.models.Contato;

public class ContatoDAO {
	// Crud...
	

	
	// Create
	public void save(Contato contato) {

		String sql = "INSERT INTO contatos ( nome,idade,dataCadastro) VALUES(?,?,?)";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.createConnectionMySql();
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3 , new Date(contato.getDataCadastro().getTime()));
			
			pstm.execute();
			System.out.println("Contato criado");
		}catch( Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(con!=null) {
					con.close();
				}	
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// Read
	public List<Contato> getContatos(){
		String sql = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			con = ConnectionFactory.createConnectionMySql();
			pstm = con.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Contato contato = new Contato();
				
				contato.setId(rset.getInt("id"));
				contato.setNome(rset.getString("nome"));
				contato.setIdade(rset.getInt("idade"));
				contato.setDataCadastro(rset.getDate("dataCadastro"));
				
				// Adicionar contato a lista de contatos
				contatos.add(contato);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if ( rset != null && con !=null && pstm!=null) {
					rset.close();
					con.close();
					pstm.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return contatos;
	}
	
	// Update
	public void update(Contato contato) {
		String sql = "UPDATE contatos SET nome = ?,idade = ?, dataCadastro = ? WHERE id= ?";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.createConnectionMySql();
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			pstm.setInt(4, contato.getId());
			pstm.execute(); 

			System.out.println("Contato atualizado");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con !=null && pstm != null) {
				try {
					con.close();
					pstm.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
