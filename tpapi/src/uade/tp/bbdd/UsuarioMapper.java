package uade.tp.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import uade.tp.ai.Usuario;
import uade.tp.ai.UsuarioView;

public class UsuarioMapper extends Mapper {
	private static UsuarioMapper instancia;

	public static UsuarioMapper getInstancia() {
		if (instancia == null)
			instancia = new UsuarioMapper();
		return instancia;
	}

	@Override
	public void delete(Object o) {
		try {
			Usuario u = (Usuario) o;
			
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("DELETE FROM Usuario WHERE apodo = ? AND password = ?");
			s.setString(1, u.getApodo());
			s.setString(2, u.getPassword());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	@Override
	public void insert(Object o) {
		try {
			Usuario u = (Usuario) o;
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("INSERT INTO Usuario (apodo, nombre, apellido, password, rol) VALUES (?, ?, ?, ?, ?)");
			s.setString(1, u.getApodo());
			s.setString(2, u.getNombre());
			s.setString(3, u.getApellido());
			s.setString(4, u.getPassword());
			s.setString(5, u.getRol());
			
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	@Override
	public Vector<Object> select(Object o) {
		Vector usuariosVector = new Vector();
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Usuario");
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String apodo  = result.getString(1);
				String nombre = result.getString(2);
				String apellido = result.getString(3);
				String password = result.getString(4);
				String rol = result.getString(5);
				
				Usuario u = new Usuario(apodo, nombre, apellido, password, rol);
				usuariosVector.add(u);
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return usuariosVector;
	}

	@Override
	public void update(Object o) {
		try {
			Usuario u = (Usuario) o;
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("UPDATE Usuario " +
					"set password = ?, rol = ? WHERE apodo");
			
			s.setString(1, u.getPassword());
			s.setString(2, u.getRol());
			s.setString(3, u.getApodo());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	public UsuarioView buscarUsuario(String apodoUsuario, String passwordUsuario) {
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Usuario WHERE apodo = ? AND password = ?");
			s.setString(1, apodoUsuario);
			s.setString(2, passwordUsuario);
			
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String apodo  = result.getString(1);
				String nombre = result.getString(2);
				String apellido = result.getString(3);
				String password = result.getString(4);
				String rol = result.getString(5);
				
				Usuario u = new Usuario(apodo, nombre, apellido, password, rol);
				return u.getView();
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return null;
	}

}
