package uade.tp.sistema;

import java.util.Date;
import java.util.List;

import uade.tp.ai.Cliente;
import uade.tp.ai.Factura;
import uade.tp.ai.Producto;
import uade.tp.ai.Usuario;
import uade.tp.ai.Zona;
import uade.tp.ai.reclamo.Reclamo;
import uade.tp.ai.reclamo.ReclamoView;

public class SistemaReclamos {
	
	private List<Cliente> clientes;
	private List<Usuario> usuarios;
	private List<Zona> zonas;
	private List<Producto> productos;
	private List<Factura> facturas;
	private List<Reclamo> reclamos;
	
	//FIXME En el diagrama de secuencia devuelve un boolean... en el de clases es void.
	public boolean ingresoAplicacion(String usuario, String password) {
		Usuario usuarioActual = this.buscarUsuario(usuario, password);
		return usuarioActual != null;
	}
	
	public Usuario buscarUsuario(String usuario, String password) {
		Usuario u = null;
		return u;
	}
	
	public List<ReclamoView> getReclamos() {
		List<ReclamoView> reclamos = null;
		return reclamos;
	}
	
	public void inicializarReclamoFacturacion() {
		
	}
	
	public void inicializarReclamoCantidad() {
		
	}

	public void inicializarReclamoProducto() {
	
	}
	
	public void inicializarReclamoZona() {
		
	}
	
	public Cliente existeCliente(String dni) {
		return null;
	}
	
	public void ingresarDatosFactura(Date fecha, String nro, String desc) {
		
	}
	
	public void ingresarDatosProducto(String codPublicacion, int cantidad, String desc) {
		
	}
	
	public void ingresarDatosZona(String codZona, String barrio, String desc) {
		
	}
	
	public Factura buscarFactura(Date fecha, String nro) {
		return null;
	}
	
	public void agregarReclamo() {
		
	}
	
	public void cerrarReclamo(String nroReclamo, String description) {
		
	}
	
	public void tratarReclamo(String nroReclamo, String descripcion) {
		
	}
	
	public void solucionarReclamo(String nroReclamo, String descripcion) {
		
	}
	
	public Reclamo buscarReclamo(String nro) {
		return null;
	}
	
	public void agregarReclamoCompuesto() {
		
	}
	
	public Cliente buscarCliente(String dni) {
		return null;
	}
	
}