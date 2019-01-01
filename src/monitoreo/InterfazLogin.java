package monitoreo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle;

import db.Conexion;

public class InterfazLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelPrincipal;
	private JLabel usuario;
	private JPasswordField password;
	private JButton botonLoguearse;
	private JButton botonSalir;
	private Conexion conexionXamp;
	
	public InterfazLogin() {
		initComponents();
	}
	private void initComponents() {
		panelPrincipal = new JPanel();
		usuario = new JLabel();
		password = new JPasswordField();
		botonLoguearse = new JButton("Loguearse");
		botonSalir = new JButton("Salir");
		panelPrincipal.setBounds(0, 0, 600, 600);
		setContentPane(panelPrincipal);
		
	}

}
