package uade.tp.ai.reportes;

import uade.tp.ai.reclamo.ReclamoView;

public class ReporteRankingReclamos {

	private String tipoReclamo;
	private int cantReclamos;
	
	public ReporteRankingReclamosView getReporteRankingReclamosView() {
		ReporteRankingReclamosView rrv = ReporteRankingReclamosView.createReporteRankingReclamosView(this);
		return rrv;
	}
	
	
	public ReporteRankingReclamos(String tipoReclamo, int cantReclamos) {
		super();
		this.tipoReclamo = tipoReclamo;
		this.cantReclamos = cantReclamos;
	}
	
	public ReporteRankingReclamos() {
		super();
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
