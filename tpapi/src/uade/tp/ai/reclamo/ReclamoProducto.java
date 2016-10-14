package uade.tp.ai.reclamo;

import java.util.ArrayList;
import java.util.List;

import uade.tp.ai.Producto;
import uade.tp.ai.tablero.TableroDistribucion;

public class ReclamoProducto extends ReclamoDistribucion {


	@Override
	public void agregarATablero() {
		TableroDistribucion.getInstance().agregarReclamo(this);
	}

	@Override
	public List<ItemReclamo> getItemsReclamo() {
		return items;
	}
	
	@Override
	public String getTipo() {
		return "RECLAMO_PRODUCTO";
	}

}
