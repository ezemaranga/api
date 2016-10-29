package uade.tp.vistas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import uade.tp.ai.UsuarioView;
import uade.tp.sistema.SistemaReclamos;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class Login extends javax.swing.JFrame{
	
	private JLabel usuarioLbl;
	private JLabel passwordLbl;
	
	private JTextField usuarioTxt;
	private JPasswordField passwordTxt;

	private JButton aceptar;
	
	private static UsuarioView usuario;
	
	private static Login instancia;
	
	public static Login getInstancia()
	{
		if (instancia == null)
			instancia = new Login();
		return instancia;
	}
	
	public Login() {
		super();
		initGUI();
	}
			
	public static UsuarioView getUsuario() {
		return usuario;
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 200));
			this.setTitle("Sistema Reclamos");			
			Login.setDefaultLookAndFeelDecorated(true);
			this.setMinimumSize(new java.awt.Dimension(400, 200));
			this.setResizable(false);
			{
				usuarioLbl = new JLabel();
				getContentPane().add(usuarioLbl);
				usuarioLbl.setText("Usuario:");
				usuarioLbl.setBounds(12, 41, 80, 16);
			}
			{
				usuarioTxt = new JTextField();
				getContentPane().add(usuarioTxt);
				usuarioTxt.setBounds(142, 38, 121, 22);
			}
			{
				passwordLbl = new JLabel();
				getContentPane().add(passwordLbl);
				passwordLbl.setText("Contraseña:");
				passwordLbl.setBounds(12, 73, 80, 16);
			}
			{
				passwordTxt = new JPasswordField();
				getContentPane().add(passwordTxt);
				passwordTxt.setBounds(142, 71, 121, 21);
			}
			{
				aceptar = new JButton();
				getContentPane().add(aceptar);
				aceptar.setText("Aceptar");
				aceptar.setBounds(142, 124, 123, 22);
				
				JLabel lblLogin = new JLabel("Login");
				lblLogin.setFont(new Font("Verdana", Font.BOLD, 13));
				lblLogin.setBounds(12, 11, 46, 19);
				getContentPane().add(lblLogin);
				
				aceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						if(usuarioTxt.getText().equals("")){
							JOptionPane.showMessageDialog(null, "complete el campo Usuario", "Error Login", JOptionPane.ERROR_MESSAGE);
							return;
						} 
						
						if(passwordTxt.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Complete el campo Contraseña", "Error Login", JOptionPane.ERROR_MESSAGE);
							return;
						}

						//usuario = new UsuarioView("Responsable Facturacion", "Apellido C", "Apodo C", "PASS C", "RESP_FACTURACION");
						
						usuario = SistemaReclamos.getInstance().buscarUsuario((String) usuarioTxt.getText(), (String) passwordTxt.getText());
						
						if (usuario == null) 
						{
							JOptionPane.showMessageDialog(null, "Usuario/Contraseña incorrecta", "Error Login", JOptionPane.ERROR_MESSAGE);
							return;								
						} else {								
							Menu.getInstancia().setLocationRelativeTo(null);
							Menu.getInstancia().setVisible(true);
							setVisible(false);
							dispose();
						}
					}
				});
			}
			this.pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
