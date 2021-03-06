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
	
	private JMenuItem jMenuReporteRnkCliMayorRec;
	private JMenuItem jMenuReporteCantRecPorMes;
	private JMenuItem jMenuReporteRnkTratRec;
	private JMenuItem jMenuReporteTiempoPromRec;

	private UsuarioView usuarioView;
	
	
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
								AgregarReclamoCantidadVista.getInstancia().setLocationRelativeTo(null);
								AgregarReclamoCantidadVista.getInstancia().setVisible(true);
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
								AgregarReclamoProductoVista.getInstancia().setLocationRelativeTo(null);
								AgregarReclamoProductoVista.getInstancia().setVisible(true);
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
								AgregarReclamoFaltantesVista.getInstancia().setLocationRelativeTo(null);
								AgregarReclamoFaltantesVista.getInstancia().setVisible(true);
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
								AgregarReclamoZonaVista.getInstancia().setLocationRelativeTo(null);
								AgregarReclamoZonaVista.getInstancia().setVisible(true);
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
								AgregarReclamoFacturacionVista.getInstancia().setLocationRelativeTo(null);
								AgregarReclamoFacturacionVista.getInstancia().setVisible(true);
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
						/*{
							jMenuAtencionReclamoCantidad = new JMenuItem();
							jMenu2.add(jMenuAtencionReclamoCantidad);
							jMenuAtencionReclamoCantidad.setText("Atencion Reclamos por Cantidad");
							jMenuAtencionReclamoCantidad.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								AtencionReclamoCantidadVista.getInstancia().setLocationRelativeTo(null);
								AtencionReclamoCantidadVista.getInstancia().setVisible(true);
							}
						});
						}
						{
							jMenuAtencionReclamoFaltante = new JMenuItem();
							jMenu2.add(jMenuAtencionReclamoFaltante);
							jMenuAtencionReclamoFaltante.setText("Atencion Reclamos por Faltante");
							jMenuAtencionReclamoFaltante.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								AtencionReclamoFaltanteVista.getInstancia().setLocationRelativeTo(null);
								AtencionReclamoFaltanteVista.getInstancia().setVisible(true);
							}
						});
						}*/
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
					if(usuarioView.getRol().equals("CONSULTA")){
						jMenu2 = new JMenu();
						jMenuBar1.add(jMenu2);
						jMenu2.setText("Consulta de Reportes");
						{
							jMenuReporteRnkCliMayorRec = new JMenuItem();
							jMenu2.add(jMenuReporteRnkCliMayorRec);
							jMenuReporteRnkCliMayorRec.setText("Ranking Clientes con mayor cantidad de Reclamos");
							jMenuReporteRnkCliMayorRec.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								ReporteRnkCliMayorRec.getInstancia().setLocationRelativeTo(null);
								ReporteRnkCliMayorRec.getInstancia().setVisible(true);
							}
						});
						}
						{
							jMenuReporteCantRecPorMes = new JMenuItem();
							jMenu2.add(jMenuReporteCantRecPorMes);
							jMenuReporteCantRecPorMes.setText("Cantidad de Reclamos tratados por Mes");
							jMenuReporteCantRecPorMes.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								ReporteCantRecPorMes.getInstancia().setLocationRelativeTo(null);
								ReporteCantRecPorMes.getInstancia().setVisible(true);
							}
						});
						}
						{
							jMenuReporteRnkTratRec = new JMenuItem();
							jMenu2.add(jMenuReporteRnkTratRec);
							jMenuReporteRnkTratRec.setText("Ranking de Tratamientos de Reclamos");
							jMenuReporteRnkTratRec.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								ReporteRnkTratRec.getInstancia().setLocationRelativeTo(null);
								ReporteRnkTratRec.getInstancia().setVisible(true);
							}
						});
						}
						{
							jMenuReporteTiempoPromRec = new JMenuItem();
							jMenu2.add(jMenuReporteTiempoPromRec);
							jMenuReporteTiempoPromRec.setText("Tiempo promedio de respuesta de Reclamos por Responsable");
							jMenuReporteTiempoPromRec.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								ReporteTiempoPromRec.getInstancia().setLocationRelativeTo(null);
								ReporteTiempoPromRec.getInstancia().setVisible(true);
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
