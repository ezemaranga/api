package uade.tp.ai;

public class ClienteView {

	private String nombre;
	private String domicilio;
	private String telefono;
	private String email;
	private String dni;
 
	public ClienteView(String nombre, String domicilio, String telefono, String email, String dni) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.email = email;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public String getDni() {
		return dni;
	}
}
