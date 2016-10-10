package uade.tp.ai.tablero;

import java.util.List;

import uade.tp.ai.reclamo.Reclamo;

public abstract class Tablero {
		
	public abstract void agregarReclamo(Reclamo r);
	
	public abstract List<Reclamo> getReclamos();

}
