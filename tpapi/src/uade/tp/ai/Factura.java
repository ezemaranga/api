package uade.tp.ai;

import java.util.ArrayList;
import java.util.List;

import uade.tp.bbdd.FacturaMapper;

public class Factura {

	private String fecha;
	private String numero;
	private Cliente cliente;
	private List<ItemFactura> items;

	public Factura(String fecha, String numero, Cliente cliente) {
		this.fecha = fecha;
		this.numero = numero;
		this.cliente = cliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}
	
	public void addItem(Producto prod, int cantidad) {
		if(this.items == null) {
			this. items = new ArrayList<ItemFactura>();
		}
		this.items.add(new ItemFactura(prod, cantidad));
	}
	
	public void addItems(List<ItemFactura> items) {
		this.items = items;
	}

	public void guardar() {
		FacturaMapper.getInstancia().insert(this);
	}
	
	public void borrar() {
		FacturaMapper.getInstancia().delete(this);
	}
	
	public static Factura buscar(String nroFactura) {
		return FacturaMapper.getInstancia().buscarFactura(nroFactura);
	}
	
}
