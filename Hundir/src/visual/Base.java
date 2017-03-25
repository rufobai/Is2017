package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Base extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Base frame = new Base();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Base() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		//MENU INICIAL
		contentPane = new JPanel();
		
		JButton btnJugar = new JButton("Jugar");
		JButton btnAyuda = new JButton("Ayuda");		
		JButton btnAcercaDe = new JButton("Acerca de...");
		GroupLayout groupLayout2 = new GroupLayout(contentPane);
		groupLayout2.setHorizontalGroup(
				groupLayout2.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout2.createSequentialGroup()
					.addGap(165)
					.addGroup(groupLayout2.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnAcercaDe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAyuda, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnJugar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		groupLayout2.setVerticalGroup(
				groupLayout2.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout2.createSequentialGroup()
					.addGap(88)
					.addComponent(btnJugar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAyuda)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAcercaDe)
					.addContainerGap(121, Short.MAX_VALUE))
		);
		contentPane.setLayout(groupLayout2);
		//setContentPane(contentPane);
		setContentPane(new PanelJuego());
		//MENU DE JUEGO
		
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		//contentPane.setVisible(true);
		ImageIcon fondo = new ImageIcon("/estaticos/FondoPrueba.jpg");
		
	}

}
