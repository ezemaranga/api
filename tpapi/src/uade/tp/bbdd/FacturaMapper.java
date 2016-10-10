package uade.tp.bbdd;

import java.util.Date;
import java.util.Vector;

import uade.tp.ai.Factura;

public class FacturaMapper extends Mapper {
	
	private static FacturaMapper instancia;

	public static FacturaMapper getInstancia() {
		if (instancia == null)
			instancia = new FacturaMapper();
		return instancia;
	}

	@Override
	public void insert(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object d) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector<Object> select(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Factura buscarFactura(String nro, Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

}
