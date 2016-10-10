package uade.tp.bbdd;

import java.util.Date;
import java.util.Vector;

import uade.tp.ai.Factura;
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

	public Zona buscarZona(String codZona) {
		// TODO Auto-generated method stub
		return null;
	}

}
