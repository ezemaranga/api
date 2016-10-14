package uade.tp.ai.reclamo;

import java.util.List;

import uade.tp.ai.Factura;
import uade.tp.ai.Producto;
import uade.tp.ai.Zona;
import uade.tp.ai.tablero.TableroFacturacion;

public class ReclamoFacturacion extends Reclamo {
	
	private List<Factura> facturas;
	
	public void addFactura(Factura f) {
		facturas.add(f);
	}
	
	public List<Factura> getFacturas() {
		return this.facturas;
	}

	@Override
	public void agregarATablero() {
		TableroFacturacion.getInstance().agregarReclamo(this);
	}

	@Override
	public void addItemReclamo(Producto prod, int cantidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setZona(Zona zona) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTipo() {
		return "RECLAMO_FACTURACION";
	}
	
}
