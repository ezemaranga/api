package uade.tp.sistema;

import uade.tp.ai.Cliente;

public class Main {

	public static void main(String[] args) {
		SistemaReclamos sistema = new SistemaReclamos();
		
		Cliente c1 = new Cliente("pepe", "calle falsa 123", "123456", "pepe@gmail.com", "1");
		Cliente c2 = new Cliente("cacho", "calle trucha 456", "435345", "cacho@gmail.com", "2");
		Cliente c3 = new Cliente("tito", "calle inexistente 789", "45677", "tito@gmail.com", "3");
		Cliente c4 = new Cliente("willy", "calle perdida 123", "44435", "willy@gmail.com", "4");
		Cliente c5 = new Cliente("yayo", "calle 456", "6666", "yayo@gmail.com", "5");
		
		sistema.agregarCliente(c1);
		sistema.agregarCliente(c2);
		sistema.agregarCliente(c3);
		sistema.agregarCliente(c4);
		sistema.agregarCliente(c5);
		
		Cliente c = sistema.buscarCliente("2");
		System.out.println(c);

	}

}
