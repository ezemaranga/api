package uade.tp.ai.reclamo;

import java.util.ArrayList;
import java.util.List;

import uade.tp.ai.Factura;
import uade.tp.ai.Producto;
import uade.tp.ai.Zona;
import uade.tp.ai.tablero.TableroDistribucion;
import uade.tp.ai.tablero.TableroFacturacion;

public abstract class ReclamoDistribucion extends Reclamo {
	
	protected List<ItemReclamo> items = new ArrayList<ItemReclamo>();

	public List<ItemReclamo> getItems() {
		return items;
	}

	@Override
	public void addItemReclamo(Producto prod, int cant) {
		ItemReclamo item = new ItemReclamo(prod, cant);
		items.add(item);
	}

	public void agregarATablero(ReclamoDistribucion r) {
		TableroDistribucion.getInstance().agregarReclamo(r);
	}
	
	@Override
	public void agregarATablero() {
		TableroFacturacion.getInstance().agregarReclamo(this);
	}
	
	public abstract List<ItemReclamo> getItemsReclamo();

	@Override
	public void addFactura(Factura fact){
		// TODO Auto-generated method stub
	}
	
	@Override
	public void setZona(Zona zona){
		// TODO Auto-generated method stub
	}
	
}
