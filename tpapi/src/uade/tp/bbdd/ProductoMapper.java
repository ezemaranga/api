package uade.tp.bbdd;

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

	public Producto buscarProducto(String codPublicacion) {
		return null;
	}

}
