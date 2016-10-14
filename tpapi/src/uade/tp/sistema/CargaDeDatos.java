package uade.tp.sistema;

import java.sql.SQLException;
import java.util.Date;

import uade.tp.ai.Cliente;
import uade.tp.ai.Producto;
import uade.tp.ai.reclamo.ReclamoProducto;

public class CargaDeDatos {
	
	public static void main(String[] args) throws SQLException {
		
//		Producto hp = new Producto("Harry Potter", "ISBN10", "un libro", 100);
//		hp.guardar();
//		
//		Producto anill = new Producto("Lord of the rings", "ISBN20", "otro libro", 150);
//		anill.guardar();
//		
//		Producto tortuga = new Producto("Tortugas Ninja", "ART90", "Una tortuga", 90);
//		tortuga.guardar();
//		
//		Producto pelota = new Producto("Pelota", "ART80", "un producto", 60);
//		pelota.guardar();
//		
//		Cliente eze = new Cliente("ezequiel", "direccion", "telef", "email", "dni");
//		eze.guardar();
		
		Cliente eze = Cliente.buscar("dni");
		Producto pelota = Producto.buscar("ART80");
		
		ReclamoProducto reclamoProducto = new ReclamoProducto();
		reclamoProducto.setCliente(eze);
		reclamoProducto.setDescripcion("desc reclamo producto");
		reclamoProducto.setEstadoActual("En proceso");
		
		reclamoProducto.addItemReclamo(pelota, 2);
		
		reclamoProducto.guardarReclamo();
		
		
	}

}
