package uade.tp.vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class ReporteCantRecPorMes extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	private Font font = new Font("Courier", Font.BOLD,16);
	
	private JLabel jLabel1;

	private JButton exportar;
	private JButton cancelar;

	private JTable jTable;
	private JPanel jPanel;
	
	private JScrollPane jScrollPane;
	
	Object[][] data = {};
	
	String[] columnNames = {"Mes",
							"Cant. Reclamos"};
	
	private static ReporteCantRecPorMes instancia;
	
	public static ReporteCantRecPorMes getInstancia()
	{
		if (instancia == null)
			instancia = new ReporteCantRecPorMes();
		return instancia;
	}
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ReporteCantRecPorMes inst = new ReporteCantRecPorMes();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ReporteCantRecPorMes() {
		super();
		initGUI();
	}
	
	@SuppressWarnings({ "static-access" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Cantidad de Reclamos tratados por Mes");
			this.setPreferredSize(new java.awt.Dimension(700, 500));
			this.setDefaultLookAndFeelDecorated(true);
			this.setResizable(false);
			this.setMinimumSize(new java.awt.Dimension(700, 500));
			
			jPanel = new JPanel();
			
			{
				jLabel1 = new JLabel();
				jPanel.add(jLabel1);
				jLabel1.setText("Cantidad de Reclamos por Mes");
				jLabel1.setFont(font);
				jLabel1.setBounds(160, 21, 500, 22);
			}

			{
			    DefaultTableModel dtm= new DefaultTableModel(data, columnNames);
			    /*for(ReclamoView rec : SistemaReclamos.getInstance().getReclamosZona()) {
			    	Object[] newRow={rec.getNroReclamo(), rec.getZona(), rec.getFecha(), rec.getCliente().getNombre(), rec.getEstado()};
				    dtm.addRow(newRow);
			    }*/

			    
			    
				jTable = new JTable(dtm);
				jTable.setPreferredScrollableViewportSize(new Dimension(650, 100));
				jTable.setFillsViewportHeight(true);
				
				jScrollPane = new JScrollPane(jTable);
				jScrollPane.setBounds(50, 60, 600, 22);
				
				jPanel.add(jScrollPane, BorderLayout.CENTER);									
			}
					
			{
				exportar = new JButton();
				jPanel.add(exportar);
				exportar.setText("Exportar");
				exportar.setBounds(70, 360, 123, 22);
				exportar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{

					}
				});
			}
			
			{
				cancelar = new JButton();
				jPanel.add(cancelar);
				cancelar.setText("Cancelar");
				cancelar.setBounds(210, 360, 120, 22);
				cancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						limpiarPantalla();
						getInstancia().setVisible(false);
						dispose();
					}
				});
			}

			jPanel.setOpaque(true);
			this.setContentPane(jPanel);
			this.pack();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void limpiarPantalla()
	{

	}
}
