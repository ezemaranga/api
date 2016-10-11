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
import uade.tp.ai.reclamo.Reclamo;

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
			this.deleteReclamoTablasAnexas(r.getNroReclamo());
			
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
	
	private void deleteReclamoTablasAnexas(String nroReclamo) {
		this.deleteReclamoFacturacion(nroReclamo);
		this.deleteReclamoDistribucion(nroReclamo);
		this.deleteReclamoZona(nroReclamo);
		this.deleteReclamoCompuesto(nroReclamo);
		this.deleteTratamientoReclamo(nroReclamo);
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
	
	private void deleteReclamoCompuesto(String nroReclamo) {
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("DELETE FROM ReclamoCompuesto WHERE NroReclamo = ?");
			s.setString(1, nroReclamo);
			s.execute();
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
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
			PreparedStatement s = con.prepareStatement("SELECT * FROM Reclamo WHERE Tipo = 'Distribucion'");
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

	private Reclamo buildReclamoDistribucion(String nroReclamo, String fecha, Cliente cliente, String desc, String estado, String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reclamo> getReclamosZona() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reclamo> getReclamosFacturacion() {
		// TODO Auto-generated method stub
		return null;
	}

}
