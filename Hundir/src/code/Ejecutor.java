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
		for(int a = 1; a < 100 ;a++){
			for(int i = 0; i < 10 ;i++){
				System.out.print(HundirFlota.getMiFlota().listaJugadores.get(a).listaBarcos.listaBarcos.get(i).longitud);
				System.out.println(HundirFlota.getMiFlota().listaJugadores.get(a).listaBarcos.listaBarcos.get(i).lista.size());
				
			}
			System.out.println("siguiente");
		}
		
		
		

	}

}
