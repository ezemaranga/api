package uade.tp.ai.reclamo;

import uade.tp.ai.Cliente;

public class ReclamoView {
	
	private String fecha;
	private String nroReclamo;
	private Cliente cliente;
	private String descripcion;
	private String estado;
	
	public static ReclamoView createReclamoView(Reclamo r) {
		ReclamoView rv = new ReclamoView();
		rv.setFecha(r.getFecha());
		rv.setNroReclamo(r.getNroReclamo());
		rv.setCliente(r.getCliente());
		rv.setDescripcion(r.getDescripcion());
		rv.setEstado(r.getEstado());
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

}
