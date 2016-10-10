package uade.tp.ai.reclamo;

import uade.tp.ai.Producto;

public class ItemReclamo {
	
	private Producto producto;
	private int cantidad;

	public ItemReclamo(Producto prod, int cant) {
		this.producto = prod;
		this.cantidad = cant;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
