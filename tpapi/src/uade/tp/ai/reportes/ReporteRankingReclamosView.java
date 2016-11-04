package uade.tp.ai.reportes;

public class ReporteRankingReclamosView {

	private String tipoReclamo;
	private int cantReclamos;
	
	public static ReporteRankingReclamosView createReporteRankingReclamosView(ReporteRankingReclamos r) {
		ReporteRankingReclamosView rep = new ReporteRankingReclamosView();
		
		rep.setTipoReclamo(r.getTipoReclamo());
		rep.setCantReclamos(r.getCantReclamos());
		
		return rep;
	}
	
	
	public String getTipoReclamo() {
		return tipoReclamo;
	}
	
	public void setTipoReclamo(String tipoReclamo) {
		this.tipoReclamo = tipoReclamo;
	}
	
	public int getCantReclamos() {
		return cantReclamos;
	}
	
	public void setCantReclamos(int cantReclamos) {
		this.cantReclamos = cantReclamos;
	}
	
}
