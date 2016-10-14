package uade.tp.ai;

import uade.tp.bbdd.ClienteMapper;

public class Cliente {

	private String nombre;
	private String domicilio;
	private String telefono;
	private String email;
	private String dni;

	public Cliente(String nombre, String domicilio, String telefono, String email, String dni) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.email = email;
		this.dni = dni;
	}
	
	public void guardar() {
		ClienteMapper.getInstancia().insert(this);
	}
	
	public void borrar() {
		ClienteMapper.getInstancia().delete(this);
	}
	
	public static Cliente buscar(String dniCliente) {
		return ClienteMapper.getInstancia().buscarCliente(dniCliente);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public ClienteView getView() {
		ClienteView cv = new ClienteView(nombre, domicilio, telefono, email, dni);
		
		return cv;
	}
	
}
