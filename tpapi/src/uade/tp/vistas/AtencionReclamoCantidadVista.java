package uade.tp.vistas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import uade.tp.ai.ClienteView;
import uade.tp.ai.ZonaView;
import uade.tp.sistema.SistemaReclamos;

public class AtencionReclamoCantidadVista extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;
	
	private Font font = new Font("Courier", Font.BOLD,16);
	
	private JLabel jLabel1;
	
	private JButton atender;
	private JButton cancelar;

	private JTable jTable;
	
	private JScrollPane jScrollPane;
	
	Object[][] data = {
		    {"Kathy", "Smith", "Snowboarding", new Integer(5), "Zona 1", new Boolean(false)},
		    {"John", "Doe", "Rowing", new Integer(3), "Zona 2", new Boolean(true)},
		    {"Sue", "Black", "Knitting", new Integer(2), "Zona 3", new Boolean(false)},
		    {"Jane", "White", "Speed reading", new Integer(20), "Zona 4", new Boolean(true)},
		    {"Joe", "Brown", "Pool", new Integer(10), "Zona 5", new Boolean(false)}
		};
	
	String[] columnNames = {"ID Reclamo",
            				"Fecha",
            				"Cliente",
            				"Estado",
            				"Zona",
            				"Atender"};
	
	//Combos
	
	private static AtencionReclamoCantidadVista instancia;
	
	public static AtencionReclamoCantidadVista getInstancia()
	{
		if (instancia == null)
			instancia = new AtencionReclamoCantidadVista();
		return instancia;
	}

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AtencionReclamoCantidadVista inst = new AtencionReclamoCantidadVista();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AtencionReclamoCantidadVista() {
		super();
		initGUI();
	}
	
	@SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Atenci�n de Reclamos - Reclamo de Cantidad");
			this.setPreferredSize(new java.awt.Dimension(700, 500));
			this.setDefaultLookAndFeelDecorated(true);
			this.setResizable(false);
			this.setMinimumSize(new java.awt.Dimension(700, 500));
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Atenci�n de Reclamo Cantidad");
				jLabel1.setFont(font);
				jLabel1.setBounds(160, 21, 500, 22);
			}

			{
			    DefaultTableModel dtm= new DefaultTableModel(data, columnNames);
			      Object[] newRow={"Pepe", "Grillo","Tenis", new Integer(5), new Boolean(false)};
			      dtm.addRow(newRow);
			    
				jTable = new JTable(dtm);
				
				TableColumn column = null;
				for (int i = 0; i < 5; i++) {
				    column = jTable.getColumnModel().getColumn(i);
				    if (i == 2) {
				        column.setPreferredWidth(100);
				    } else {
				        column.setPreferredWidth(50);
				    }
				}
				
				jScrollPane = new JScrollPane(jTable);
				jTable.setFillsViewportHeight(true);
				getContentPane().add(jScrollPane, BorderLayout.CENTER);
				jScrollPane.setBounds(50, 60, 600, 22);
				

			}
			
			
			{
				atender = new JButton();
				getContentPane().add(atender);
				atender.setText("Guardar");
				atender.setBounds(70, 360, 123, 22);
				atender.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						
					}
				});
			}
			{
				
				cancelar = new JButton();
				getContentPane().add(cancelar);
				cancelar.setText("Cancelar");
				cancelar.setBounds(210, 360, 120, 22);
				cancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						limpiarPantalla();
						AtencionReclamoCantidadVista.getInstancia().setVisible(false);
					}
				});
			}

			pack();
			this.setSize(700, 500);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void limpiarPantalla()
	{

	}
	
}