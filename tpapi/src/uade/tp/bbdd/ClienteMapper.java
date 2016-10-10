package uade.tp.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import uade.tp.ai.Cliente;

public class ClienteMapper extends Mapper {
	private static ClienteMapper instancia;

	public static ClienteMapper getInstancia() {
		if (instancia == null)
			instancia = new ClienteMapper();
		return instancia;
	}

	@Override
	public void delete(Object o) {
		try {
			Cliente c = (Cliente) o;
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("DELETE FROM Cliente WHERE dni = ?");
			s.setString(1, c.getDni());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	@Override
	public void insert(Object o) {
		try {
			Cliente c = (Cliente) o;
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("INSERT INTO Cliente (dni, nombre, domicilio, telefono, email) VALUES (?, ?, ?, ?, ?)");
			s.setString(1, c.getDni());
			s.setString(2, c.getNombre());
			s.setString(3, c.getDomicilio());
			s.setString(4, c.getTelefono());
			s.setString(5, c.getEmail());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	@Override
	public Vector<Object> select(Object o) {
		Vector clientesVector = new Vector();
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Cliente");
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String dni = result.getString(1);
				String nombre = result.getString(2);
				String domicilio = result.getString(3);
				String telefono = result.getString(4);
				String email = result.getString(5);
				Cliente c = new Cliente(dni, nombre, domicilio, telefono, email);
				clientesVector.add(c);
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return clientesVector;
	}

	@Override
	public void update(Object o) {
		try {
			Cliente c = (Cliente) o;
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("UPDATE Cliente " +
					"set nombre = ?," +
					"set domicilio = ?," +
					"set telefono = ?," +
					"set email = ?");
			
			s.setString(1, c.getNombre());
			s.setString(2, c.getDomicilio());
			s.setString(3, c.getTelefono());
			s.setString(4, c.getEmail());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	public Cliente buscarCliente(String dniCliente) {
		try {
			Cliente c = null;
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Cliente WHERE dni = ?");
			s.setString(1, dniCliente);
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String dni = result.getString(1);
				String nombre = result.getString(2);
				String domicilio = result.getString(3);
				String telefono = result.getString(4);
				String email = result.getString(5);
				c = new Cliente(dni, nombre, domicilio, telefono, email);
				return c;
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return null;
	}

}
