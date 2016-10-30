package uade.tp.ai.reclamo;

import java.util.List;

import uade.tp.ai.Cliente;
import uade.tp.ai.Factura;

public class ReclamoView {

	private String fecha;
	private String nroReclamo;
	private Cliente cliente;
	private String descripcion;
	private String estado;
	private String tipo;
	private String zona;
	private List<TratamientoReclamo> tratamientos;
	private List<ItemReclamo> items;
	private List<Factura> facturas;

	public static ReclamoView createReclamoView(Reclamo r) {
		ReclamoView rv = new ReclamoView();
		rv.setFecha(r.getFecha());
		rv.setNroReclamo(r.getNroReclamo());
		rv.setCliente(r.getCliente());
		rv.setDescripcion(r.getDescripcion());
		rv.setEstado(r.getEstadoActual());
		rv.setTipo(r.getTipo());
		rv.setTratamientos(r.getTratamientos());
		if(rv.getTipo() == "Facturacion") {
			rv.setFacturas(((ReclamoFacturacion) r).getFacturas());
		} else if(rv.getTipo() == "Producto"  || rv.getTipo() == "Faltante"  ||rv.getTipo() == "Cantidad") {
			rv.setItems(((ReclamoDistribucion) r).getItems());
		} else {
			rv.setZona(((ReclamoZona) r).getZona().getNombre());
		}
		return rv;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNroReclamo() {
		return nroReclamo;
	}

	public void setNroReclamo(String nroReclamo) {
		this.nroReclamo = nroReclamo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		switch (tipo) {
			case "RECLAMO_PRODUCTO":
				return "Producto";
			case "RECLAMO_FALTANTE":
				return "Faltante";
			case "RECLAMO_CANTIDAD":
				return "Cantidad";
			case "RECLAMO_FACTURACION":
				return "Facturacion";
			case "RECLAMO_ZONA":
				return "Zona";
			default:
				return "";
		}
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public List<TratamientoReclamo> getTratamientos() {
		return tratamientos;
	}

	public void setTratamientos(List<TratamientoReclamo> tratamientos) {
		this.tratamientos = tratamientos;
	}

	public List<ItemReclamo> getItems() {
		return items;
	}

	public void setItems(List<ItemReclamo> items) {
		this.items = items;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

}
