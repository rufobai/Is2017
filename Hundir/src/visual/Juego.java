package visual;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Juego extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego frame = new Juego();
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
	public Juego() {
		setTitle("Hundir la Flota");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelPc = new JPanel();
		contentPane.add(panelPc, BorderLayout.NORTH);
		GridBagLayout gbl_panelPc = new GridBagLayout();
		gbl_panelPc.columnWidths = new int[]{0};
		gbl_panelPc.rowHeights = new int[]{0};
		gbl_panelPc.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelPc.rowWeights = new double[]{Double.MIN_VALUE};
		panelPc.setLayout(gbl_panelPc);
		
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JButton button = new JButton("?");				
				button.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {
						ImageIcon water = new ImageIcon("/estaticos/water.png");
						button.setIcon(water);
						System.out.println("Cambio");
					}
				});
				GridBagConstraints lugar = new GridBagConstraints();
				//System.out.println("Posicion: "+ i + " " + j);
				lugar.gridx = i;
				lugar.gridy = j;
				panelPc.add(button, lugar);
			}
		}
		
		JPanel panelJug = new JPanel();
		contentPane.add(panelJug, BorderLayout.SOUTH);
		GridBagLayout gbl_panelJug = new GridBagLayout();
		gbl_panelJug.columnWidths = new int[]{0};
		gbl_panelJug.rowHeights = new int[]{0};
		gbl_panelJug.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelJug.rowWeights = new double[]{Double.MIN_VALUE};
		panelJug.setLayout(gbl_panelJug);
		
		JPanel panelInfo = new JPanel();
		contentPane.add(panelInfo, BorderLayout.CENTER);
		
		JLabel lblMuni = new JLabel("Munici\u00F3n");
		
		JButton btnPrueba = new JButton("Prueba");
		btnPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPrueba.setBorder(UIManager.getBorder("DesktopIcon.border"));
		ImageIcon water = new ImageIcon("water.png");
		System.out.println(water.getIconWidth());
		
		btnPrueba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnPrueba.setText("");
				btnPrueba.setIcon(water);
				System.out.println("Cambio");
			}
		});
		GroupLayout gl_panelInfo = new GroupLayout(panelInfo);
		gl_panelInfo.setHorizontalGroup(
			gl_panelInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfo.createSequentialGroup()
					.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInfo.createSequentialGroup()
							.addGap(176)
							.addComponent(lblMuni))
						.addGroup(gl_panelInfo.createSequentialGroup()
							.addGap(162)
							.addComponent(btnPrueba, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(160, Short.MAX_VALUE))
		);
		gl_panelInfo.setVerticalGroup(
			gl_panelInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfo.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMuni)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPrueba)
					.addContainerGap(570, Short.MAX_VALUE))
		);
		panelInfo.setLayout(gl_panelInfo);
		
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JButton button = new JButton("");
				ImageIcon ns = new ImageIcon("ns.png");
				button.setIcon(ns);
				//button.setBorder(null);
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						ImageIcon ns = new ImageIcon("water.png");
						button.setText("");
						button.setIcon(water);
						System.out.println("Cambio");
					}
				});
				GridBagConstraints lugar = new GridBagConstraints();
				//System.out.println("Posicion: "+ i + " " + j);
				lugar.gridx = i;
				lugar.gridy = j;
				panelJug.add(button, lugar);
			}
		}
	}
}
