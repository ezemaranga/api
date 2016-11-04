package uade.tp.ai.reportes;

public class ReporteRankingCliente {
	
	private String idCliente;
	private String nombre;
	private int cantReclamos;
	
	public ReporteRankingClienteView getReporteRankingClienteView() {
		ReporteRankingClienteView rrc = ReporteRankingClienteView.createReporteRankingClienteView(this);
		return rrc;
	}
	
	public ReporteRankingCliente(String idCliente, String nombre, int cantReclamos) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.cantReclamos = cantReclamos;
	}
	
	public ReporteRankingCliente() {
		super();
	}
	
	public String getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCantReclamos() {
		return cantReclamos;
	}
	
	public void setCantReclamos(int cantReclamos) {
		this.cantReclamos = cantReclamos;
	}

}
