package uade.tp.vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import uade.tp.ai.reclamo.ReclamoView;
import uade.tp.sistema.SistemaReclamos;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalExclusionType;

public class AtencionReclamoDistribucionVista extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;
	
	private Font font = new Font("Courier", Font.BOLD,16);
	
	private JLabel jLabel1;

	private JButton atender;
	private JButton cancelar;

	private JTable jTable;
	private JPanel jPanel;
	
	private JScrollPane jScrollPane;
	
	Object[][] data = {};
	
	String[] columnNames = {"ID Reclamo",
							"Tipo",
            				"Fecha",
            				"Cliente",
            				"Estado"};
	DefaultTableModel dtm= new DefaultTableModel(data, columnNames);
	//Combos
	
	private static AtencionReclamoDistribucionVista instancia;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JButton btnNewButton_2;
	
	public static AtencionReclamoDistribucionVista getInstancia()
	{
		if (instancia == null)
			instancia = new AtencionReclamoDistribucionVista();
		return instancia;
	}

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AtencionReclamoDistribucionVista inst = new AtencionReclamoDistribucionVista();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AtencionReclamoDistribucionVista() {
		super();
		initGUI();
	}
	
	@SuppressWarnings({ "static-access" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Atencion de Reclamos - Reclamo de Distribucion");
			this.setPreferredSize(new Dimension(700, 600));
			this.setDefaultLookAndFeelDecorated(true);
			this.setResizable(false);
			this.setMinimumSize(new java.awt.Dimension(700, 500));
			
			jPanel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) jPanel.getLayout();
			flowLayout.setVgap(50);
			flowLayout.setHgap(50);
			
			{
				jLabel1 = new JLabel();
				jPanel.add(jLabel1);
				jLabel1.setText("Atencion de Reclamos Distribucion");
				jLabel1.setFont(font);
				jLabel1.setBounds(160, 21, 500, 22);
			}

			{
			    
			    for(ReclamoView rec : SistemaReclamos.getInstance().getReclamosDistribucion()) {
			    	Object[] newRow={rec.getNroReclamo(), rec.getTipo(), rec.getFecha(), rec.getCliente().getNombre(), rec.getEstado()};
				    dtm.addRow(newRow);
			    }

			    
			    
				jTable = new JTable(dtm);
				jTable.setPreferredScrollableViewportSize(new Dimension(650, 100));
				jTable.setFillsViewportHeight(true);
				
				/*for (int i = 0; i < 5; i++) {
				    if (i == 2) {
				    	jTable.getColumnModel().getColumn(i).setPreferredWidth(100);
				    } else {
				    	jTable.getColumnModel().getColumn(i).setPreferredWidth(50);
				    }
				}*/
				
				jScrollPane = new JScrollPane(jTable);
				jScrollPane.setBounds(50, 60, 600, 22);
				
				jPanel.add(jScrollPane, BorderLayout.CENTER);									
			}
			{
				btnNewButton_2 = new JButton("Ver Reclamo");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				jPanel.add(btnNewButton_2);
			}
			{
				textField = new JTextField();
				jPanel.add(textField);
				textField.setColumns(50);
			}
			{
				btnNewButton = new JButton("Solucionar Reclamo");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Vector reclamo = (Vector) dtm.getDataVector().get(jTable.getSelectedRow());
						SistemaReclamos.getInstance().solucionarReclamo(reclamo.get(0).toString(), textField.getText());
						reclamo.set(4, "Solucionado");		
						dtm.fireTableDataChanged();
					}
				});
				{
					btnNewButton_1 = new JButton("Tratar Reclamo");
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Vector reclamo = (Vector) dtm.getDataVector().get(jTable.getSelectedRow());
							SistemaReclamos.getInstance().tratarReclamo(reclamo.get(0).toString(), textField.getText());
							reclamo.set(4, "En tratamiento");		
							dtm.fireTableDataChanged();
						}
					});
					jPanel.add(btnNewButton_1);
				}
				jPanel.add(btnNewButton);
			}
					
			{
				atender = new JButton();
				atender.setHorizontalAlignment(SwingConstants.LEFT);
				jPanel.add(atender);
				atender.setText("Cerrar Reclamo");
				atender.setBounds(70, 360, 123, 22);
				atender.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						Vector reclamo = (Vector) dtm.getDataVector().get(jTable.getSelectedRow());
						SistemaReclamos.getInstance().cerrarReclamo(reclamo.get(0).toString(), textField.getText());
						reclamo.set(4, "Cerrado");		
						dtm.fireTableDataChanged();
					}
				});
			}

			jPanel.setOpaque(true);
			this.setContentPane(jPanel);
			
			{
				cancelar = new JButton();
				jPanel.add(cancelar);
				cancelar.setText("Cancelar");
				cancelar.setBounds(210, 360, 120, 22);
				cancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						limpiarPantalla();
						AtencionReclamoDistribucionVista.getInstancia().setVisible(false);
					}
				});
			}
			this.pack();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void limpiarPantalla()
	{

	}
	
}
