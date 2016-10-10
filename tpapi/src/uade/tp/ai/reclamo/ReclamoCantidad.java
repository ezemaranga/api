package uade.tp.ai.reclamo;

import java.util.ArrayList;
import java.util.List;

import uade.tp.ai.Producto;
import uade.tp.ai.tablero.TableroDistribucion;

public class ReclamoCantidad extends ReclamoDistribucion {
	
	private List<ItemReclamo> items = new ArrayList<ItemReclamo>();

	@Override
	public void addItemReclamo(Producto prod, int cant) {
		ItemReclamo item = new ItemReclamo(prod, cant);
		items.add(item);
	}

	@Override
	public void agregarATablero() {
		TableroDistribucion.getInstance().agregarReclamo(this);
	}
	
	
}
