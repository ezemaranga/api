package uade.tp.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import uade.tp.ai.Cliente;
import uade.tp.ai.Factura;
import uade.tp.ai.ItemFactura;
import uade.tp.ai.Producto;

public class FacturaMapper extends Mapper {
	
	private static FacturaMapper instancia;

	public static FacturaMapper getInstancia() {
		if (instancia == null)
			instancia = new FacturaMapper();
		return instancia;
	}
	
	@Override
	public void delete(Object o) {
		try {
			Factura f = (Factura) o;
			
			//Primero borro los items asociados a la factura
			this.deleteItemsFactura(f.getNumero());
			
			//Despues borro la factua
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("DELETE FROM Factura WHERE numero = ? and fecha = ?");
			s.setString(1, f.getNumero());
			s.setString(2, f.getFecha());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	private void deleteItemsFactura(String numero) {
		try {
			Connection con = ConnectionManager.getInstance().connect();
			
			PreparedStatement s = con.prepareStatement("DELETE FROM ItemFactura WHERE numeroFactura = ?");
			s.setString(1, numero);
			
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	public Factura buscarFactura(String nro) {
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Factura WHERE numero = ?");
			s.setString(1, nro);
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String fecha = result.getString(1);
				String numero = result.getString(2);
				String dniCliente = result.getString(3);
				Cliente cliente = ClienteMapper.getInstancia().buscarCliente(dniCliente);
				
				List<ItemFactura> items = this.selectItemsFactura(nro);
				Factura f = new Factura(fecha, numero, cliente);
				f.addItems(items);
				return f;
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return null;
	}
	
	private List<ItemFactura> selectItemsFactura(String nroFactura) {
		List<ItemFactura> items = new ArrayList<ItemFactura>();
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM ItemFactura WHERE numeroFactura = ?");
			s.setString(1, nroFactura);
			ResultSet result = s.executeQuery();
			while (result.next()) {
				//La primer columna seria el numeroFactura que joinea con la factura. Por eso pido directamente la segunda columna
				String codigoProducto = result.getString(2);
				Producto producto = ProductoMapper.getInstancia().buscarProducto(codigoProducto);
				
				int cantidad = result.getInt(3);
				
				ItemFactura itemFactura = new ItemFactura(producto, cantidad);
				items.add(itemFactura);
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return items;
	}
	
	@Override
	public void insert(Object o) {
		try {
			Factura f = (Factura) o;
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("INSERT INTO Factura (fecha, numero, dniCliente) VALUES (?, ?, ?)");
			s.setString(1, f.getFecha());
			s.setString(2, f.getNumero());
			s.setString(3, f.getCliente().getDni());
			s.execute();
			ConnectionManager.getInstance().closeCon();
			
			this.insertItemsFactura(f.getNumero(), f.getItems());
		} catch (Exception e) {
			System.out.println();
		}
	}
	
	private void insertItemsFactura(String numeroFactura, List<ItemFactura> items) {
		try {
			Connection con = ConnectionManager.getInstance().connect();
			
			for(ItemFactura item : items) {
				PreparedStatement s = con.prepareStatement("INSERT INTO ItemFactura (numeroFactura, codigoProducto, cantidad) VALUES (?, ?, ?)");
				s.setString(1, numeroFactura);
				s.setString(2, item.getProducto().getCodPublicacion());
				s.setInt(3, item.getCant());
				s.execute();
			}

			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	@Override
	public Vector<Object> select(Object o) {
		Vector facturasVector = new Vector();
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Factura");
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String fecha = result.getString(1);
				String numero = result.getString(2);
				String dniCliente = result.getString(3);
				Cliente cliente = ClienteMapper.getInstancia().buscarCliente(dniCliente);
				
				List<ItemFactura> items = this.selectItemsFactura(numero);
				Factura f = new Factura(fecha, numero, cliente);
				f.addItems(items);
				facturasVector.add(f);
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return facturasVector;
	}

	@Override
	public void update(Object o) {
		try {
			Factura f = (Factura) o;
			//Hago directamente el update de los items, porque me parece que no tendria sentido updatear alguno de los campos de la factura.
			this.updateItemsFactura(f);
		} catch (Exception e) {
			System.out.println();
		}
	}
	
	private void updateItemsFactura(Factura f) {
		this.deleteItemsFactura(f.getNumero());
		this.insertItemsFactura(f.getNumero(), f.getItems());
	}

}
