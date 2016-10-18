package uade.tp.ai.reclamo;

import uade.tp.ai.Factura;
import uade.tp.ai.Producto;
import uade.tp.ai.Zona;
import uade.tp.ai.tablero.TableroZona;

public class ReclamoZona extends Reclamo{

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

	@Override
	public void addFactura(Factura fact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addItemReclamo(Producto prod, int cantidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTipo() {
		return "RECLAMO_ZONA";
	}
	
	@Override
	public ReclamoView getReclamoView() {
		ReclamoView rv = ReclamoView.createReclamoView(this);
		rv.setZona(this.getZona().getNombre());
		return rv;
	}

}
