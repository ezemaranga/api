package uade.tp.ai.tablero;

import java.util.ArrayList;
import java.util.List;

import uade.tp.ai.reclamo.Reclamo;
import uade.tp.ai.reclamo.ReclamoDistribucion;
import uade.tp.ai.reclamo.ReclamoFacturacion;

public class TableroFacturacion extends Tablero {
	
	private static TableroFacturacion instancia;
	
	private List<ReclamoFacturacion> reclamos = new ArrayList<ReclamoFacturacion>();
	
	public static TableroFacturacion getInstance() {
		if (instancia == null)
			instancia = new TableroFacturacion();
		return instancia;
	}
	
	public void agregarReclamo(Reclamo r) {
		reclamos.add((ReclamoFacturacion) r);
	}

}
