package uade.tp.bbdd;

import java.util.Vector;

import uade.tp.ai.Usuario;

public class UsuarioMapper extends Mapper {
	private static UsuarioMapper instancia;

	public static UsuarioMapper getInstancia() {
		if (instancia == null)
			instancia = new UsuarioMapper();
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

	public Usuario buscarUsuario(String apodo, String password) {
		return null;
	}

}
