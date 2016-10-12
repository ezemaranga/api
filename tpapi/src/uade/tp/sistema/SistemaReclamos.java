package uade.tp.sistema;

import java.util.ArrayList;
import java.util.List;

import uade.tp.ai.Cliente;
import uade.tp.ai.Factura;
import uade.tp.ai.Producto;
import uade.tp.ai.Usuario;
import uade.tp.ai.Zona;
import uade.tp.ai.reclamo.Reclamo;
import uade.tp.ai.reclamo.ReclamoCantidad;
import uade.tp.ai.reclamo.ReclamoCompuesto;
import uade.tp.ai.reclamo.ReclamoDistribucion;
import uade.tp.ai.reclamo.ReclamoFacturacion;
import uade.tp.ai.reclamo.ReclamoFaltante;
import uade.tp.ai.reclamo.ReclamoProducto;
import uade.tp.ai.reclamo.ReclamoView;
import uade.tp.ai.reclamo.ReclamoZona;
import uade.tp.ai.tablero.TableroDistribucion;
import uade.tp.ai.tablero.TableroFacturacion;
import uade.tp.ai.tablero.TableroZona;
import uade.tp.bbdd.ClienteMapper;
import uade.tp.bbdd.FacturaMapper;
import uade.tp.bbdd.ProductoMapper;
import uade.tp.bbdd.ReclamoMapper;
import uade.tp.bbdd.UsuarioMapper;
import uade.tp.bbdd.ZonaMapper;

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


	// =================================== obtener vistas de reclamos ===================================
	public List<ReclamoView> getReclamosDistribucion() {
		List<Reclamo> reclamos = TableroDistribucion.getInstance().getReclamos();
		List<ReclamoView> reclamosView = new ArrayList<ReclamoView>();
		for(Reclamo r : reclamos) {
			reclamosView.add(((ReclamoDistribucion) r).getReclamoView());
		}
		return reclamosView;
	}
	
	public List<ReclamoView> getReclamosFacturacion() {
		List<Reclamo> reclamos = TableroFacturacion.getInstance().getReclamos();
		List<ReclamoView> reclamosView = new ArrayList<ReclamoView>();
		for(Reclamo r : reclamos) {
			reclamosView.add(((ReclamoFacturacion) r).getReclamoView());
		}
		return reclamosView;
	}
	
	public List<ReclamoView> getReclamosZona() {
		List<Reclamo> reclamos = TableroZona.getInstance().getReclamos();
		List<ReclamoView> reclamosView = new ArrayList<ReclamoView>();
		for(Reclamo r : reclamos) {
			reclamosView.add(((ReclamoZona) r).getReclamoView());
		}
		return reclamosView;
	}
	
	// =========== inicializar reclamos simples ==========
	public void inicializarReclamoFacturacion() {
		recActual = new ReclamoFacturacion();
	}

	public void inicializarReclamoFaltante() {
		recActual = new ReclamoFaltante();
	}

	public void inicializarReclamoCantidad() {
		recActual = new ReclamoCantidad();
	}
	
	public void inicializarReclamoProducto() {
		recActual = new ReclamoProducto();
	}

	public void inicializarReclamoZona() {
		recActual = new ReclamoZona();
	}
	
	// inicializar reclamo compuesto
	public void inicializarReclamoCompuesto() {
		recActual = new ReclamoCompuesto();
	}
	
	// ============== agregar reclamos a reclamo compuesto ============
	public void agregarRelcamoCantidadAActual() {
		((ReclamoCompuesto) recActual).agregarReclamoCantidad();
	}
	
	public void agregarRelcamoProductoAActual() {
		((ReclamoCompuesto) recActual).agregarReclamoProducto();;
	}
	
	public void agregarRelcamoFaltanteAActual() {
		((ReclamoCompuesto) recActual).agregarReclamoFaltante();;
	}
	
	public void agregarRelcamoFacturacionAActual() {
		((ReclamoCompuesto) recActual).agregarReclamoFacturacion();;
	}
	
	public void agregarRelcamoZonaAActual() {
		((ReclamoCompuesto) recActual).agregarReclamoZona();;
	}

	// guardar reclamo compuesto
	public void guardarReclamoEnCompuesto() {
		((ReclamoCompuesto) recActual).guardarReclamoActual();
	}
	
	// guardar reclamo simple
	public void agregarReclamo() {
		recActual.agregarATablero();
		reclamos.add(recActual);
		recActual = null;
	}

	// ============= tratamiento de reclamos =================
	public void cerrarReclamo(String nroReclamo, String desc) {
		Reclamo r = this.buscarReclamo(nroReclamo);
		if (r != null) {
			String estado = "Cerrado";
			r.setEstadoActual(estado);
			r.agregarTratamiento(desc, estado);
		}

	}

	public void tratarReclamo(String nroReclamo, String desc) {
		Reclamo r = this.buscarReclamo(nroReclamo);
		if (r != null) {
			String estado = "En tratamiento";
			r.setEstadoActual(estado);
			r.agregarTratamiento(desc, estado);
		}
	}

	public void solucionarReclamo(String nroReclamo, String desc) {
		Reclamo r = this.buscarReclamo(nroReclamo);
		if (r != null) {
			String estado = "Solucionado";
			r.setEstadoActual(estado);
			r.agregarTratamiento(desc, estado);
		}
	}

	// ========= ingresar datos de reclamos ===================
	public void ingresarDatosFactura(String fecha, String nro, String desc) {
		Factura fact = buscarFactura(fecha, nro);
		if (fact != null) {
			recActual.setDescripcion(desc);
			recActual.addFactura(fact);
		}
	}

	public void ingresarDatosProducto(String codPublicacion, int cantidad, String desc) {
		Producto prod = buscarProducto(codPublicacion);
		if (prod != null) {
			recActual.setDescripcion(desc);
			recActual.addItemReclamo(prod, cantidad);
		}
	}

	public void ingresarDatosZona(String codZona, String barrio, String desc) {
		Zona zona = buscarZona(codZona);
		if (zona != null) {
			recActual.setDescripcion(desc);
			recActual.setZona(zona);
		}
	}

	
	// =================================== buscar ===================================
	public Factura buscarFactura(String fecha, String nro) {
		for (Factura factura : facturas) {
			if (factura.getNumero().equals(nro) && factura.getFecha().equals(fecha)) {
				return factura;
			}
		}
		return FacturaMapper.getInstancia().buscarFactura(nro, fecha);
	}

	public Reclamo buscarReclamo(String nro) {
		for (Reclamo reclamo : reclamos) {
			if (reclamo.getNroReclamo().equals(nro)) {
				return reclamo;
			}
		}
		return ReclamoMapper.getInstancia().buscarReclamo(nro);
	}

	public Usuario buscarUsuario(String apodo, String password) {
		for (Usuario usuario : usuarios) {
			if (usuario.getApodo().equals(apodo) && usuario.getPassword().equals(password)) {
				return usuario;
			}
		}
		return UsuarioMapper.getInstancia().buscarUsuario(apodo, password);
	}

	public Producto buscarProducto(String codPublicacion) {
		for (Producto producto : productos) {
			if (producto.getCodPublicacion().equals(codPublicacion)) {
				return producto;
			}
		}
		return ProductoMapper.getInstancia().buscarProducto(codPublicacion);
	}
	
	public Zona buscarZona(String codZona) {
		for (Zona zona : zonas) {
			if (zona.getCodigo().equals(codZona)) {
				return zona;
			}
		}
		return ZonaMapper.getInstancia().buscarZona(codZona);
	}

	public Cliente buscarCliente(String dni) {
		for (Cliente cliente : clientes) {
			if (cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		return ClienteMapper.getInstancia().buscarCliente(dni);
	}

	public boolean existeCliente(String dni) {
		Cliente c = this.buscarCliente(dni);
		if (c != null)
			recActual.setCliente(c);
		return c != null;
	}

	// ==========================   TODO remove this, just for testing ================
	public void agregarCliente(Cliente c) {
		this.clientes.add(c);
	}

}