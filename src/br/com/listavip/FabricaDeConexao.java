package br.com.listavip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {

	public Connection obterConexao() {

		try {

			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			String serverName = "localhost:3306";
			
			String porta = ":3306";

			String mydatabase = "listavip"; 
            // + "?useSSL=false"
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase+ "?useSSL=false";

			String username = "root";

			String password = "1234";

			Connection connection = DriverManager.getConnection(url, username, password);

			return connection;

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());
			return null;
			

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			return null;

		}

	}

}
