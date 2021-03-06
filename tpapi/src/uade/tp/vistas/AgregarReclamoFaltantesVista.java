package uade.tp.vistas;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import uade.tp.ai.ClienteView;
import uade.tp.ai.ProductoView;
import uade.tp.ai.reclamo.ItemReclamo;
import uade.tp.ai.reclamo.ReclamoDistribucion;
import uade.tp.sistema.SistemaReclamos;

public class AgregarReclamoFaltantesVista extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	private Font font = new Font("Courier", Font.BOLD, 16);

	private JLabel title;
	private JLabel jLabel1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JTextField dniText;
	private JTextField productoText;
	private JTextField cantProd;
	private JTextField domicilio;

	private JButton aceptar;
	private JButton cancelar;

	private JTextArea descripcion;
	private JScrollPane jScrollPane;

	private JComboBox prod;

	// Combos

	Vector<ClienteView> clientesView;
	Vector<ProductoView> productosView;

	private static AgregarReclamoFaltantesVista instancia;
	private JTextField textField;
	private JButton btnValidarCliente;
	private JButton btnAgregarProducto;
	private JTable productosTable;

	DefaultTableModel dtm;
	Object[][] data = {};
	String[] columnNames = { "Cantidad", "ID Producto", "Nombre", "Descripcion", "Precio" };

	private JPanel jPanel;

	public static AgregarReclamoFaltantesVista getInstancia() {
		if (instancia == null)
			instancia = new AgregarReclamoFaltantesVista();
		return instancia;
	}

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AgregarReclamoFaltantesVista inst = new AgregarReclamoFaltantesVista();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public AgregarReclamoFaltantesVista() {
		super();
		initGUI();
	}

	@SuppressWarnings({ "static-access", "unchecked", "rawtypes" })
	private void initGUI() {
		jPanel = new JPanel();
		dtm = new DefaultTableModel(data, columnNames);
		// Object[] newRow={"1", "123","fdg", new Integer(5), new
		// Boolean(false)};
		// dtm.addRow(newRow);

		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Alta de Reclamos - Reclamo de Faltantes");
			this.setPreferredSize(new java.awt.Dimension(600, 500));
			this.setDefaultLookAndFeelDecorated(true);
			this.setResizable(false);
			this.setMinimumSize(new java.awt.Dimension(600, 500));
			final JLabel nombreCliente = new JLabel("");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Reclamo Faltantes");
				jLabel1.setFont(font);
				jLabel1.setBounds(202, 21, 200, 22);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Cliente");
				jLabel4.setBounds(33, 71, 78, 16);
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
				getContentPane().add(descripcion);
				descripcion.setLineWrap(true);
				descripcion.setWrapStyleWord(true);
			}
			{
				JScrollPane scrollPane = new JScrollPane(descripcion);
				getContentPane().add(scrollPane);
				scrollPane.setBounds(202, 166, 161, 62);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Producto");
				jLabel7.setBounds(33, 240, 78, 16);
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

			// {
			// productoText = new JTextField();
			// getContentPane().add(productoText);
			// productoText.setBounds(202, 240, 120, 22);
			// }
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("Cantidad");
				jLabel8.setBounds(33, 275, 78, 16);
			}
			{
				cantProd = new JTextField();
				getContentPane().add(cantProd);
				cantProd.setBounds(202, 275, 120, 22);
			}
			{
				aceptar = new JButton();
				getContentPane().add(aceptar);
				aceptar.setText("Guardar");
				aceptar.setBounds(205, 435, 123, 22);
				aceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String nroReclamo = SistemaReclamos.getInstance().agregarReclamo(descripcion.getText());
						JOptionPane.showMessageDialog(null, "Reclamo Guardado.\n Su numero de reclamo es : " + nroReclamo, "Exito!", JOptionPane.PLAIN_MESSAGE);
						limpiarPantalla();
						dispose();
					}
				});
			}
			{

				cancelar = new JButton();
				getContentPane().add(cancelar);
				cancelar.setText("Cancelar");
				cancelar.setBounds(340, 435, 120, 22);
				{
					textField = new JTextField();
					textField.setBounds(192, 66, 130, 26);
					getContentPane().add(textField);
					textField.setColumns(10);
				}
				{
					btnValidarCliente = new JButton("Validar cliente");
					btnValidarCliente.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (SistemaReclamos.getInstance().existeCliente(textField.getText())) {
								nombreCliente.setText(
										SistemaReclamos.getInstance().getReclamoActual().getCliente().getNombre());
							} else {
								nombreCliente.setText("No existe el cliente");
							}
						}
					});
					btnValidarCliente.setBounds(340, 66, 117, 29);
					getContentPane().add(btnValidarCliente);
				}

				{
					btnAgregarProducto = new JButton("Agregar producto");
					btnAgregarProducto.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							SistemaReclamos.getInstance().ingresarDatosProducto(
									((ProductoView) prod.getSelectedItem()).getCodPublicacion(),
									Integer.parseInt(cantProd.getText()));
							ReclamoDistribucion reclamo = (ReclamoDistribucion) SistemaReclamos.getInstance()
									.getReclamoActual();
							dtm.getDataVector().clear();
							for (ItemReclamo itemRec : reclamo.getItems()) {
								Object[] newRow = { itemRec.getCantidad(), itemRec.getProducto().getCodPublicacion(),
										itemRec.getProducto().getTitulo(), itemRec.getProducto().getDescripcion(),
										itemRec.getProducto().getPrecio() };
								dtm.addRow(newRow);
							}
							productosTable = new JTable(dtm);
							productosTable.setLocation(70, 307);
							productosTable.setSize(375, 160);
							productosTable.setPreferredScrollableViewportSize(new Dimension(650, 150));
							productosTable.setFillsViewportHeight(true);

						}
					});
					btnAgregarProducto.setBounds(334, 270, 157, 29);
					getContentPane().add(btnAgregarProducto);
				}

				productosTable = new JTable(dtm);
				productosTable.setLocation(70, 307);
				productosTable.setSize(375, 160);
				productosTable.setPreferredScrollableViewportSize(new Dimension(650, 150));
				productosTable.setFillsViewportHeight(true);

				jScrollPane = new JScrollPane(productosTable);
				jScrollPane.setBounds(33, 303, 512, 96);

				getContentPane().add(jScrollPane);

				nombreCliente.setBounds(202, 112, 319, 16);
				getContentPane().add(nombreCliente);

				productosView = SistemaReclamos.getInstance().getProductosView();

				Vector<ProductoView> productos = new Vector<ProductoView>();
				for (ProductoView z : productosView) {
					productos.add(z);
				}
				@SuppressWarnings({})
				ComboBoxModel prodModel = new DefaultComboBoxModel(productos);
				prod = new JComboBox();
				prod.setModel(prodModel);
				prod.setBounds(202, 236, 289, 27);
				getContentPane().add(prod);

				cancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						limpiarPantalla();
						AgregarReclamoFaltantesVista.getInstancia().setVisible(false);

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

	public void limpiarPantalla() {
		try {
			// fechaReclamoText.setText("");
			// numeroReclamoText.setText("");
			dtm.getDataVector().clear();
			textField.setText("");
			descripcion.setText("");
			prod.setSelectedIndex(0);
			;
			cantProd.setText("");
		} catch (Exception e) {

		}
	}

}
