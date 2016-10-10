package uade.tp.bbdd;

import java.util.Vector;

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

}
