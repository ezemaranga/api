package uade.tp.ai.reclamo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import uade.tp.ai.Cliente;
import uade.tp.ai.Factura;
import uade.tp.ai.Producto;
import uade.tp.ai.Zona;
import uade.tp.bbdd.ReclamoMapper;

public abstract class Reclamo {
	
	private String fecha;
	private String nroReclamo;
	private Cliente cliente;
	private String descripcion;
	private String estadoActual;
	private List<TratamientoReclamo> tratamientos = new ArrayList<TratamientoReclamo>();
	
	public ReclamoView getReclamoView() {
		ReclamoView rv = ReclamoView.createReclamoView(this);
		return rv;
	}
	
	public abstract void agregarATablero();

	public abstract void addFactura(Factura fact);

	public abstract void addItemReclamo(Producto prod, int cantidad);

	public abstract void setZona(Zona zona);
	
	public abstract String getTipo();
	
	public void guardarReclamo() {
		ReclamoMapper.getInstancia().insert(this);
	}

	public String getFecha() {
		if(fecha == null) {
			this.fecha = new Date().toString();
		}
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNroReclamo() {
		if(nroReclamo == null) {
			nroReclamo = crearNumeroReclamo(); 
		}
		return nroReclamo;
	}

	public void setNroReclamo(String nroReclamo) {
		this.nroReclamo = nroReclamo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(String estado) {
		this.estadoActual = estado;
	}
	
	public void agregarTratamiento(String desc, String estado) {
		this.tratamientos.add(new TratamientoReclamo(new Date().toString(), estado, desc));
	}
	
	public List<TratamientoReclamo> getTratamientos() {
		return this.tratamientos;
	}
	
	public static List<Reclamo> getReclamosDistribucion() {
		return ReclamoMapper.getInstancia().getReclamosDistribucion();
	}
	
	public static List<Reclamo> getReclamosZona() {
		return ReclamoMapper.getInstancia().getReclamosZona();
	}
	
	public static List<Reclamo> getReclamosFacturacion() {
		return ReclamoMapper.getInstancia().getReclamosFacturacion();
	}
	
	private final static char[] caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	private static String crearNumeroReclamo() {
	    char[] nro = new char[8];
	    Random r = new Random(System.currentTimeMillis());
	    for (int i = 0;  i < 8;  i++) {
	        nro[i] = caracteres[r.nextInt(caracteres.length)];

	    }
	    return new String(nro);
	}

}
