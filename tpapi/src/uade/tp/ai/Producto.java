package uade.tp.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import uade.tp.bbdd.ProductoMapper;
import uade.tp.bbdd.ZonaMapper;

public class Producto {
	
	private String titulo;
	private String codPublicacion;
	private String descripcion;
	private float precio;

	public Producto(String titulo, String codPublicacion, String descripcion, float precio) {
		this.titulo = titulo;
		this.codPublicacion = codPublicacion;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getCodPublicacion() {
		return this.codPublicacion;
	}
	
	public void setCodPublicacion(String codPublicacion) {
		this.codPublicacion = codPublicacion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public float getPrecio() {
		return this.precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public ProductoView getView() {
		ProductoView pv = new ProductoView(titulo, codPublicacion, descripcion, precio);
		
		return pv;
	}
	
	public void guardar() {
		ProductoMapper.getInstancia().insert(this);
	}
	
	public void borrar() {
		ProductoMapper.getInstancia().delete(this);
	}
	
	public static Producto buscar(String codigoProducto) {
		return ProductoMapper.getInstancia().buscarProducto(codigoProducto);
	}

	public static Vector<Producto> getProductos() {
		Vector<Producto> listaProductos = new Vector<Producto>();
		Vector<Object> productos = ProductoMapper.getInstancia().select(null);
		for(Object p : productos) {
			listaProductos.add((Producto) p);
		}
		return listaProductos;
	}

}
