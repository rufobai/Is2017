package code;

import visual.Base;
import visual.Juego;

public class Ejecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Inicio de Hundir");
		HundirFlota.getMiFlota().empezarPartida();
		Juego juego = new Juego();
		juego.setVisible(true);
		System.out.println("  ");
		System.out.println("  ");
		System.out.println("  ");
		System.out.println("  ");
		

	}

}
