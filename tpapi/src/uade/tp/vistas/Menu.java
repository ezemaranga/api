package uade.tp.vistas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class Menu extends javax.swing.JFrame {
	private JMenuBar jMenuBar1;
	private JMenuItem jMenuItem4;
	private JMenu jMenu1;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JMenu jMenu3;
	private JMenu jMenu2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				Menu inst = new Menu();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				
			}
		});
	}
	
	public Menu() {
		super();
		initGUI();
	}
	
	private static Menu instancia;
	
	public static Menu getInstancia()
	{
		if (instancia == null) {
			instancia = new Menu();
		}
		return instancia;
	}
	
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(800, 600));
			this.setTitle("Sistema de Administracion de Obra Social");
			setDefaultLookAndFeelDecorated(true);
			this.setMinimumSize(new java.awt.Dimension(800, 600));
			this.setResizable(false);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu2 = new JMenu();
					jMenuBar1.add(jMenu2);
					jMenu2.setText("Administracion de Reclamos");
					{
						jMenu3 = new JMenu();
						jMenu2.add(jMenu3);
						jMenu3.setText("Alta de Reclamos");
						jMenu3.setBounds(39, 0, 57, 23);
						{
							jMenuItem1 = new JMenuItem();
							jMenu3.add(jMenuItem1);
							jMenuItem1.setText("Alta Afiliado");
							jMenuItem1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) 
								{
//									AltaAfiliado.getInstancia().setLocationRelativeTo(null);
//									AltaAfiliado.getInstancia().setVisible(true);
								}
							});
						}
						{
							jMenuItem2 = new JMenuItem();
							jMenu3.add(jMenuItem2);
							jMenuItem2.setText("Modificacion Afiliado");
							jMenuItem2.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) 
								{
									System.out.println("jMenuItem2.actionPerformed, event="+evt);
									//TODO add your code for jMenuItem2.actionPerformed
								}
							});
						}
						{
							jMenuItem3 = new JMenuItem();
							jMenu3.add(jMenuItem3);
							jMenuItem3.setText("Baja Afiliado");
							jMenuItem3.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) 
								{
//									BajaAfiliado.getInstancia().setLocationRelativeTo(null);
//									BajaAfiliado.getInstancia().setVisible(true);
								}
							});
						}
					}
				}
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("Salir del Sistema");
					{
						jMenuItem4 = new JMenuItem();
						jMenu1.add(jMenuItem4);
						jMenuItem4.setText("Salir");
						jMenuItem4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								System.exit(0);
							}
						});
					}
				}
			}
			pack();
			this.setSize(800, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
