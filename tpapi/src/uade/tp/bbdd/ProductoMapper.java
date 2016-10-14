package uade.tp.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import uade.tp.ai.Producto;

public class ProductoMapper extends Mapper {
	private static ProductoMapper instancia;

	public static ProductoMapper getInstancia() {
		if (instancia == null)
			instancia = new ProductoMapper();
		return instancia;
	}

	@Override
	public void delete(Object o) {
		try {
			Producto p = (Producto) o;
			
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("DELETE FROM Producto WHERE codigo = ?");
			s.setString(1, p.getCodPublicacion());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	@Override
	public void insert(Object o) {
		try {
			Producto p = (Producto) o;
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("INSERT INTO Producto (codigo, titulo, descripcion, precio) VALUES (?, ?, ?, ?)");
			s.setString(1, p.getCodPublicacion());
			s.setString(2, p.getTitulo());
			s.setString(3, p.getDescripcion());
			s.setFloat(4, p.getPrecio());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	@Override
	public Vector<Object> select(Object o) {
		Vector productosVector = new Vector();
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Producto");
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String codigo = result.getString(1);
				String titulo = result.getString(2);
				String descripcion = result.getString(3);
				float precio = result.getFloat(3);
				
				Producto p = new Producto(codigo, titulo, descripcion, precio);
				productosVector.add(p);
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return productosVector;
	}

	@Override
	public void update(Object o) {
		try {
			Producto p = (Producto) o;
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("UPDATE Producto " +
					"set titulo = ?," +
					"set descripcion = ?," +
					"set precio = ? WHERE codigo = ?");
			
			s.setString(1, p.getTitulo());
			s.setString(2, p.getDescripcion());
			s.setFloat(3, p.getPrecio());
			s.setString(4, p.getCodPublicacion());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	public Producto buscarProducto(String codPublicacion) {
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Producto WHERE codigo = ?");
			s.setString(1, codPublicacion);
			
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String codigo = result.getString(1);
				String titulo = result.getString(2);
				String descripcion = result.getString(3);
				float precio = result.getFloat(4);
				
				Producto p = new Producto(titulo, codigo, descripcion, precio);
				return p;
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return null;
	}

}
