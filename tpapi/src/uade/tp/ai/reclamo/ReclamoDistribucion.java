package uade.tp.ai.reclamo;

import uade.tp.ai.Factura;
import uade.tp.ai.Producto;
import uade.tp.ai.Zona;
import uade.tp.ai.tablero.TableroDistribucion;
import uade.tp.ai.tablero.TableroFacturacion;

public abstract class ReclamoDistribucion extends Reclamo {
	
	public abstract void addItemReclamo(Producto prod, int cant);

	public void agregarATablero(ReclamoDistribucion r) {
		TableroDistribucion.getInstance().agregarReclamo(r);
	}
	
	@Override
	public void agregarATablero() {
		TableroFacturacion.getInstance().agregarReclamo(this);
	}

	@Override
	public void addFactura(Factura fact){
		// TODO Auto-generated method stub
	}
	
	@Override
	public void setZona(Zona zona){
		// TODO Auto-generated method stub
	}
}
