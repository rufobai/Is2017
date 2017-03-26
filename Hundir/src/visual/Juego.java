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

import code.HundirFlota;

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
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Juego extends JFrame {

	private JPanel contentPane;
	private String estado;
	private String barcoToca;
	private int barcosInsert;
	private JPanel panelJug;
	private JLabel lblSeleccioneLasPosiciones;
	private ArrayList<Integer> listaPos = new ArrayList<Integer>();
	private JButton btnMoe;	
	private JButton btnMt;	
	private JButton btnR;	
	private JLabel labelBN;	
	private JLabel labelMN;	
	private JLabel labelMNSN;	
	private JLabel labelMOEN ;	
	private JLabel labelTN;	
	private JLabel labelRN;

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
		estado = "Inicio";
		barcoToca = "Portaaviones";
		barcosInsert = 20;
		setTitle("Hundir la Flota");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 768);
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
						/*ImageIcon water = new ImageIcon("/estaticos/water.png");
						button.setIcon(water);
						System.out.println("Cambio");*/
					}
				});
				GridBagConstraints lugar = new GridBagConstraints();
				//System.out.println("Posicion: "+ i + " " + j);
				lugar.gridx = i;
				lugar.gridy = j;
				panelPc.add(button, lugar);
			}
		}
		
		panelJug = new JPanel();
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
		
		JButton btnPrueba = new JButton("Empezar");
		btnPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPrueba.setBorder(UIManager.getBorder("DesktopIcon.border"));
		ImageIcon water = new ImageIcon("water.png");
		//System.out.println(water.getIconWidth());
		
		btnPrueba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnPrueba.setVisible(false);
				Integer[] arma = HundirFlota.getMiFlota().obtenerArmamento();
				System.out.println("Lista" + arma[0]);
				labelRN.setText(""+ arma[0]);
				labelBN.setText(""+ arma[1]);
				labelMN.setText(""+ arma[2]);
				labelMNSN.setText(""+ arma[3]);
				labelMOEN.setText(""+ arma[4]);
				labelTN.setText(""+ arma[5]);
				//btnPrueba.setIcon(water);
				//System.out.println("Cambio");
				HundirFlota.getMiFlota().asignarBarcosJugador(listaPos);
			}
		});
		
		JLabel lblBomba = new JLabel("Bomba");
		
		JLabel lblMisil = new JLabel("Misil");
		
		JLabel lblMisilNs = new JLabel("Misil NS");
		
		JLabel lblMisilOe = new JLabel("Misil OE");
		
		JLabel lblMisilT = new JLabel("Misil T");
		
		JLabel lblRadar = new JLabel("Radar");
		
		JButton btnB = new JButton("B");
		
		JButton btnM = new JButton("M");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnMns = new JButton("MNS");
		btnMns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		 btnMoe = new JButton("MOE");
		
		 btnMt = new JButton("MT");
		
		 btnR = new JButton("R");
		
		 labelBN = new JLabel("0");
		
		 labelMN = new JLabel("0");
		
		 labelMNSN = new JLabel("0");
		
		 labelMOEN = new JLabel("0");
		
		 labelTN = new JLabel("0");
		
		 labelRN = new JLabel("0");
		
		lblSeleccioneLasPosiciones = new JLabel("SELECCIONE LA POSICION DE " + barcoToca);
		GroupLayout gl_panelInfo = new GroupLayout(panelInfo);
		gl_panelInfo.setHorizontalGroup(
			gl_panelInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfo.createSequentialGroup()
					.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInfo.createSequentialGroup()
							.addGap(176)
							.addComponent(lblMuni))
						.addGroup(gl_panelInfo.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBomba)
								.addComponent(btnB)
								.addGroup(gl_panelInfo.createSequentialGroup()
									.addGap(10)
									.addComponent(labelBN)))
							.addGap(18)
							.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelInfo.createSequentialGroup()
									.addComponent(lblMisil)
									.addGap(44)
									.addComponent(lblMisilNs))
								.addGroup(gl_panelInfo.createSequentialGroup()
									.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
										.addComponent(btnM)
										.addGroup(gl_panelInfo.createSequentialGroup()
											.addGap(10)
											.addComponent(labelMN)))
									.addGap(18)
									.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelInfo.createSequentialGroup()
											.addGap(10)
											.addComponent(labelMNSN))
										.addComponent(btnMns))))
							.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelInfo.createSequentialGroup()
									.addGap(32)
									.addComponent(lblMisilOe))
								.addGroup(gl_panelInfo.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelInfo.createSequentialGroup()
											.addGap(10)
											.addComponent(labelMOEN))
										.addComponent(btnMoe))))
							.addGap(18)
							.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
								.addComponent(btnMt)
								.addComponent(lblMisilT)
								.addGroup(gl_panelInfo.createSequentialGroup()
									.addGap(10)
									.addComponent(labelTN)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRadar)
								.addComponent(btnR)
								.addGroup(gl_panelInfo.createSequentialGroup()
									.addGap(6)
									.addComponent(labelRN))))
						.addGroup(gl_panelInfo.createSequentialGroup()
							.addGap(155)
							.addComponent(btnPrueba, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panelInfo.createSequentialGroup()
					.addContainerGap(106, Short.MAX_VALUE)
					.addComponent(lblSeleccioneLasPosiciones)
					.addGap(77))
		);
		gl_panelInfo.setVerticalGroup(
			gl_panelInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfo.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMuni)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMisilOe)
						.addComponent(lblBomba)
						.addComponent(lblMisil)
						.addComponent(lblMisilNs)
						.addComponent(lblMisilT)
						.addComponent(lblRadar))
					.addGap(8)
					.addGroup(gl_panelInfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnB)
						.addComponent(btnM)
						.addComponent(btnMns)
						.addComponent(btnMoe)
						.addComponent(btnMt)
						.addComponent(btnR))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelBN)
						.addComponent(labelMN)
						.addComponent(labelMNSN)
						.addComponent(labelMOEN)
						.addComponent(labelTN)
						.addComponent(labelRN))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSeleccioneLasPosiciones)
					.addGap(12)
					.addComponent(btnPrueba)
					.addContainerGap(557, Short.MAX_VALUE))
		);
		panelInfo.setLayout(gl_panelInfo);
		
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JButton button = new JButton("?");
				GridBagConstraints lugar = new GridBagConstraints();
				//System.out.println("Posicion: "+ i + " " + j);
				lugar.gridx = i;
				lugar.gridy = j;
				//ImageIcon ns = new ImageIcon("ns.png");
				//button.setIcon(ns);
				//button.setBorder(null);
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						if(estado.equals("Inicio")){
							System.out.println("Entro ");
							button.setEnabled(false);
							barcosInsert--;
							System.out.println("BI: " + barcosInsert);
							if(barcosInsert == 16){
								System.out.println("Entra 2");
								barcoToca = "Submarino";
							}else if (barcosInsert == 10) {
								barcoToca = "Destructor";
							}else if (barcosInsert == 4) {
								barcoToca = "Fragata";
							}else if(barcosInsert == 0){
								barcoToca = "Fin";
							}
							if(barcoToca.equals("Fin")){
								lblSeleccioneLasPosiciones.setVisible(false);
							}else{
								lblSeleccioneLasPosiciones.setText("SELECCIONE LA POSICION DE " + barcoToca);
							}
							
							listaPos.add(lugar.gridx);
							listaPos.add(lugar.gridy);
							//resaltarPos(lugar.gridx, lugar.gridy);
						}
						
						/*ImageIcon ns = new ImageIcon("water.png");
						button.setText("");
						button.setIcon(water);
						System.out.println("Cambio");*/
					}
					
				});
				
				panelJug.add(button, lugar);
			}
		}
		
	}
	
	private void resaltarPos(int i, int j) {
		if(barcoToca.equals("Porta")){
			for (int j2 = 0; j2 <10; j2++) {
				for (int k = 0; k < 10; k++) {
					GridBagConstraints lugar = new GridBagConstraints();
					lugar.gridx = i;
					lugar.gridy = j;
					//((JButton) panelJug.getComponentAt(j2, k)).setText("AAA");
				}
			}
		}
		
	}
}
