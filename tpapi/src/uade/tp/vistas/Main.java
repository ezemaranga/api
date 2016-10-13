package uade.tp.vistas;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login.getInstancia().setLocationRelativeTo(null);
				Login.getInstancia().setVisible(true);
			}
		});

	}

}
