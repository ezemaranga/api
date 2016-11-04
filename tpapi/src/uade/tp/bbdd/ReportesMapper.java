package uade.tp.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import uade.tp.ai.reportes.ReporteCantRecepMes;
import uade.tp.ai.reportes.ReporteRankingCliente;
import uade.tp.ai.reportes.ReporteRankingReclamos;
import uade.tp.ai.reportes.ReporteTiempoPromedio;

public class ReportesMapper {

	private static ReportesMapper instancia;

	public static ReportesMapper getInstancia() {
		if (instancia == null)
			instancia = new ReportesMapper();
		return instancia;
	}
	
	public List<ReporteRankingCliente> obtenerReporteRankingCliente(){
		
		List<ReporteRankingCliente> reclamos = new ArrayList<ReporteRankingCliente>();
		
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("select distinct re.DniCliente, cli.Nombre, (select count(*) from Reclamo where DniCliente = re.DniCliente) as cantidad  " +
			                                            "from Reclamo re, Cliente cli " +
			                                            " where re.DniCliente = cli.Dni " +
			                                            " order by cantidad desc");
			
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String  dniCli    = result.getString(1);
				String  nombreCli = result.getString(2);
				int     cantidad  = result.getInt(3);
				
				ReporteRankingCliente ReporteRankingCliente = new ReporteRankingCliente(dniCli, nombreCli, cantidad);
				reclamos.add(ReporteRankingCliente);
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return reclamos;
	}
	
	public List<ReporteRankingReclamos> obtenerReporteRankingReclamos(){
		
		List<ReporteRankingReclamos> reclamos = new ArrayList<ReporteRankingReclamos>();
		try {
			Connection con = ConnectionManager.getInstance().connect();
			PreparedStatement s = con.prepareStatement("select distinct Tipo, (select count(*) from Reclamo where Tipo = re.Tipo) as cantidad  " +
			                                            "from Reclamo re order by cantidad desc");
			
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String tipoReclamo = result.getString(1);
				int  cantidad = result.getInt(2);
				
				ReporteRankingReclamos reclamoReporteRankingReclamos = new ReporteRankingReclamos(tipoReclamo, cantidad);
				reclamos.add(reclamoReporteRankingReclamos);
			}
			ConnectionManager.getInstance().closeCon();
		} catch (Exception e) {
			System.out.println();
		}
		return reclamos;
	}
	
	public List<ReporteCantRecepMes> obtenerReporteCantRecepMes(){
		return null;
	}
	
	public List<ReporteTiempoPromedio> obtenerReporteTiempoPromedio(){
		return null;
	}
}
