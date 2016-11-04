package uade.tp.ai.reportes;

public class ReporteCantRecepMes {

	private String mes;
	private int cantidad;
	
	public ReporteCantRecepMes(String mes, int cantidad) {
		super();
		this.mes = mes;
		this.cantidad = cantidad;
	}

	public ReporteCantRecepMes() {
		super();
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
