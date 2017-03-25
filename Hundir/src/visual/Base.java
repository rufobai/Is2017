package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Base extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane2;

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
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnJugar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println("CLICK");
				generarJuego();
			}
		});
		JButton btnAyuda = new JButton("Ayuda");		
		JButton btnAcercaDe = new JButton("Acerca de...");
		btnAcercaDe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println("Acerca de...");
			}
		});
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
		setContentPane(contentPane);
		//setContentPane(new PanelJuego());
		//MENU DE JUEGO
		
		/*GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JButton button = new JButton("?");
				GridBagConstraints lugar = new GridBagConstraints();
				System.out.println("Posicion: "+ i + " " + j);
				lugar.gridx = i;
				lugar.gridy = j;
				getContentPane().add(button, lugar);
			}
		}*/
		
		//contentPane.setLayout(gridBagLayout);
		
		
		
		
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		//contentPane.setVisible(true);
		//ImageIcon fondo = new ImageIcon("/estaticos/FondoPrueba.jpg");
		
	}
	
	private void generarJuego(){
		
		System.out.println("Generamos el panel de juego");
		
		contentPane2 = new JPanel();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JButton button = new JButton("?");
				GridBagConstraints lugar = new GridBagConstraints();
				System.out.println("Posicion: "+ i + " " + j);
				lugar.gridx = i;
				lugar.gridy = j;
				contentPane2.add(button, lugar);
			}
		}
		
		contentPane2.setLayout(gridBagLayout);
		setContentPane(contentPane2);
	}

}
