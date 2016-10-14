package uade.tp.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import uade.tp.bbdd.ZonaMapper;

public class Zona {
	
	private String codigo;
	private String nombre;
	
	public Zona(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ZonaView getView() {
		ZonaView zv = new ZonaView(codigo, nombre);
		
		return zv;
	}
	
	public void guardar() {
		ZonaMapper.getInstancia().insert(this);
	}
	
	public void borrar() {
		ZonaMapper.getInstancia().delete(this);
	}
	
	public static Zona buscar(String codZona) {
		return ZonaMapper.getInstancia().buscarZona(codZona);
	}
	
	public static List<Zona> getZonas() {
		List<Zona> listaZonas = new ArrayList<Zona>();
		Vector<Object> zonas = ZonaMapper.getInstancia().select(null);
		for(Object z : zonas) {
			listaZonas.add((Zona) z);
		}
		return listaZonas;
	}

}
