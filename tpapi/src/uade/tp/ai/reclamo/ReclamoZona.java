package uade.tp.ai.reclamo;

import uade.tp.ai.Zona;
import uade.tp.ai.tablero.TableroZona;

public class ReclamoZona extends ReclamoSimple {

	private Zona zona;
	
	@Override
	public void agregarATablero() {
		TableroZona.getInstance().agregarReclamo(this);
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
	

}
