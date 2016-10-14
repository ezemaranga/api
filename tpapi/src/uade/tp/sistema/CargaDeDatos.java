package uade.tp.sistema;

import java.sql.SQLException;
import java.util.Date;

import uade.tp.ai.Cliente;
import uade.tp.ai.Factura;
import uade.tp.ai.Producto;
import uade.tp.ai.reclamo.Reclamo;
import uade.tp.ai.reclamo.ReclamoFacturacion;

public class CargaDeDatos {
	
	public static void main(String[] args) throws SQLException {
		
//		Producto hp = new Producto("Harry Potter", "ISBN10", "un libro", 100);
//		hp.guardar();
		
//		Producto tortuga = new Producto("Tortugas Ninja", "ART90", "Una tortuga", 90);
//		tortuga.guardar();
//		
//		Producto pelota = new Producto("Pelota", "ART80", "un producto", 60);
//		pelota.guardar();
//		
//		Cliente eze = new Cliente("ezequiel", "direccion", "telef", "email", "dni");
//		eze.guardar();
		
//		Cliente coco = new Cliente("coco", "dire de coco", "tel de coco", "email de coco", "dni de coco");
//		coco.guardar();
		
//		Cliente eze = Cliente.buscar("dni");
//		Producto pelota = Producto.buscar("ART80");
//		
//		ReclamoProducto reclamoProducto = new ReclamoProducto();
//		reclamoProducto.setCliente(eze);
//		reclamoProducto.setDescripcion("desc reclamo producto");
//		reclamoProducto.setEstadoActual("En proceso");
//		
//		reclamoProducto.addItemReclamo(pelota, 2);
//		
//		reclamoProducto.guardarReclamo();
		
//		Zona almagro = new Zona("A", "Almagro");
//		almagro.guardar();
		
//		Zona boedo = new Zona("B", "Boedo");
//		boedo.guardar();
//		
//		Zona caba = new Zona("C", "Caballito");
//		caba.guardar();
		
//		Zona almagro = Zona.buscar("A");
//		Cliente coco = Cliente.buscar("dni de coco");
//		
//		ReclamoZona reclamoZona = new ReclamoZona();
//		reclamoZona.setCliente(coco);
//		reclamoZona.setDescripcion("desc reclamo zona");
//		reclamoZona.setEstadoActual("Iniciado");
//		reclamoZona.setZona(almagro);
//		
//		reclamoZona.guardarReclamo();
		
//		List<Reclamo> reclamosZona = Reclamo.getReclamosZona();
//		System.out.println(reclamosZona.size());
		
//		Cliente eze = Cliente.buscar("dni");
//		Producto pelota = Producto.buscar("ART80");
//		
//		ReclamoFaltante reclamoFaltante = new ReclamoFaltante();
//		reclamoFaltante.setCliente(eze);
//		reclamoFaltante.setDescripcion("desc reclamo faltante");
//		reclamoFaltante.setEstadoActual("En proceso");
//		reclamoFaltante.addItemReclamo(pelota, 5);
//		
//		reclamoFaltante.guardarReclamo();
		
//		Cliente coco = Cliente.buscar("dni de coco");
//		Cliente eze = Cliente.buscar("dni");
//		Producto pelota = Producto.buscar("ART80");
//		
//		Factura facturaCoco = new Factura(new Date().toString(), "1111", coco);
//		facturaCoco.addItem(pelota, 20);
//		facturaCoco.guardar();
//		
//		Factura facturaEze = new Factura(new Date().toString(), "3333", eze);
//		facturaEze.addItem(pelota, 50);
//		facturaEze.guardar();
		
//		Factura facturaCoco = Factura.buscar("1111");
//		Factura facturaEze = Factura.buscar("3333");
//		
//		ReclamoFacturacion recFact = new ReclamoFacturacion();
//		recFact.setCliente(eze);
//		recFact.setDescripcion("desc reclamo facturacion");
//		recFact.setEstadoActual("En espera");
//		recFact.addFactura(facturaCoco);
//		recFact.addFactura(facturaEze);
//		recFact.guardarReclamo();
		
		Reclamo.getReclamosFacturacion();
		
	}

}
