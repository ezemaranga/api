package uade.tp.ai.tablero;

import java.util.ArrayList;
import java.util.List;

import uade.tp.ai.reclamo.Reclamo;
import uade.tp.ai.reclamo.ReclamoDistribucion;
import uade.tp.ai.reclamo.ReclamoZona;
import uade.tp.bbdd.ReclamoMapper;

public class TableroZona extends Tablero {

	private static TableroZona instancia;

	private List<ReclamoZona> reclamos = new ArrayList<ReclamoZona>();

	public static TableroZona getInstance() {
		if (instancia == null)
			instancia = new TableroZona();
		return instancia;
	}

	public void agregarReclamo(Reclamo r) {
		reclamos.add((ReclamoZona) r);
	}

	@Override
	public List<Reclamo> getReclamos() {
		return ReclamoMapper.getInstancia().getReclamosZona();
	}

}
