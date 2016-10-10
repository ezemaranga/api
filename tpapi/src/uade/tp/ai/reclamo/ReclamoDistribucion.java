package uade.tp.ai.reclamo;

import java.util.List;

import uade.tp.ai.Cliente;
import uade.tp.ai.Producto;
import uade.tp.ai.tablero.TableroDistribucion;

public abstract class ReclamoDistribucion extends ReclamoSimple {
	
	public abstract void addItemReclamo(Producto prod, int cant);

	public void agregarATablero(ReclamoDistribucion r) {
		TableroDistribucion.getInstance().agregarReclamo(r);
	}
}
