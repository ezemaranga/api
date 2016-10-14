package uade.tp.ai;

public class ZonaView {

	private String codigo;
	private String nombre; 
	
	public ZonaView(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}
	
    @Override
    public String toString(){
        return nombre;
    }
	
}
