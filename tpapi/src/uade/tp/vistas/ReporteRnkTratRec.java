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

import uade.tp.ai.reportes.ReporteRankingReclamosView;
import uade.tp.sistema.SistemaReclamos;

public class ReporteRnkTratRec extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	private Font font = new Font("Courier", Font.BOLD,16);
	
	private JLabel jLabel1;

	private JButton exportar;
	private JButton cancelar;

	private JTable jTable;
	private JPanel jPanel;
	
	private JScrollPane jScrollPane;
	
	Object[][] data = {};
	
	String[] columnNames = {"Ranking",
			                "Tipo Reclamo",
							"Cant. Reclamos"};
	
	private static ReporteRnkTratRec instancia;
	
	public static ReporteRnkTratRec getInstancia()
	{
		if (instancia == null)
			instancia = new ReporteRnkTratRec();
		return instancia;
	}
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ReporteRnkTratRec inst = new ReporteRnkTratRec();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ReporteRnkTratRec() {
		super();
		initGUI();
	}
	
	@SuppressWarnings({ "static-access" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Ranking de Tratamientos de Reclamos");
			this.setPreferredSize(new java.awt.Dimension(700, 500));
			this.setDefaultLookAndFeelDecorated(true);
			this.setResizable(false);
			this.setMinimumSize(new java.awt.Dimension(700, 500));
			
			jPanel = new JPanel();
			
			{
				jLabel1 = new JLabel();
				jPanel.add(jLabel1);
				jLabel1.setText("Ranking de Reclamos");
				jLabel1.setFont(font);
				jLabel1.setBounds(160, 21, 500, 22);
			}

			{
			    DefaultTableModel dtm= new DefaultTableModel(data, columnNames);
			    int i = 0;
			    for(ReporteRankingReclamosView rec : SistemaReclamos.getInstance().obtenerReporteRankingReclamos()) {
			    	i ++;
			    	Object[] newRow={i , rec.getTipoReclamo(), rec.getCantReclamos()};
				    dtm.addRow(newRow);
			    }

			    
			    
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
