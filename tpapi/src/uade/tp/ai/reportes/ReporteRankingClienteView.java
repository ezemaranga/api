package uade.tp.ai.reportes;

public class ReporteRankingClienteView {

	private String idCliente;
	private String nombre;
	private int cantReclamos;
	
	public static ReporteRankingClienteView createReporteRankingClienteView(ReporteRankingCliente r) {
		ReporteRankingClienteView rep = new ReporteRankingClienteView();
		
		rep.setIdCliente(r.getIdCliente());
		rep.setNombre(r.getNombre());
		rep.setCantReclamos(r.getCantReclamos());
		
		return rep;
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
