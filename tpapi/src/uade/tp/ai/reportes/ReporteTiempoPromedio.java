package uade.tp.ai.reportes;

public class ReporteTiempoPromedio {
	
	private String usuario;
	private float tiempoRespuesta;
	private int cantReclamos;
	
	public ReporteTiempoPromedio(String usuario, float tiempoRespuesta, int cantReclamos) {
		super();
		this.usuario = usuario;
		this.tiempoRespuesta = tiempoRespuesta;
		this.cantReclamos = cantReclamos;
	}
	
	public ReporteTiempoPromedio() {
		super();
	}
	
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public float getTiempoRespuesta() {
		return tiempoRespuesta;
	}
	
	public void setTiempoRespuesta(float tiempoRespuesta) {
		this.tiempoRespuesta = tiempoRespuesta;
	}

	public int getCantReclamos() {
		return cantReclamos;
	}

	public void setCantReclamos(int cantReclamos) {
		this.cantReclamos = cantReclamos;
	}
	


}
