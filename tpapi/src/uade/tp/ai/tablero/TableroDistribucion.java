package uade.tp.ai.tablero;

import java.util.ArrayList;
import java.util.List;

import uade.tp.ai.reclamo.Reclamo;
import uade.tp.ai.reclamo.ReclamoDistribucion;
import uade.tp.bbdd.ReclamoMapper;

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

	@Override
	public List<Reclamo> getReclamos() {
		return ReclamoMapper.getInstancia().getReclamosDistribucion();
	}


}
