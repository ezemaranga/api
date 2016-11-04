package uade.tp.ai.reportes;

public class ReporteTiempoPromedioView {

	private String usuario;
	private float tiempoRespuesta;
	private int cantReclamos;
	
	public static ReporteTiempoPromedioView createReporteTiempoPromedioView(ReporteTiempoPromedio r) {
		ReporteTiempoPromedioView rep = new ReporteTiempoPromedioView();
		
		rep.setUsuario(r.getUsuario());
		rep.setTiempoRespuesta(r.getTiempoRespuesta());
		rep.setCantReclamos(r.getCantReclamos());
		
		return rep;
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
