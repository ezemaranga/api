package uade.tp.ai;

public class ItemFactura {
	
	private Producto producto;
	private int cant;

	public ItemFactura(Producto producto, int cantidad) {
		this.setProducto(producto);
		this.setCant(cantidad);
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}
	
}
