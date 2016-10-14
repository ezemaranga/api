package uade.tp.sistema;

import java.sql.SQLException;

import uade.tp.ai.Producto;

public class CargaDeDatos {
	
	public static void main(String[] args) throws SQLException {
		
		Producto hp = new Producto("Harry Potter", "ISBN10", "un libro", 100);
		hp.guardar();
		
		Producto anill = new Producto("Lord of the rings", "ISBN20", "otro libro", 150);
		anill.guardar();
		
		Producto tortuga = new Producto("Tortugas Ninja", "ART90", "Una tortuga", 90);
		tortuga.guardar();
		
		Producto pelota = new Producto("Pelota", "ART80", "un producto", 60);
		pelota.guardar();
		
	}

}
