package uade.tp.ai.reportes;

public class ReporteCantRecepMesView {

	private String mes;
	private int cantidad;
	
	public static ReporteCantRecepMesView createReporteCantRecepMesView(ReporteCantRecepMes r) {
		ReporteCantRecepMesView rep = new ReporteCantRecepMesView();
		
		rep.setMes(r.getMes());
		rep.setCantidad(r.getCantidad());
		
		return rep;
	}
	
	public String getMes() {
		return mes;
	}
	
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
