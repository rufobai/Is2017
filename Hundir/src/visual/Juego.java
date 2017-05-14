package visual;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code.Casilla;
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
	private int nToques = 0;
	private JPanel panelPc;

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
		ArrayList<Button> listaDes = new ArrayList<Button>();
		
		panelPc = new JPanel();
		contentPane.add(panelPc, BorderLayout.NORTH);
		GridBagLayout gbl_panelPc = new GridBagLayout();
		gbl_panelPc.columnWidths = new int[]{0};
		gbl_panelPc.rowHeights = new int[]{0};
		gbl_panelPc.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelPc.rowWeights = new double[]{Double.MIN_VALUE};
		panelPc.setLayout(gbl_panelPc);
			
		
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
				//HundirFlota.getMiFlota().asignarBarcosJugador(listaPos);
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
				if(e.getButton() == java.awt.event.MouseEvent.BUTTON3){
					boolean com = HundirFlota.getMiFlota().comprar("M");
					if(!com){
						lblSeleccioneLasPosiciones.setText("Dinero insuficiente: " + HundirFlota.getMiFlota().dineroJugador());
					}else{
						lblSeleccioneLasPosiciones.setText("Dinero restante" + HundirFlota.getMiFlota().dineroJugador());
						int n = Integer.parseInt(labelMN.getText())  + 1;
						btnM.setEnabled(true);
						labelMN.setText("" + n);
					}
					
					System.out.println("DERECHO");
				}else{
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
				
				if(e.getButton() == java.awt.event.MouseEvent.BUTTON3){
					boolean com = HundirFlota.getMiFlota().comprar("MNS");
					if(!com){
						lblSeleccioneLasPosiciones.setText("Dinero insuficiente: " + HundirFlota.getMiFlota().dineroJugador());
					}else{
						lblSeleccioneLasPosiciones.setText("Dinero restante" + HundirFlota.getMiFlota().dineroJugador());
						int n = Integer.parseInt(labelMNSN.getText())  + 1;
						btnMns.setEnabled(true);
						labelMNSN.setText("" + n);
					}
					
					System.out.println("DERECHO");
				}else{
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
		 		if(e.getButton() == java.awt.event.MouseEvent.BUTTON3){
		 			boolean com = HundirFlota.getMiFlota().comprar("MOE");
					if(!com){
						lblSeleccioneLasPosiciones.setText("Dinero insuficiente: " + HundirFlota.getMiFlota().dineroJugador());
					}else{
						lblSeleccioneLasPosiciones.setText("Dinero restante" + HundirFlota.getMiFlota().dineroJugador());
						int n = Integer.parseInt(labelMOEN.getText())  + 1;
						btnMoe.setEnabled(true);
						labelMOEN.setText("" + n);
					}
					
					System.out.println("DERECHO");
				}else{
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
		 		
		 	}
		 });
		
		 btnMt = new JButton("MT");
		 btnMt.setBackground(Color.GRAY);
		 btnMt.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		if(e.getButton() == java.awt.event.MouseEvent.BUTTON3){
		 			boolean com = HundirFlota.getMiFlota().comprar("MT");
					if(!com){
						lblSeleccioneLasPosiciones.setText("Dinero insuficiente: " + HundirFlota.getMiFlota().dineroJugador());
					}else{
						lblSeleccioneLasPosiciones.setText("Dinero restante" + HundirFlota.getMiFlota().dineroJugador());
						int n = Integer.parseInt(labelTN.getText())  + 1;
						btnMt.setEnabled(true);
						labelTN.setText("" + n);
					}
					
					System.out.println("DERECHO");
				}else{
					if(btnMt.isEnabled()){	
				 		if (tipoDisparo.equals("MT")) {
							tipoDisparo = "0";
							btnMt.setBackground(Color.gray);
						}else if(tipoDisparo.equals("0")){
							tipoDisparo = "MT";
							btnMt.setBackground(Color.GREEN);
						}
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
		 	public void mouseClicked(MouseEvent e) {
				if(e.getButton() == java.awt.event.MouseEvent.BUTTON3){
					boolean com = HundirFlota.getMiFlota().comprar("radar");
					if(!com){
						lblSeleccioneLasPosiciones.setText("Dinero insuficiente: " + HundirFlota.getMiFlota().dineroJugador());
					}else{
						lblSeleccioneLasPosiciones.setText("Dinero restante" + HundirFlota.getMiFlota().dineroJugador());
						int n = Integer.parseInt(labelRN.getText())  + 1;
						btnR.setEnabled(true);
						labelRN.setText("" + n);
					}
					
					System.out.println("DERECHO");
				}else{
					radar = !radar;
			 		if(radar){
			 			btnR.setBackground(Color.GREEN);
			 		}else{
			 			btnR.setBackground(Color.GRAY);
			 		}
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
				GridBagConstraints lugar2 = new GridBagConstraints();
				//System.out.println("Posicion: "+ i + " " + j);
				lugar2.gridx = i;
				lugar2.gridy = j;
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
					if(estado.equals("Juego")){
						if(button.isEnabled()){
							if(radar){
								if(btnR.isEnabled()){
									System.out.println("Llamada a radar 1");							
									boolean hayBarcos = false;
									hayBarcos = HundirFlota.getMiFlota().hayBarcosJugador(lugar2.gridx, lugar2.gridy);
									System.out.println("RADAR = " +hayBarcos);
									if(hayBarcos){
										System.out.println("Llamada a radar 2");
										ArrayList<Casilla> barcosCerca = HundirFlota.getMiFlota().radarJugador(lugar2.gridx, lugar2.gridy);
										lblSeleccioneLasPosiciones.setText("Hay barcos en las siguientes posiciones: X, Y" + barcosCerca.get(0).getX() + ", " +barcosCerca.get(0).getY());
										 int restantes = Integer.parseInt(labelRN.getText());
										restantes = restantes - 1;
										labelRN.setText(""+restantes);
										if(restantes == 0){
											btnR.setEnabled(false);
											btnR.setBackground(Color.GRAY);
											radar = false;
										}
									}
								}
							}else{
								
							//	if(btnR.isEnabled()){
								
								System.out.println("DISPARO EN: X= "+ lugar2.gridx + " Y= " + lugar2.gridy + " De tipo: " + tipoDisparo );
								int restantes = 0;
								//HundirFlota.getMiFlota().disparar(tipoDisparo, lugar2.gridx, lugar2.gridy);
								if(tipoDisparo.equals("MT")){
									restantes = Integer.parseInt(labelTN.getText());
									restantes = restantes - 1;
									labelTN.setText(""+restantes);
									ArrayList<Integer> agua = HundirFlota.getMiFlota().disparar(tipoDisparo, lugar2.gridx, lugar2.gridy);
									disparaElJugador(agua, tipoDisparo, lugar2.gridx, lugar2.gridy);
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
									ArrayList<Integer> agua = HundirFlota.getMiFlota().disparar(tipoDisparo, lugar2.gridx, lugar2.gridy);
									disparaElJugador(agua, tipoDisparo, lugar2.gridx, lugar2.gridy);
									if(restantes == 0){
										btnMoe.setEnabled(false);
										btnMoe.setBackground(Color.GRAY);
										tipoDisparo = "0";
									}								
													
									
									
								}else if(tipoDisparo.equals("MNS")){
									System.out.println("Entra en MNS");
									restantes = Integer.parseInt(labelMNSN.getText());		
									restantes = restantes - 1;
									System.out.println("Los restantes es= " + restantes);
									labelMNSN.setText(""+restantes);
									ArrayList<Integer> agua = HundirFlota.getMiFlota().disparar(tipoDisparo, lugar2.gridx, lugar2.gridy);
									disparaElJugador(agua, tipoDisparo, lugar2.gridx, lugar2.gridy);
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
									ArrayList<Integer> agua = HundirFlota.getMiFlota().disparar(tipoDisparo, lugar2.gridx, lugar2.gridy);
									disparaElJugador(agua, tipoDisparo, lugar2.gridx, lugar2.gridy);
									if(restantes == 0){
										btnM.setEnabled(false);
										btnM.setBackground(Color.GRAY);
										tipoDisparo = "0";
									}
									
								}else if(tipoDisparo.equals("B")){
									restantes = Integer.parseInt(labelBN.getText());		
									restantes = restantes - 1;
									labelBN.setText(""+restantes);
									ArrayList<Integer> agua = HundirFlota.getMiFlota().disparar(tipoDisparo, lugar2.gridx, lugar2.gridy);
									disparaElJugador(agua, tipoDisparo, lugar2.gridx, lugar2.gridy);
									if(restantes == 0){
										btnB.setEnabled(false);
										btnB.setBackground(Color.GRAY);
										tipoDisparo = "0";
									}									
									
								}
								//}
								dispararOrdenador();
								//System.out.println("Ha disparado en:  " + HundirFlota.getMiFlota().disparaElOrdenador());
							}
						}
						
						
					}
				}
					
				});
				GridBagConstraints lugar = new GridBagConstraints();
				//System.out.println("Posicion: "+ i + " " + j);
				lugar.gridx = i;
				lugar.gridy = j;
				panelPc.add(button, lugar);
			}
		}
		
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
							
							boolean cor = HundirFlota.getMiFlota().asignarBarcosJugador(lugar.gridx, lugar.gridy);
							if (cor){
								
								button.setEnabled(false);
								button.setBackground(Color.ORANGE);
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
									lblSeleccioneLasPosiciones.setText("Dinero restante: " + HundirFlota.getMiFlota().dineroJugador());
									btnPrueba.setVisible(true);
								}else{
									lblSeleccioneLasPosiciones.setText("SELECCIONE LA POSICION DE " + barcoToca);
								}
							}else{
								System.out.println("Lugar incorrecto");
							}
							
							
							//listaPos.add(lugar.gridx);
							//listaPos.add(lugar.gridy);
							//resaltarPos(lugar.gridx, lugar.gridy);
						}else if(radar){							
							System.out.println("RADAR EN ZONA ERRONEA");
						}else{
							
							System.out.println("DISPARO EN ZONA ERRONEA");
						}
						
					}
					
				});
				
				panelJug.add(button, lugar);
			}
		}
		
	}
	private void disparaElJugador(ArrayList<Integer> donde, String tipo, int x, int y){
		System.out.println("ENTRA EN DISJUG: " + donde);
		ArrayList<Integer> donde2 = new ArrayList<Integer>();
		
		if(donde.size() == 0){
			System.out.println("NO ACIERTA");
			for (int k = 0; k < panelPc.getComponentCount(); k++) {
				JButton b = (JButton) panelPc.getComponents()[k];
				//System.out.print("ORIGINAL X= " + b.getX() + " Y= " + b.getY());
				//b.setBackground(Color.PINK);
				donde2 = conver(b.getX(), b.getY());
				if(tipo.equals("MNS")){
					
					if(x == donde2.get(0)){
						if(b.getBackground() != Color.GREEN){
							b.setBackground(Color.BLUE);
						}
						b.setEnabled(false);
					}
				}else if(tipo.equals("MOE")){
					if(y == donde2.get(1)){
						if(b.getBackground() != Color.GREEN){
							b.setBackground(Color.BLUE);
						}
						b.setEnabled(false);
					}
				}else if(tipo.equals("MT")){
					if(x == donde2.get(0) || y == donde2.get(1)){
						if(b.getBackground() != Color.GREEN){
							b.setBackground(Color.BLUE);
						}
						b.setEnabled(false);
					}
				}
				else if(tipo.equals("M")){
					if(x == donde2.get(0) && y == donde2.get(1)){
						if(b.getBackground() != Color.GREEN){
							b.setBackground(Color.BLUE);
						}
						b.setEnabled(false);
					}
				}else if(tipo.equals("B")){
					if(x == donde2.get(0) && y == donde2.get(1)){
						if(b.getBackground() != Color.GREEN){
							b.setBackground(Color.BLUE);
						}
						b.setEnabled(false);
					}
				}
			}
		}else{
			System.out.println("ACIERTA");
			for (int i = 0; i < donde.size(); i = i + 2) {
				System.out.println("COORDENADA: " + i);
				for (int k = 0; k < panelPc.getComponentCount(); k++) {
					JButton b = (JButton) panelPc.getComponents()[k];
					//System.out.print("ORIGINAL X= " + b.getX() + " Y= " + b.getY());
					//b.setBackground(Color.PINK);
					donde2 = conver(b.getX(), b.getY());
					if(tipo.equals("MNS")){
						if(donde.get(i) == donde2.get(0) && donde.get(i+1) == donde2.get(1)){
							b.setBackground(Color.GREEN);
							b.setEnabled(false);
						}else if(x == donde2.get(0)){
							if(b.getBackground() != Color.GREEN){
								b.setBackground(Color.BLUE);
							}
							b.setEnabled(false);							
						}
					}else if(tipo.equals("M")){
						if(donde.get(i) == donde2.get(0) && donde.get(i+1) == donde2.get(1)){
							b.setBackground(Color.GREEN);
							b.setEnabled(false);
						}
					}else if(tipo.equals("MOE")){
						if(donde.get(i) == donde2.get(0) && donde.get(i+1) == donde2.get(1)){
							b.setBackground(Color.GREEN);
						}else if(y == donde2.get(1)){
							if(b.getBackground() != Color.GREEN){
								b.setBackground(Color.BLUE);
							}
							b.setEnabled(false);
						}
					}else if(tipo.equals("MT")){
						System.out.println("TOTAL-->X1=" + donde.get(i) +" X2=" + donde2.get(0));
						System.out.println("TOTAL-->Y1=" + donde.get(i+1) +" Y2=" + donde2.get(1));
						if(donde.get(i) == donde2.get(0) && donde.get(i+1) == donde2.get(1)){
							b.setBackground(Color.GREEN);
							b.setEnabled(false);
						}else if(x == donde2.get(0) || y == donde2.get(1)){
							if(b.getBackground() != Color.GREEN){
								b.setBackground(Color.BLUE);
							}
							b.setEnabled(false);
						}
					}else if(tipo.equals("B")){
						if(donde.get(i) == donde2.get(0) && donde.get(i+1) == donde2.get(1)){
							b.setBackground(Color.GREEN);
							b.setEnabled(false);
						}
					}
				}	
			}
		}
		
		
		
	}
	private void dispararOrdenador(){
		ArrayList<Integer> donde = HundirFlota.getMiFlota().disparaElOrdenador();
		System.out.println("NUMERO DE CASILLAS= " + donde.size());
		System.out.println("Ha disparado en:  " + donde);
		ArrayList<Integer> donde2 = new ArrayList<Integer>();
		for (int i = 0; i < donde.size(); i = i + 2) {
			for (int k = 0; k < panelJug.getComponentCount(); k++) {
				JButton b = (JButton) panelJug.getComponents()[k];
				//System.out.print("ORIGINAL X= " + b.getX() + " Y= " + b.getY());
				//b.setBackground(Color.PINK);
				donde2 = conver(b.getX(), b.getY());
				if(donde.get(i) == donde2.get(0) && donde.get(i+1) == donde2.get(1)){
					//System.out.println("La comparacion es X= " +donde.get(0) + " == " + donde2.get(0));
					//System.out.println("La comparacion es Y= " +donde.get(1) + " == " + donde2.get(1));
					b.setBackground(Color.RED);
				}
			}	
		}
		
		
	}
	
	private ArrayList<Integer> conver(int x, int y){
		
		ArrayList<Integer> d =  new ArrayList<Integer>();
		
		if(x == 1){
			x = 0;
		}else if(x == 44){
			x = 1;
		}else{
			x = (x - 3)/41;
		}
		if(y > 1){
			y = y /26;
		}
		d.add(x);
		d.add(y);
		//System.out.println("-----DESPUES: X=" + x + "Y= " + y);
		return d;
		
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
