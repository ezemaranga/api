package uade.tp.vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import uade.tp.ai.UsuarioView;
import uade.tp.sistema.SistemaReclamos;

@SuppressWarnings("serial")
public class Login extends javax.swing.JFrame{
	private JLabel usuarioLbl;
	private JTextField usuarioTxt;
	private JLabel passwordLbl;
	private JTextField passwordTxt;
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
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Login");
			this.setPreferredSize(new java.awt.Dimension(400, 200));
			Login.setDefaultLookAndFeelDecorated(true);
			this.setResizable(false);
			this.setMinimumSize(new java.awt.Dimension(400, 200));
			this.setUndecorated(true);
			{
				usuarioLbl = new JLabel();
				getContentPane().add(usuarioLbl);
				usuarioLbl.setText("Usuario:");
				usuarioLbl.setBounds(12, 24, 80, 16);
			}
			{
				usuarioTxt = new JTextField();
				getContentPane().add(usuarioTxt);
				usuarioTxt.setBounds(142, 21, 121, 22);
			}
			{
				passwordLbl = new JLabel();
				getContentPane().add(passwordLbl);
				passwordLbl.setText("Password:");
				passwordLbl.setBounds(13, 59, 80, 16);
			}
			{
				passwordTxt = new JTextField();
				getContentPane().add(passwordTxt);
				passwordTxt.setBounds(142, 56, 121, 21);
			}
			{
				aceptar = new JButton();
				getContentPane().add(aceptar);
				aceptar.setText("Aceptar");
				aceptar.setBounds(142, 100, 123, 22);
				//                al-h/al-f/ 
				aceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						if(usuarioTxt.getText().equals("") || passwordTxt.getText().equals("")){
							if(usuarioTxt.getText().equals("")){
								JOptionPane.showMessageDialog(null, "Complete el campo Usuario", "Error Login", JOptionPane.ERROR_MESSAGE);
								return;
							} else {
								JOptionPane.showMessageDialog(null, "Complete el campo Password", "Error Login", JOptionPane.ERROR_MESSAGE);
								return;
							}
						} else {
							usuario = SistemaReclamos.getInstance().buscarUsuario((String) usuarioTxt.getText(), (String) passwordTxt.getText());
							
							if (usuario == null) 
							{
								JOptionPane.showMessageDialog(null, "Usuario/Password incorrecta", "Error Login", JOptionPane.ERROR_MESSAGE);
								return;
								
							} else {
								
								Menu.getInstancia().setLocationRelativeTo(null);
								Menu.getInstancia().setVisible(true);
								instancia.setVisible(false);
							}
						}
					}
				});
			}
			pack();
			this.setSize(400, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
