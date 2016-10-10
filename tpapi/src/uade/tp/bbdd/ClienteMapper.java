package uade.tp.bbdd;

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
	public void delete(Object d) {

	}

	@Override
	public void insert(Object o) {

	}

	@Override
	public Vector<Object> select(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object o) {

	}

	public Cliente buscarCliente(String dni) {
		return null;
	}

}
