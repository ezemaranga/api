package uade.tp.ai;

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

}
