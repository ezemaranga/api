package uade.tp.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import uade.tp.ai.Cliente;
import uade.tp.ai.Factura;
import uade.tp.ai.Producto;
import uade.tp.ai.Zona;
import uade.tp.ai.reclamo.ItemReclamo;
import uade.tp.ai.reclamo.Reclamo;
import uade.tp.ai.reclamo.ReclamoCantidad;
import uade.tp.ai.reclamo.ReclamoCompuesto;
import uade.tp.ai.reclamo.ReclamoDistribucion;
import uade.tp.ai.reclamo.ReclamoFacturacion;
import uade.tp.ai.reclamo.ReclamoFaltante;
import uade.tp.ai.reclamo.ReclamoProducto;
import uade.tp.ai.reclamo.ReclamoZona;
import uade.tp.ai.reclamo.TratamientoReclamo;

public class ReclamoMapper extends Mapper {
	private static ReclamoMapper instancia;

	public static ReclamoMapper getInstancia() {
		if (instancia == null)
			instancia = new ReclamoMapper();
		return instancia;
	}

	@Override
	public void delete(Object o) {
		try {
			Reclamo r = (Reclamo) o;
			
			//Primero borro los atributos asociados al reclamo
			this.deleteReclamoTablasAnexas(r);
			
			//Despues borro el reclamo en si.
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("DELETE FROM Reclamo WHERE NroReclamo = ?");
			s.setString(1, r.getNroReclamo());
			s.execute();
			
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}
	
	private void deleteReclamoTablasAnexas(Reclamo r) throws SQLException {
		this.deleteReclamoFacturacion(r.getNroReclamo());
		this.deleteReclamoDistribucion(r.getNroReclamo());
		this.deleteReclamoZona(r.getNroReclamo());
		this.deleteReclamoCompuesto(r);
		this.deleteTratamientoReclamo(r.getNroReclamo());
	}
	
	private void deleteReclamoFacturacion(String nroReclamo) {
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("DELETE FROM ReclamoFacturacion WHERE NroReclamo = ?");
			s.setString(1, nroReclamo);
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}
	
	private void deleteReclamoDistribucion(String nroReclamo) {
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("DELETE FROM ReclamoDistribucion WHERE NroReclamo = ?");
			s.setString(1, nroReclamo);
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}
	
	private void deleteReclamoZona(String nroReclamo) {
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("DELETE FROM ReclamoZona WHERE NroReclamo = ?");
			s.setString(1, nroReclamo);
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}
	
	private void deleteReclamoCompuesto(Reclamo r) throws SQLException {
		if(r.getTipo().equals("RECLAMO_COMPUESTO")) {
			for(Reclamo rec : ((ReclamoCompuesto) r).getReclamos()) {
				this.delete(rec);
			}
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("DELETE FROM ReclamoCompuesto WHERE NroReclamo = ?");
			s.setString(1, r.getNroReclamo());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		}	
	}
	
	private void deleteTratamientoReclamo(String nroReclamo) {
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("DELETE FROM TratamientoReclamo WHERE NroReclamo = ?");
			s.setString(1, nroReclamo);
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
	}

	@Override
	public void insert(Object o) {
		try {
			Reclamo r = (Reclamo) o;
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("INSERT INTO Reclamo (fecha, DniCliente, Descripcion, EstadoActual, Tipo) VALUES (?, ?, ?, ?, ?)");
			s.setString(1, r.getFecha());
			s.setString(2, r.getCliente().getDni());
			s.setString(3, r.getDescripcion());
			s.setString(4, r.getEstadoActual());
			s.setString(5, r.getTipo());
			s.execute();
			ConnectionManager.getInstance().closeCon();
			
			this.insertReclamoTablasAnexas(r);
		} catch (Exception e) {
			System.out.println();
		}
	}
	
	private void insertReclamoTablasAnexas(Reclamo r) throws SQLException {
		this.insertTratamientoReclamo(r);
		if (r.getTipo().equals("RECLAMO_COMPUESTO")) {
			this.insertReclamoCompuesto((ReclamoCompuesto) r);
		} else if (r.getTipo().equals("RECLAMO_CANTIDAD") || r.getTipo().equals("RECLAMO_FALTANTE") || r.getTipo().equals("RECLAMO_PRODUCTO")) {
			this.insertReclamoDistribucion((ReclamoDistribucion) r);
		} else if (r.getTipo().equals("RECLAMO_FACTURACION")) {
			this.insertReclamoFacturacion((ReclamoFacturacion) r);
		} else if (r.getTipo().equals("RECLAMO_ZONA")) {
			this.insertReclamoZona((ReclamoZona) r);
		}
	}
	
	private void insertTratamientoReclamo(Reclamo r) throws SQLException {
		for(TratamientoReclamo t : r.getTratamientos()) {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("INSERT INTO TratamientoReclamo (NroReclamo, Fecha, Estado, Descripcion) VALUES (?, ?, ?, ?)");
			s.setString(1, r.getNroReclamo());
			s.setString(2, t.getFecha());
			s.setString(3, t.getEstado());
			s.setString(4, t.getDesc());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		}
	}
	
	public void insertReclamoCompuesto(ReclamoCompuesto r) throws SQLException {
		for(Reclamo rec : r.getReclamos()) {
			this.insert(rec);
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("INSERT INTO ReclamoCompuesto (NroReclamo, NroReclamoComponente) VALUES (?, ?)");
			s.setString(1, r.getNroReclamo());
			s.setString(2, rec.getNroReclamo());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		}
	}
	
	private void insertReclamoDistribucion(ReclamoDistribucion r) throws SQLException {
		for(ItemReclamo ir : r.getItemsReclamo()) {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("INSERT INTO ReclamoDistribucion (NroReclamo, CodigoProducto, Cantidad) VALUES (?, ?, ?)");
			s.setString(1, r.getNroReclamo());
			s.setString(2, ir.getProducto().getCodPublicacion());
			s.setInt(3, ir.getCantidad());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		}
	}
	
	private void insertReclamoFacturacion(ReclamoFacturacion r) throws SQLException {
		for(Factura f : r.getFacturas()) {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("INSERT INTO ReclamoFacturacion (NroReclamo, NumeroFactura) VALUES (?, ?)");
			s.setString(1, r.getNroReclamo());
			s.setString(2, f.getNumero());
			s.execute();
			ConnectionManager.getInstance().closeCon();
		}
	}
	
	private void insertReclamoZona(ReclamoZona r) throws SQLException {
		Connection con = ConnectionManager.getInstance().connect();
		PreparedStatement s = con.prepareStatement("INSERT INTO ReclamoZona (NroReclamo, CodigoZona) VALUES (?, ?)");
		s.setString(1, r.getNroReclamo());
		s.setString(2, r.getZona().getCodigo());
		s.execute();
		ConnectionManager.getInstance().closeCon();
	}

	@Override
	public Vector<Object> select(Object o) {
		return null;
	}

	@Override
	public void update(Object o) {

	}

	public Reclamo buscarReclamo(String nro) {
		return null;
	}

	public List<Reclamo> getReclamosDistribucion() {
		List<Reclamo> reclamos = new ArrayList<Reclamo>();
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Reclamo WHERE Tipo in ('RECLAMO_CANTIDAD', 'RECLAMO_FALTANTE', 'RECLAMO_PRODUCTO'");
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String nroReclamo = result.getString(1);
				String fecha = result.getString(2);
				String dniCliente = result.getString(3);
				Cliente cliente = ClienteMapper.getInstancia().buscarCliente(dniCliente);
				String descripcion = result.getString(4);
				String estadoActual = result.getString(5);
				String tipo = result.getString(6);
				
				Reclamo reclamo = this.buildReclamoDistribucion(nroReclamo, fecha, cliente, descripcion, estadoActual, tipo);
				reclamos.add(reclamo);
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return reclamos;
	}

	private Reclamo buildReclamoDistribucion(String nroReclamo, String fecha, Cliente cliente, String desc, String estado, String tipo) throws SQLException {
		ReclamoDistribucion reclamo = null;
		if(tipo.equals("RECLAMO_CANTIDAD")) {
			reclamo = new ReclamoCantidad();
		} else if (tipo.equals("RECLAMO_FALTANTE")) {
			reclamo = new ReclamoFaltante();
		} else if (tipo.equals("RECLAMO_PRODUCTO")) {
			reclamo = new ReclamoProducto();
		}
		
		reclamo.setNroReclamo(nroReclamo);
		reclamo.setFecha(fecha);
		reclamo.setCliente(cliente);
		reclamo.setDescripcion(desc);
		reclamo.setEstadoActual(estado);
		
		List<ItemReclamo> items = this.selectItemsReclamo(nroReclamo);
		for(ItemReclamo item : items) {
			reclamo.addItemReclamo(item.getProducto(), item.getCantidad());
		}
		return reclamo;
	}
	
	private List<ItemReclamo> selectItemsReclamo(String nroReclamo) throws SQLException {
		List<ItemReclamo> items = new ArrayList<ItemReclamo>();
		Connection con = ConnectionManager.getInstance().connect();
		PreparedStatement s = con.prepareStatement("SELECT * FROM ReclamoDistribucion WHERE NroReclamo = ?");
		s.setString(1, nroReclamo);
		ResultSet result = s.executeQuery();
		while (result.next()) {
			String codigoProducto = result.getString(2);
			int cantidad = result.getInt(3);
			
			Producto prod = ProductoMapper.getInstancia().buscarProducto(codigoProducto);
			ItemReclamo ir = new ItemReclamo(prod, cantidad);
			
			items.add(ir);
		}
		ConnectionManager.getInstance().closeCon();
		return items;
	}

	public List<Reclamo> getReclamosZona() {
		List<Reclamo> reclamos = new ArrayList<Reclamo>();
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Reclamo WHERE Tipo = 'RECLAMO_ZONA'");
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String nroReclamo = result.getString(1);
				String fecha = result.getString(2);
				String dniCliente = result.getString(3);
				Cliente cliente = ClienteMapper.getInstancia().buscarCliente(dniCliente);
				String descripcion = result.getString(4);
				String estadoActual = result.getString(5);
				String tipo = result.getString(6);
				
				Reclamo reclamo = this.buildReclamoZona(nroReclamo, fecha, cliente, descripcion, estadoActual, tipo);
				reclamos.add(reclamo);
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return reclamos;
	}
	
	private Reclamo buildReclamoZona(String nroReclamo, String fecha, Cliente cliente, String descripcion, String estadoActual, String tipo) throws SQLException {
		ReclamoZona reclamo = new ReclamoZona();;
		
		reclamo.setNroReclamo(nroReclamo);
		reclamo.setFecha(fecha);
		reclamo.setCliente(cliente);
		reclamo.setDescripcion(descripcion);
		reclamo.setEstadoActual(estadoActual);
		
		Zona zona = this.selectZonaReclamo(nroReclamo);
		reclamo.setZona(zona);
		
		return reclamo;
	}

	private Zona selectZonaReclamo(String nroReclamo) throws SQLException {
		Zona zona = null;
		Connection con = ConnectionManager.getInstance().connect();
		PreparedStatement s = con.prepareStatement("SELECT * FROM ReclamoZona WHERE NroReclamo = ?");
		s.setString(1, nroReclamo);
		ResultSet result = s.executeQuery();
		while (result.next()) {
			String codigoZona = result.getString(2);
			zona = ZonaMapper.getInstancia().buscarZona(codigoZona);
		}
		ConnectionManager.getInstance().closeCon();
		return zona;
	}

	public List<Reclamo> getReclamosFacturacion() {
		// TODO Auto-generated method stub
		return null;
	}

}
