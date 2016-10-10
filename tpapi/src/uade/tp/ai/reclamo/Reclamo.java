package uade.tp.ai.reclamo;

import uade.tp.ai.Cliente;
import uade.tp.ai.Usuario;

public abstract class Reclamo {
	
	private String fecha;
	private String nroReclamo;
	private Cliente cliente;
	private String descripcion;
	private String estado;
	
	public ReclamoView getReclamoView(Usuario u) {
		ReclamoView rv = null;
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
	
	public abstract void agregarATablero();

}
