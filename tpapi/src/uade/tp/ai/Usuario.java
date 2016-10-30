package uade.tp.ai;

public class Usuario {

	private String nombre;
	private String apellido;
	private String apodo;
	private String password;
	private String rol;

	public Usuario(String nombre, String apellido, String apodo, String password, String rol) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.apodo = apodo;
		this.password = password;
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public UsuarioView getView() {
		return new UsuarioView(nombre, apellido, apodo, password, rol);
	}

}
