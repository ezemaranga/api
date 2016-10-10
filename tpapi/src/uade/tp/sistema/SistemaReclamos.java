package uade.tp.sistema;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uade.tp.ai.Cliente;
import uade.tp.ai.Factura;
import uade.tp.ai.Producto;
import uade.tp.ai.Usuario;
import uade.tp.ai.Zona;
import uade.tp.ai.reclamo.Reclamo;
import uade.tp.ai.reclamo.ReclamoView;
import uade.tp.bbdd.ClienteMapper;
import uade.tp.bbdd.FacturaMapper;
import uade.tp.bbdd.UsuarioMapper;

public class SistemaReclamos {
	
	private List<Cliente> clientes;
	private List<Usuario> usuarios;
	private List<Zona> zonas;
	private List<Producto> productos;
	private List<Factura> facturas;
	private List<Reclamo> reclamos;
	private Reclamo recActual;
	
	public SistemaReclamos() {
		clientes = new ArrayList<Cliente>();
		usuarios = new ArrayList<Usuario>();
		zonas = new ArrayList<Zona>();
		productos = new ArrayList<Producto>();
		facturas = new ArrayList<Factura>();
		reclamos = new ArrayList<Reclamo>();
	}

	public boolean ingresoAplicacion(String apodo, String password) {
		Usuario usuarioActual = this.buscarUsuario(apodo, password);
		return usuarioActual != null;
	}
	
	public Usuario buscarUsuario(String apodo, String password) {
		for(Usuario usuario : usuarios) {
			if(usuario.getApodo().equals(apodo) && usuario.getPassword().equals(password)) {
				return usuario;
			}
		}
		return UsuarioMapper.getInstancia().buscarUsuario(apodo, password);
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
	
	public void ingresarDatosFactura(Date fecha, String nro, String desc) {
		
	}
	
	public void ingresarDatosProducto(String codPublicacion, int cantidad, String desc) {
		
	}
	
	public void ingresarDatosZona(String codZona, String barrio, String desc) {
		
	}
	
	public Factura buscarFactura(Date fecha, String nro) {
		for(Factura factura : facturas) {
			if(factura.getNumero().equals(nro) && factura.getFecha().equals(fecha)) {
				return factura;
			}
		}
		return FacturaMapper.getInstancia().buscarFactura(nro, fecha);
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
		for(Reclamo reclamo : reclamos) {
			if(reclamo.getNroReclamo().equals(nro)) {
				return reclamo;
			}
		}
		return null;
	}
	
	public void agregarReclamoCompuesto() {
		
	}
	
	public Cliente buscarCliente(String dni) {
		for(Cliente cliente : clientes) {
			if(cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		return ClienteMapper.getInstancia().buscarCliente(dni);
	}
	
	
	// TODO remove this, just for testing
	public void agregarCliente(Cliente c) {
		this.clientes.add(c);
	}
	
}