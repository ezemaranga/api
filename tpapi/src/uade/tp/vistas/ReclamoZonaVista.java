package uade.tp.vistas;

import java.awt.Dimension;
import java.awt.Font; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import uade.tp.ai.ClienteView;
import uade.tp.ai.Factura;
import uade.tp.ai.ProductoView;
import uade.tp.ai.reclamo.ItemReclamo;
import uade.tp.ai.reclamo.ReclamoCantidad;
import uade.tp.ai.reclamo.ReclamoDistribucion;
import uade.tp.ai.reclamo.ReclamoView;
import uade.tp.ai.reclamo.TratamientoReclamo;
import uade.tp.sistema.SistemaReclamos;
import java.awt.Component;
import javax.swing.table.TableModel;

//import Controlador.Sistema;
//import Negocio.DistribuidoraView;
//import Negocio.TipoDocView;
//import Vista.AltaAfiliado;

public class ReclamoZonaVista extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;

	private Font font = new Font("Courier", Font.BOLD, 16);

	private JLabel title;
	private JLabel jLabel1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JTextField dniText;
	private JTextField productoText;
	private JTextField domicilio;
	private JButton cancelar;

	private JTextArea descripcion;

	// Combos

	Vector<ClienteView> clientesView;
	Vector<ProductoView> productosView;

	private static ReclamoZonaVista instancia;
	private JTextField textField;

	DefaultTableModel dtm;
	Object[][] data = {};
	String[] columnNames = { "Nro Factura", "Cliente", "Fecha" };

	DefaultTableModel tratamientosDtm;
	Object[][] tratamientosData = {};
	String[] tratamientosColumnNames = { "Fecha", "Estado", "Descripcion" };

	private static ReclamoView reclamoView;
	
	private JPanel jPanel;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	private JLabel lblTratamientos;

	private String reclamoID;
	private JTextField textField_2;
	private JLabel lblZona;
	private JTextField textField_3;

	public static ReclamoZonaVista getInstancia(String nroReclamo) {
		if (nroReclamo != null) {
			instancia = new ReclamoZonaVista(nroReclamo);
		} else if (nroReclamo == null) {
			instancia = new ReclamoZonaVista();
		}
		return instancia;
	}

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ReclamoZonaVista inst = new ReclamoZonaVista();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ReclamoZonaVista() {
		super();
		reclamoView = new ReclamoView();
		initGUI();
	}

	public ReclamoZonaVista(String nroReclamo) {
		super();
		reclamoView = SistemaReclamos.getInstance().getReclamoView(nroReclamo);
		initGUI();
	}

	@SuppressWarnings({ "static-access", "unchecked", "rawtypes" })
	private void initGUI() {
		jPanel = new JPanel();
		
		
		// tabla tratamientos
		tratamientosDtm = new DefaultTableModel(tratamientosData, tratamientosColumnNames);
		for (TratamientoReclamo trat : reclamoView.getTratamientos()) {
			Object[] newRow = { trat.getFecha(), trat.getEstado(), trat.getDesc()};
			tratamientosDtm.addRow(newRow);
		}
		
		
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Detalles de Reclamo");
			this.setPreferredSize(new java.awt.Dimension(600, 500));
			this.setDefaultLookAndFeelDecorated(true);
			this.setResizable(false);
			this.setMinimumSize(new Dimension(600, 600));
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				
				jLabel1.setText("Reclamo " + reclamoView.getTipo());
				jLabel1.setFont(font);
				jLabel1.setBounds(202, 21, 200, 22);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Cliente");
				jLabel4.setBounds(33, 103, 78, 16);
			}
			{
				// clientesView = SistemaReclamos.getInstance().getClientes();
				clientesView = new Vector<ClienteView>();

				// Armar texto
				Vector<String> clientes = new Vector<String>();
				for (int i = 0; i < clientesView.size(); i++) {
					clientes.add(clientesView.elementAt(i).getNombre());
				}
				@SuppressWarnings({})
				ComboBoxModel clientesModel = new DefaultComboBoxModel(clientes);
			}
			//
			// {
			// dniText = new JTextField();
			// getContentPane().add(dniText);
			// dniText.setBounds(202, 127, 120, 22);
			// }
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Descripcion:");
				jLabel5.setBounds(33, 172, 93, 16);
			}
			{
				descripcion = new JTextArea();
				descripcion.setEditable(false);
				getContentPane().add(descripcion);
				descripcion.setLineWrap(true);
				descripcion.setWrapStyleWord(true);
				descripcion.setText(reclamoView.getDescripcion());
			}
			{
				JScrollPane scrollPane = new JScrollPane(descripcion);
				getContentPane().add(scrollPane);
				scrollPane.setBounds(202, 166, 161, 62);
			}

			{
				// productosView = SistemaReclamos.getInstance().getProductos();
				productosView = new Vector<ProductoView>();

				// Armar texto
				Vector<String> productos = new Vector<String>();
				for (int i = 0; i < productosView.size(); i++) {
					productos.add(productosView.elementAt(i).getDescripcion());
				}
				@SuppressWarnings({})
				ComboBoxModel productosModel = new DefaultComboBoxModel(productos);
			}
			{

				cancelar = new JButton();
				getContentPane().add(cancelar);
				cancelar.setText("Cerrar");
				cancelar.setBounds(202, 539, 120, 22);
				{
					textField = new JTextField();
					textField.setEditable(false);
					textField.setBounds(202, 98, 130, 26);
					getContentPane().add(textField);
					textField.setColumns(10);
					textField.setText(reclamoView.getCliente().getNombre());
				}
				
				JLabel lblNombre = new JLabel("Nombre");
				lblNombre.setBounds(123, 103, 61, 16);
				getContentPane().add(lblNombre);
				
				JLabel lblDni = new JLabel("DNI");
				lblDni.setBounds(123, 131, 61, 16);
				getContentPane().add(lblDni);
				
				textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setBounds(202, 126, 130, 26);
				getContentPane().add(textField_1);
				textField_1.setColumns(10);
				textField_1.setText(reclamoView.getCliente().getDni());
				
				JScrollPane scrollPane = new JScrollPane((Component) null);
				scrollPane.setBounds(33, 429, 512, 96);
				getContentPane().add(scrollPane);
				
				table = new JTable(tratamientosDtm);
				table.setPreferredScrollableViewportSize(new Dimension(650, 150));
				table.setFillsViewportHeight(true);
				scrollPane.setViewportView(table);
				
				lblTratamientos = new JLabel("Tratamientos");
				lblTratamientos.setBounds(245, 401, 93, 16);
				getContentPane().add(lblTratamientos);
				
				JLabel lblNumeroDeReclamo = new JLabel("Numero de Reclamo");
				lblNumeroDeReclamo.setBounds(33, 61, 151, 16);
				getContentPane().add(lblNumeroDeReclamo);
				
				textField_2 = new JTextField();
				textField_2.setEditable(false);
				textField_2.setBounds(202, 55, 130, 26);
				getContentPane().add(textField_2);
				textField_2.setColumns(10);
				textField_2.setText(reclamoView.getNroReclamo());
				
				lblZona = new JLabel("Zona");
				lblZona.setBounds(33, 278, 61, 16);
				getContentPane().add(lblZona);
				
				textField_3 = new JTextField();
				textField_3.setEditable(false);
				textField_3.setBounds(202, 273, 130, 26);
				getContentPane().add(textField_3);
				textField_3.setColumns(10);
				textField_3.setText(reclamoView.getZona());
				cancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						ReclamoZonaVista.getInstancia(null).setVisible(false);

					}
				});
			}

			pack();
			this.setSize(600, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JTextField getDomicilio() {
		return domicilio;
	}

	public void setReclamoID(String recID) {
		reclamoID = recID;
	}
}
