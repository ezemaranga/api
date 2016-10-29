package uade.tp.vistas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import uade.tp.ai.ClienteView;
import uade.tp.ai.ZonaView;
import uade.tp.bbdd.ZonaMapper;
import uade.tp.sistema.SistemaReclamos;

public class ReclamoZonaVista extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;
	
	private Font font = new Font("Courier", Font.BOLD,16);
	
	private JLabel title;
	private JLabel jLabel1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JTextField dniText;
	private JTextField productoText;
	private JTextField domicilio;
	
	private JButton aceptar;
	private JButton cancelar;

	private JTextArea descripcion;
	private JScrollPane jScrollPane;
	private JComboBox zonasCombo;
	
	
	//Combos
	Vector<ClienteView> clientesView;
	List<ZonaView> zonasView;
	
	private static ReclamoZonaVista instancia;
	private JTextField textField;
	private JLabel nombreCliente;
	
	public static ReclamoZonaVista getInstancia()
	{
		if (instancia == null)
			instancia = new ReclamoZonaVista();
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
		initGUI();
	}
	
	@SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Alta de Reclamos - Reclamo de Zona");
			this.setPreferredSize(new java.awt.Dimension(600, 500));
			this.setDefaultLookAndFeelDecorated(true);
			this.setResizable(false);
			this.setMinimumSize(new java.awt.Dimension(600, 500));
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Reclamo Zona");
				jLabel1.setFont(font);
				jLabel1.setBounds(202, 21, 200, 22);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Cliente");
				jLabel4.setBounds(33, 70, 78, 16);
			}
			
			{
//				clientesView = SistemaReclamos.getInstance().getClientes();
				clientesView = new Vector<ClienteView>();
				
				//Armar texto
				Vector<String> clientes = new Vector<String>();
				for (int i=0;i<clientesView.size();i++)
				{
					clientes.add(clientesView.elementAt(i).getNombre());
				}
				@SuppressWarnings({ })
				ComboBoxModel clientesModel = new DefaultComboBoxModel(clientes);
			}
			
//			{
//				dniText = new JTextField();
//				getContentPane().add(dniText);
//				dniText.setBounds(202, 127, 120, 22);
//			}
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
				jLabel7.setText("Zonas");
				jLabel7.setBounds(33, 240, 78, 16);
			}
			{
				zonasView = SistemaReclamos.getInstance().getZonasView();
				
				//Armar texto
				Vector<ZonaView> zonas = new Vector<ZonaView>();
				for (ZonaView z : zonasView) {
					zonas.add(z);
				}
				@SuppressWarnings({ })
				ComboBoxModel zonasModel = new DefaultComboBoxModel(zonas);
				zonasCombo = new JComboBox();
				getContentPane().add(zonasCombo);
				zonasCombo.setModel(zonasModel);
				zonasCombo.setBounds(202, 240, 200, 22);
			}
			
			
			{
				aceptar = new JButton();
				getContentPane().add(aceptar);
				aceptar.setText("Guardar");
				aceptar.setBounds(70, 360, 123, 22);
				aceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						SistemaReclamos.getInstance().ingresarDatosZona(((ZonaView)zonasCombo.getSelectedItem()).getCodigo());
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
				cancelar.setBounds(210, 360, 120, 22);
				
				textField = new JTextField();
				textField.setBounds(192, 65, 130, 26);
				getContentPane().add(textField);
				textField.setColumns(10);
				
				JButton btnValidarCliente = new JButton("Validar cliente");
				btnValidarCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(SistemaReclamos.getInstance().existeCliente(textField.getText())) {
							nombreCliente.setText(SistemaReclamos.getInstance().getReclamoActual().getCliente().getNombre());  
						} else {
							nombreCliente.setText("No existe el cliente");  
						} 
					}
				});
				btnValidarCliente.setBounds(349, 65, 117, 29);
				getContentPane().add(btnValidarCliente);
				{
					nombreCliente = new JLabel("");
					nombreCliente.setBounds(202, 112, 295, 22);
					getContentPane().add(nombreCliente);
				}
				cancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						limpiarPantalla();
						dispose();
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
	public void limpiarPantalla()
	{
		try {
			textField.setText("");
			descripcion.setText("");
			zonasCombo.setSelectedIndex(0);
		} catch (Exception e) {

		}
	}
}
