package uade.tp.ai;

public class UsuarioView {
	private String nombre;
	private String apellido;
	private String apodo;
	private String password;
	private String rol;

	public UsuarioView(String nombre, String apellido, String apodo, String password, String rol) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.apodo = apodo;
		this.password = password;
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getApodo() {
		return apodo;
	}

	public String getPassword() {
		return password;
	}

	public String getRol() {
		return rol;
	}
}
