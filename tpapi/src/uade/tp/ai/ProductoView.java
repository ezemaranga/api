package uade.tp.ai;

public class ProductoView {

	private String titulo;
	private String codPublicacion;
	private String descripcion; 
	private float precio;

	public ProductoView(String titulo, String codPublicacion, String descripcion, float precio) {
		this.titulo = titulo;
		this.codPublicacion = codPublicacion;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public String getCodPublicacion() {
		return codPublicacion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public float getPrecio() {
		return precio;
	}
	
    @Override
    public String toString(){
        return titulo;
    }
}
