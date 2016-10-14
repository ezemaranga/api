package uade.tp.vistas;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import uade.tp.ai.ClienteView;
import uade.tp.ai.reclamo.ReclamoCantidad;

//import Controlador.Sistema;
//import Negocio.DistribuidoraView;
//import Negocio.TipoDocView;
//import Vista.AltaAfiliado;

public class ReclamoCantidadVista extends javax.swing.JFrame{

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
	private JTextField cantidadText;
	private JTextField domicilio;
	
	private JButton aceptar;
	private JButton cancelar;

	private JTextArea jTextArea;
	private JScrollPane jScrollPane;
	
	private JComboBox clientesCombo;
	
	//Combos
	
	Vector<ClienteView> clientesView;
	
	private static ReclamoCantidadVista instancia;
	
	public static ReclamoCantidadVista getInstancia()
	{
		if (instancia == null)
			instancia = new ReclamoCantidadVista();
		return instancia;
	}

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ReclamoCantidadVista inst = new ReclamoCantidadVista();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ReclamoCantidadVista() {
		super();
		initGUI();
	}
	
	@SuppressWarnings({ "static-access", "unchecked", "rawtypes" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Alta de Reclamos - Reclamo de Cantidad");
			this.setPreferredSize(new java.awt.Dimension(600, 500));
			this.setDefaultLookAndFeelDecorated(true);
			this.setResizable(false);
			this.setMinimumSize(new java.awt.Dimension(600, 500));
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Reclamo Cantidad");
				jLabel1.setFont(font);
				jLabel1.setBounds(202, 21, 200, 22);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Fecha Reclamo:");
				jLabel2.setBounds(33, 59, 120, 16);
			}
			{
				fechaReclamoText = new JTextField();
				getContentPane().add(fechaReclamoText);
				fechaReclamoText.setBounds(202, 56, 121, 21);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("(yyyy-mm-dd)");
				jLabel6.setBounds(328, 56, 121, 21);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Numero de Reclamo:");
				jLabel3.setBounds(33, 94, 120, 16);
			}
			{
				numeroReclamoText = new JTextField();
				getContentPane().add(numeroReclamoText);
				numeroReclamoText.setBounds(202, 91, 120, 22);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Cliente");
				jLabel4.setBounds(33, 130, 78, 16);
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
				clientesCombo = new JComboBox();
				getContentPane().add(clientesCombo);
				clientesCombo.setModel(clientesModel);
				clientesCombo.setBounds(202, 127, 120, 22);
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
				jTextArea = new JTextArea();
				getContentPane().add(jTextArea);
				jTextArea.setLineWrap(true);
				jTextArea.setWrapStyleWord(true);
			}
			{
				JScrollPane scrollPane = new JScrollPane(jTextArea); 
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
				productoText = new JTextField();
				getContentPane().add(productoText);
				productoText.setBounds(202, 240, 120, 22);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("Cantidad");
				jLabel8.setBounds(33, 275, 78, 16);
			}
			{
				cantidadText = new JTextField();
				getContentPane().add(cantidadText);
				cantidadText.setBounds(202, 275, 120, 22);
			}
			{
				aceptar = new JButton();
				getContentPane().add(aceptar);
				aceptar.setText("Guardar");
				aceptar.setBounds(70, 360, 123, 22);
				aceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						if(fechaReclamoText.getText().equals("") || numeroReclamoText.getText().equals("") || dniText.getText().equals("") ||
						   jTextArea.getText().equals("") || productoText.getText().equals("") || cantidadText.getText().equals("")){
							if(fechaReclamoText.getText().equals("")){
								JOptionPane.showMessageDialog(null, "Complete el campo Fecha Reclamo", "Error Alta Reclamo", JOptionPane.ERROR_MESSAGE);
								return;
							} else if(numeroReclamoText.getText().equals("")){
								JOptionPane.showMessageDialog(null, "Complete el campo numero de reclamo", "Error Alta Reclamo", JOptionPane.ERROR_MESSAGE);
								return;
								} else if(dniText.getText().equals("")){
									JOptionPane.showMessageDialog(null, "Complete el campo DNI", "Error Alta Reclamo", JOptionPane.ERROR_MESSAGE);
									return;
									} else if(jTextArea.getText().equals("")){
										JOptionPane.showMessageDialog(null, "Complete el campo Descripcion", "Error Alta Reclamo", JOptionPane.ERROR_MESSAGE);
										return;
										}  else if(productoText.getText().equals("")){
											JOptionPane.showMessageDialog(null, "Complete el campo Producto", "Error Alta Reclamo", JOptionPane.ERROR_MESSAGE);
											return;
											} if(cantidadText.getText().equals("")){
												JOptionPane.showMessageDialog(null, "Complete el campo Cantidad", "Error Alta Reclamo", JOptionPane.ERROR_MESSAGE);
												return;
												} 
						}
						
//						long codigo = Long.parseLong(nroAfiliado.getText());
//						TipoDocView tip = tipDocs.elementAt(tiposDoc.getSelectedIndex());
//						if (((String)distribuidora.getSelectedItem()).equalsIgnoreCase("  "))
//						{
//							JOptionPane.showMessageDialog(null, "Debe seleccionar distribuidora", "Error en el Alta de Afiliado", JOptionPane.ERROR_MESSAGE);
//							return;
//						}
//						int indice = distribuidora.getSelectedIndex()-1;
//						DistribuidoraView dis = distri.elementAt(indice);
//						String sex = (String)sexo.getSelectedItem();
//						//Formato yyyy-mm-dd hh:mm:ss
//						
//						Timestamp fNac = Timestamp.valueOf(fechaNac.getText()+ " 00:00:00");
//						
//						Sistema.getInstancia().altaAfiliado(codigo, nombre.getText(), domicilio.getText(), telefono.getText(),
//								tip, dni.getText(), sex, fNac, dis);
//						
//						limpiarPantalla();
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
			fechaReclamoText.setText("");
			numeroReclamoText.setText("");
			dniText.setText("");
			jTextArea.setText("");
			productoText.setText("");
			cantidadText.setText("");
		} catch (Exception e) {

		}
	}
}
