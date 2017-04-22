package visual;

import java.awt.BorderLayout;
import java.awt.Color;
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
	private boolean radar;
	private String tipoDisparo;

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
		radar = false;
		tipoDisparo = "B";
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
		btnPrueba.setVisible(false);
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
				estado = "Juego";
			}
		});
		
		JLabel lblBomba = new JLabel("Bomba");
		
		JLabel lblMisil = new JLabel("Misil");
		
		JLabel lblMisilNs = new JLabel("Misil NS");
		
		JLabel lblMisilOe = new JLabel("Misil OE");
		
		JLabel lblMisilT = new JLabel("Misil T");
		
		JLabel lblRadar = new JLabel("Radar");
		
		JButton btnB = new JButton("B");
		btnB.setBackground(Color.GREEN);
		btnB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(btnB.isEnabled()){	
				if (tipoDisparo.equals("B")) {
					tipoDisparo = "0";
					btnB.setBackground(Color.gray);
				}else if(tipoDisparo.equals("0")){
					tipoDisparo = "B";
					btnB.setBackground(Color.GREEN);
				}
				}
				
			}
		});
		
		JButton btnM = new JButton("M");
		btnM.setBackground(Color.GRAY);
		btnM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnM.isEnabled()){	
				if (tipoDisparo.equals("M")) {
					tipoDisparo = "0";
					btnM.setBackground(Color.gray);
				}else if(tipoDisparo.equals("0")){
					tipoDisparo = "M";
					btnM.setBackground(Color.GREEN);
				}
				}
			}		
			
		});
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnMns = new JButton("MNS");
		btnMns.setBackground(Color.GRAY);
		btnMns.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnMns.isEnabled()){	
				if (tipoDisparo.equals("MNS")) {
					tipoDisparo = "0";
					btnMns.setBackground(Color.gray);
				}else if(tipoDisparo.equals("0")){
					tipoDisparo = "MNS";
					System.out.println("Disparo cambiado a: " + tipoDisparo);
					btnMns.setBackground(Color.GREEN);
				}
				}
			}
		});
		btnMns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		 btnMoe = new JButton("MOE");
		 btnMoe.setBackground(Color.GRAY);
		 btnMoe.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		if(btnMoe.isEnabled()){		 	
		 		if (tipoDisparo.equals("MOE")) {
					tipoDisparo = "0";
					btnMoe.setBackground(Color.gray);
				}else if(tipoDisparo.equals("0")){
					tipoDisparo = "MOE";
					btnMoe.setBackground(Color.GREEN);
				}
		 	}
		 	}
		 });
		
		 btnMt = new JButton("MT");
		 btnMt.setBackground(Color.GRAY);
		 btnMt.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		if(btnMt.isEnabled()){	
		 		if (tipoDisparo.equals("MT")) {
					tipoDisparo = "0";
					btnMt.setBackground(Color.gray);
				}else if(tipoDisparo.equals("0")){
					tipoDisparo = "Mt";
					btnMt.setBackground(Color.GREEN);
				}
		 		}
		 	}
		 });
		
		 btnR = new JButton("R");
		 btnR.setBackground(Color.GRAY);
		 btnR.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	}
		 });
		 btnR.addMouseListener(new MouseAdapter() {		 	

			@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		radar = !radar;
		 		if(radar){
		 			btnR.setBackground(Color.GREEN);
		 		}else{
		 			btnR.setBackground(Color.GRAY);
		 		}
		 	}
		 });
		
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
								lblSeleccioneLasPosiciones.setText("EMPIEZA EL JUEGO");
								btnPrueba.setVisible(true);
							}else{
								lblSeleccioneLasPosiciones.setText("SELECCIONE LA POSICION DE " + barcoToca);
							}
							
							listaPos.add(lugar.gridx);
							listaPos.add(lugar.gridy);
							//resaltarPos(lugar.gridx, lugar.gridy);
						}else if(radar){
							if(btnR.isEnabled()){}
							System.out.println("Llamada a radar 1");							
							boolean hayBarcos = false;
							hayBarcos = HundirFlota.getMiFlota().hayBarcosJugador(lugar.gridx, lugar.gridy);
							if(hayBarcos){
								System.out.println("Llamada a radar 2");
								ArrayList<Integer> barcosCerca = HundirFlota.getMiFlota().radarJugador(lugar.gridx, lugar.gridy);
								lblSeleccioneLasPosiciones.setText("Hay barcos en las siguientes posiciones: X, Y" + barcosCerca.get(0) + ", " +barcosCerca.get(1));
								 int restantes = Integer.parseInt(labelRN.getText());
								restantes = restantes - 1;
								labelTN.setText(""+restantes);
								if(restantes == 0){
									btnR.setEnabled(false);
									btnR.setBackground(Color.GRAY);
									radar = false;
								}
							}							
						}else{
							System.out.println("DISPARO EN: X= "+ lugar.gridx + " Y= " + lugar.gridy + " De tipo: " + tipoDisparo );
							int restantes = 0;
							//HundirFlota.getMiFlota().disparar(tipoDisparo, lugar.gridx, lugar.gridy);
							if(tipoDisparo.equals("MT")){
								restantes = Integer.parseInt(labelTN.getText());
								restantes = restantes - 1;
								labelTN.setText(""+restantes);
								if(restantes == 0){
									btnMt.setEnabled(false);
									btnMt.setBackground(Color.GRAY);
									tipoDisparo = "0";
								}
								//PINTO TODAS LAS CASILLAS DE FILA Y COLUMNA
							}else if(tipoDisparo.equals("MOE")){
								restantes = Integer.parseInt(labelMOEN.getText());		
								restantes = restantes - 1;
								labelMOEN.setText(""+restantes);
								if(restantes == 0){
									btnMoe.setEnabled(false);
									btnMoe.setBackground(Color.GRAY);
									tipoDisparo = "0";
								}
								
								//PINTO TODAS LAS CASILLAS DE FILA
							}else if(tipoDisparo.equals("MNS")){
								System.out.println("Entra en MNS");
								restantes = Integer.parseInt(labelMNSN.getText());		
								restantes = restantes - 1;
								System.out.println("Los restantes es= " + restantes);
								labelMNSN.setText(""+restantes);
								if(restantes == 0){
									btnMns.setEnabled(false);
									btnMns.setBackground(Color.GRAY);
									tipoDisparo = "0";
								}
								//PINTO TODAS LAS CASILLAS DE COLUMNA
							}else if(tipoDisparo.equals("M")){
								restantes = Integer.parseInt(labelMN.getText());		
								restantes = restantes - 1;
								labelMN.setText(""+restantes);
								if(restantes == 0){
									btnM.setEnabled(false);
									btnM.setBackground(Color.GRAY);
									tipoDisparo = "0";
								}
							}else if(tipoDisparo.equals("B")){
								restantes = Integer.parseInt(labelBN.getText());		
								restantes = restantes - 1;
								labelBN.setText(""+restantes);
								if(restantes == 0){
									btnB.setEnabled(false);
									btnB.setBackground(Color.GRAY);
									tipoDisparo = "0";
								}
							}
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
