package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	// Conexão JDBC com o banco de dados
	public static Connection createConnectionMySql() throws ClassNotFoundException, SQLException {
		// Faz classe ser carregada pela jvm
		// Não é necessário Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = createConnectionMySql();
		if (con!=null) {
			System.out.println("Conexão foi feita!");
			con.close();
		}
	}
}
