package uade.tp.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {

	private static ConnectionManager connectionManager;
	private Connection connection;
	
	public static ConnectionManager getInstance() {
		if (connectionManager == null)
			connectionManager = new ConnectionManager();
		return connectionManager;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = getInstance().connect();
		
		PreparedStatement s = conn.prepareStatement("CREATE TABLE Cliente(Dni varchar(255),Nombre varchar(255),Domicilio varchar(255),Telefono varchar(255),Email varchar(255));");
		s.execute();
		
		
		System.out.println("conn created");
	}
	
	public Connection connect() {

		try {
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//connection = DriverManager.getConnection("jdbc:sqlserver://BD:1433", "A_Interactivas_01","A_Interactivas_01");
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net/sql9140087","sql9140087","JSm7bk1qZr");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connection;

	}

	public void closeCon() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
}	
