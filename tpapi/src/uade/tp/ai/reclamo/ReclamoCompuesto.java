package uade.tp.ai.reclamo;

import java.util.List;

import uade.tp.ai.Factura;
import uade.tp.ai.Producto;
import uade.tp.ai.Zona;

public class ReclamoCompuesto extends Reclamo {
	
	private List<Reclamo> reclamos;
	private Reclamo recActual;
	
	public List<Reclamo> getReclamos() {
		return reclamos;
	}

	@Override
	public void agregarATablero() {
		for(Reclamo reclamo : reclamos) {
			reclamo.agregarATablero();
		}
	}

	@Override
	public void addFactura(Factura fact) {
		recActual.addFactura(fact);
	}

	@Override
	public void addItemReclamo(Producto prod, int cantidad) {
		recActual.addItemReclamo(prod, cantidad);
	}

	@Override
	public void setZona(Zona zona) {
		recActual.setZona(zona);
	}
	
	public void agregarReclamoCantidad() {
		recActual = new ReclamoCantidad();
		recActual.setCliente(this.getCliente());
	}

	public void guardarReclamoEnActual() {
		recActual.agregarATablero();
		reclamos.add(recActual);
		recActual = null;
	}

}
