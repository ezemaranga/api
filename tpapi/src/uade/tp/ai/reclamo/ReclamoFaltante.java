package uade.tp.ai.reclamo;

import java.util.List;

import uade.tp.ai.Producto;
import uade.tp.ai.tablero.TableroDistribucion;

public class ReclamoFaltante extends ReclamoDistribucion {
	
	private List<ItemReclamo> items;

	public void addItemReclamo(Producto prod, int cant) {
		ItemReclamo item = new ItemReclamo(prod, cant);
		items.add(item);
	}
	
	@Override
	public void agregarATablero() {
		TableroDistribucion.getInstance().agregarReclamo(this);
	}

	@Override
	public List<ItemReclamo> getItemsReclamo() {
		return this.items;
	}
	
	@Override
	public String getTipo() {
		return "RECLAMO_FALTANTE";
	}

}
