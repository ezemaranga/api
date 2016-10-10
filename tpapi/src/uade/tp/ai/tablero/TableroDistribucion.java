package uade.tp.ai.tablero;

import java.util.ArrayList;
import java.util.List;

import uade.tp.ai.reclamo.Reclamo;
import uade.tp.ai.reclamo.ReclamoDistribucion;

public class TableroDistribucion extends Tablero {
	
	private static TableroDistribucion instancia;
	
	private List<ReclamoDistribucion> reclamos = new ArrayList<ReclamoDistribucion>();
	
	public static TableroDistribucion getInstance() {
		if (instancia == null)
			instancia = new TableroDistribucion();
		return instancia;
	}

	public void agregarReclamo(Reclamo r) {
		reclamos.add((ReclamoDistribucion) r);
	}


}
