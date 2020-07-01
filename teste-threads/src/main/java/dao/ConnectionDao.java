package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import daoutils.ConnectionProperties;

public class ConnectionDao {

	private static Connection con;
	private static String user;
	private static String pass;
	private static String url;

	public static void abrirConexao() {
		try {
			ConnectionProperties props = new ConnectionProperties();
			user = props.getConnectionProperties().getProperty("user");
			pass = props.getConnectionProperties().getProperty("pass");
			url = props.getConnectionProperties().getProperty("url");

			con = DriverManager.getConnection(url, user, pass);
			
			System.out.println("Conexao aberta");
		} catch (Exception e) {
			System.out.println("Falha ao abrir conexao");
		}
	}

	public static void fecharConexao() throws SQLException {
		con.close();
	}
	
	public static Connection getConnection(){
		return con;
	}

}
