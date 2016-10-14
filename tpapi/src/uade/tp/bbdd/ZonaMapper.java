package uade.tp.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import uade.tp.ai.Zona;

public class ZonaMapper extends Mapper {
	
	private static ZonaMapper instancia;

	public static ZonaMapper getInstancia() {
		if (instancia == null)
			instancia = new ZonaMapper();
		return instancia;
	}

	@Override
	public void insert(Object o) {
		try {
			Zona z = (Zona) o;
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("INSERT INTO Zona (codigo, nombre) VALUES (?, ?)");
			s.setString(1, z.getCodigo());
			s.setString(2, z.getNombre());
			
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	@Override
	public void update(Object o) {
		try {
			Zona z = (Zona) o;
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("UPDATE Zona " +
					"set nombre = ? WHERE codigo = ?");
			
			s.setString(1, z.getNombre());
			s.setString(2, z.getCodigo());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	@Override
	public void delete(Object o) {
		try {
			Zona z = (Zona) o;
			
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("DELETE FROM Zona WHERE codigo = ?");
			s.setString(1, z.getCodigo());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	@Override
	public Vector<Object> select(Object o) {
		Vector zonasVector = new Vector();
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Zona");
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String codigo = result.getString(1);
				String nombre = result.getString(2);
				
				Zona z = new Zona(codigo, nombre);
				zonasVector.add(z);
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return zonasVector;
	}

	public Zona buscarZona(String codZona) {
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Zona WHERE codigo = ?");
			s.setString(1, codZona);
			
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String codigo = result.getString(1);
				String nombre = result.getString(2);
				
				Zona z = new Zona(codigo, nombre);
				return z;
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return null;
	}

}
