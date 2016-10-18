package uade.tp.vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import uade.tp.ai.UsuarioView;
import uade.tp.sistema.SistemaReclamos;

@SuppressWarnings("serial")
public class Menu extends javax.swing.JFrame {
	
	private JMenuBar jMenuBar1;
	
	private JMenu jMenu1;
	private JMenu jMenu2;

	private JMenuItem jMenuItem4;
	
	private JMenuItem jMenuReclamoCantidad;
	private JMenuItem jMenuReclamoProducto;
	private JMenuItem jMenuReclamoFaltante;
	private JMenuItem jMenuReclamoZona;
	private JMenuItem jMenuReclamoFacturacion;
	
	private JMenuItem jMenuAtencionReclamoCantidad;
	private JMenuItem jMenuAtencionReclamoProducto;
	private JMenuItem jMenuAtencionReclamoFaltante;
	private JMenuItem jMenuAtencionReclamoZona;
	private JMenuItem jMenuAtencionReclamoFacturacion;

	private UsuarioView usuarioView;
	
//	usuarioView = new UsuarioView("Call Center", "Apellido A", "Apodo A", "PASS A", "CALL_CENTER");
//	usuarioView = new UsuarioView("Responsable Zona Entrega", "Apellido B", "Apodo B", "PASS B", "RESP_ZONA_ENTREGA");
//	usuarioView = new UsuarioView("Responsable Facturacion", "Apellido C", "Apodo C", "PASS C", "RESP_FACTURACION");
//	usuarioView = new UsuarioView("Responsable Distribucion", "Apellido D", "Apodo D", "PASS D", "RESP_DISTRIBUCION");
	
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				Menu inst = new Menu();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				
			}
		});
	}
	
	public Menu() {
		super();
		initGUI();
	}
	
	private static Menu instancia;
	
	public static Menu getInstancia()
	{
		if (instancia == null) {
			instancia = new Menu();
		}
		return instancia;
	}
	
	
	@SuppressWarnings("static-access")
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(800, 600));
			this.setTitle("Sistema de Administracion de Reclamos");
			this.setDefaultLookAndFeelDecorated(true);
			this.setMinimumSize(new java.awt.Dimension(800, 600));
			this.setResizable(false);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					usuarioView = Login.getUsuario();
					
					if(usuarioView.getRol().equals("CALL_CENTER")){
						jMenu2 = new JMenu();
						jMenuBar1.add(jMenu2);
						jMenu2.setText("Ingreso de Reclamos");
						{
							jMenuReclamoCantidad = new JMenuItem();
							jMenu2.add(jMenuReclamoCantidad);
							jMenuReclamoCantidad.setText("Reclamo de Cantidad");
							jMenuReclamoCantidad.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								SistemaReclamos.getInstance().inicializarReclamoCantidad();
								ReclamoCantidadVista.getInstancia().setLocationRelativeTo(null);
								ReclamoCantidadVista.getInstancia().setVisible(true);
							}
						});
						}
						{
							jMenuReclamoProducto = new JMenuItem();
							jMenu2.add(jMenuReclamoProducto);
							jMenuReclamoProducto.setText("Reclamo de Productos");
							jMenuReclamoProducto.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								SistemaReclamos.getInstance().inicializarReclamoProducto();
								ReclamoProductoVista.getInstancia().setLocationRelativeTo(null);
								ReclamoProductoVista.getInstancia().setVisible(true);
							}
						});
						}
						{
							jMenuReclamoFaltante = new JMenuItem();
							jMenu2.add(jMenuReclamoFaltante);
							jMenuReclamoFaltante.setText("Reclamo de Faltantes");
							jMenuReclamoFaltante.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								SistemaReclamos.getInstance().inicializarReclamoFaltante();
								ReclamoFaltantesVista.getInstancia().setLocationRelativeTo(null);
								ReclamoFaltantesVista.getInstancia().setVisible(true);
							}
						});
						}
						{
							jMenuReclamoZona = new JMenuItem();
							jMenu2.add(jMenuReclamoZona);
							jMenuReclamoZona.setText("Reclamo de Zona");
							jMenuReclamoZona.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								SistemaReclamos.getInstance().inicializarReclamoZona();
								ReclamoZonaVista.getInstancia().setLocationRelativeTo(null);
								ReclamoZonaVista.getInstancia().setVisible(true);
							}
						});
						}
						{
							jMenuReclamoFacturacion = new JMenuItem();
							jMenu2.add(jMenuReclamoFacturacion);
							jMenuReclamoFacturacion.setText("Reclamo de Facturacion");
							jMenuReclamoFacturacion.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								SistemaReclamos.getInstance().inicializarReclamoFacturacion();
								ReclamoFacturacionVista.getInstancia().setLocationRelativeTo(null);
								ReclamoFacturacionVista.getInstancia().setVisible(true);
							}
						});
						}
					}
					if(usuarioView.getRol().equals("RESP_ZONA_ENTREGA")){
						jMenu2 = new JMenu();
						jMenuBar1.add(jMenu2);
						jMenu2.setText("Atencion de Reclamos");
						{
							jMenuAtencionReclamoZona = new JMenuItem();
							jMenu2.add(jMenuAtencionReclamoZona);
							jMenuAtencionReclamoZona.setText("Atencion Reclamos de Zona");
							jMenuAtencionReclamoZona.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								AtencionReclamoZonaVista.getInstancia().setLocationRelativeTo(null);
								AtencionReclamoZonaVista.getInstancia().setVisible(true);
							}
						});
						}
					}
					if(usuarioView.getRol().equals("RESP_DISTRIBUCION")){
						jMenu2 = new JMenu();
						jMenuBar1.add(jMenu2);
						jMenu2.setText("Atencion de Reclamos");
						{
							jMenuAtencionReclamoProducto = new JMenuItem();
							jMenu2.add(jMenuAtencionReclamoProducto);
							jMenuAtencionReclamoProducto.setText("Atencion Reclamos de Distribucion");
							jMenuAtencionReclamoProducto.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								AtencionReclamoDistribucionVista.getInstancia().setLocationRelativeTo(null);
								AtencionReclamoDistribucionVista.getInstancia().setVisible(true);
							}
						});
						}
					}
					if(usuarioView.getRol().equals("RESP_FACTURACION")){
						jMenu2 = new JMenu();
						jMenuBar1.add(jMenu2);
						jMenu2.setText("Atencion de Reclamos");
						{
							jMenuAtencionReclamoFacturacion = new JMenuItem();
							jMenu2.add(jMenuAtencionReclamoFacturacion);
							jMenuAtencionReclamoFacturacion.setText("Atencion Reclamos de Facturacion");
							jMenuAtencionReclamoFacturacion.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								AtencionReclamoFacturacionVista.getInstancia().setLocationRelativeTo(null);
								AtencionReclamoFacturacionVista.getInstancia().setVisible(true);
							}
						});
						}
					}
				}

				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("Salir del Sistema");
					{
						jMenuItem4 = new JMenuItem();
						jMenu1.add(jMenuItem4);
						jMenuItem4.setText("Salir");
						jMenuItem4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								System.exit(0);
							}
						});
					}
				}
			}
			pack();
			this.setSize(800, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
