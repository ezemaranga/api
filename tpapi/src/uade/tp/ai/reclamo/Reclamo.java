package uade.tp.ai.reclamo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uade.tp.ai.Cliente;

public abstract class Reclamo {
	
	private String fecha;
	private String nroReclamo;
	private Cliente cliente;
	private String descripcion;
	private String estadoActual;
	private List<TratamientoReclamo> tratamientos = new ArrayList<TratamientoReclamo>();
	
	public ReclamoView getReclamoView() {
		ReclamoView rv = ReclamoView.createReclamoView(this);
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

	public String getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(String estado) {
		this.estadoActual = estado;
	}
	
	public void agregarTratamiento(String desc, String estado) {
		this.tratamientos.add(new TratamientoReclamo(new Date().toString(), estado, desc));
	}
	
	public abstract void agregarATablero();

}
