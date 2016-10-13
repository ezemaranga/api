package uade.tp.vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import uade.tp.ai.ClienteView;
import uade.tp.ai.ZonaView;
import uade.tp.sistema.SistemaReclamos;

public class AtencionReclamoZonaVista extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;
	
	private Font font = new Font("Courier", Font.BOLD,16);
	
	private JLabel title;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;

	private JTextField fechaReclamoText;
	private JTextField numeroReclamoText;
	private JTextField dniText;
	private JTextField productoText;
	private JTextField domicilio;
	
	private JButton atender;
	private JButton cancelar;

	private JTable jTable;
	
	private JTextArea jTextArea;
	private JScrollPane jScrollPane;
	
	private JComboBox clientesCombo;
	private JComboBox zonasCombo;
	
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
	Vector<ClienteView> clientesView;
	Vector<ZonaView> zonasView;
	
	private static AtencionReclamoZonaVista instancia;
	
	public static AtencionReclamoZonaVista getInstancia()
	{
		if (instancia == null)
			instancia = new AtencionReclamoZonaVista();
		return instancia;
	}

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AtencionReclamoZonaVista inst = new AtencionReclamoZonaVista();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AtencionReclamoZonaVista() {
		super();
		initGUI();
	}
	
	@SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Atención de Reclamos - Reclamo de Zona");
			this.setPreferredSize(new java.awt.Dimension(700, 500));
			this.setDefaultLookAndFeelDecorated(true);
			this.setResizable(false);
			this.setMinimumSize(new java.awt.Dimension(700, 500));
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Atención de Reclamo Zona");
				jLabel1.setFont(font);
				jLabel1.setBounds(160, 21, 500, 22);
			}

			{
			    DefaultTableModel dtm= new DefaultTableModel(data, columnNames);
			      Object[] newRow={"Pepe", "Grillo","Tenis", new Integer(5), "Zona 6", new Boolean(false)};
			      dtm.addRow(newRow);
			    
				jTable = new JTable(dtm);
				
				TableColumn column = null;
				for (int i = 0; i < 6; i++) {
				    column = jTable.getColumnModel().getColumn(i);
				    if (i == 2) {
				        column.setPreferredWidth(50);
				    } else {
				        column.setPreferredWidth(50);
				    }
				}
				
				jTable.setPreferredScrollableViewportSize(new Dimension(300, 200));
			      
				jScrollPane = new JScrollPane(jTable);
				jTable.setFillsViewportHeight(true);
				getContentPane().add(jScrollPane, BorderLayout.CENTER);
				jScrollPane.setBounds(50, 60, 600, 22);
				

			}
			
			
			{
				atender = new JButton();
				getContentPane().add(atender);
				atender.setText("Atender");
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
						ReclamoCantidadVista.getInstancia().setVisible(false);
					}
				});
			}

			pack();
			this.setSize(700, 500);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public JTextField getDomicilio() {
		return domicilio;
	}
	public void limpiarPantalla()
	{
		fechaReclamoText.setText("");
		numeroReclamoText.setText("");
		dniText.setText("");
		jTextArea.setText("");
		productoText.setText("");
	}
	
}
