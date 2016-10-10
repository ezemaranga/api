package uade.tp.ai.reclamo;

import java.util.List;

import uade.tp.ai.Factura;
import uade.tp.ai.tablero.TableroDistribucion;
import uade.tp.ai.tablero.TableroFacturacion;

public class ReclamoFacturacion extends ReclamoSimple {
	
	private List<Factura> facturas;
	
	public void addFactura(Factura f) {
		facturas.add(f);
	}
	
	@Override
	public void agregarATablero() {
		TableroFacturacion.getInstance().agregarReclamo(this);
	}

}
