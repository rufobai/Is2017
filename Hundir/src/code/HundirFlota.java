package code;

import java.util.ArrayList;

public class HundirFlota {
	
	private ArrayList<Jugador> listaJugadores;
	private static HundirFlota miHundirFlota = new HundirFlota();
	
	private HundirFlota(){
		listaJugadores = new ArrayList<Jugador>();
	}
	
	
	public void empezarPartida(){
		listaJugadores.add(new Jugador(false));
		//listaJugadores.add(new Jugador(true));
	}
	
	public static HundirFlota getMiFlota(){
		return miHundirFlota;
	}


	public void asignarBarcosJugador(ArrayList<Integer> listaPos) {
		
		System.out.println("Pendiente de asignar barcos");
		
		ArrayList<ArrayList<Integer>> listaTemp = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> listaTemp2 = new ArrayList<Integer>();
		listaTemp2.add(listaPos.get(0));
		listaTemp2.add(listaPos.get(1));
		listaTemp.add(listaTemp2);
		listaTemp2.add(listaPos.get(0));
		listaTemp2.add(listaPos.get(0));
		
		//listaTemp.add(listaPos.get(0));
		listaJugadores.get(0).anadirBarco(listaTemp, 4);
		
	}


	public Integer[] obtenerArmamento() {
		// TODO Auto-generated method stub
		
		Integer arma[] = new Integer[6];
		arma[0]= listaJugadores.get(0).getRadar();
		arma[1]= listaJugadores.get(0).getBomba();
		arma[2]= listaJugadores.get(0).getMisiles();
		arma[3]= listaJugadores.get(0).getMisilNS();
		arma[4]= listaJugadores.get(0).getMisilOE();
		arma[5]= listaJugadores.get(0).getMisilAB();
		
		return arma;
	}
	public boolean hayBarcosJugador(int x, int y){
		boolean hay=false;
		if(listaJugadores.get(0).esOrdenador()== true){
			hay=listaJugadores.get(1).hayBarcos(x, y);
		}else{
			hay=listaJugadores.get(0).hayBarcos(x, y);
		}
		return hay;
	}
	public boolean hayBarcosOrdenador(int x, int y){
		
		boolean hay=false;
		if(listaJugadores.get(0).esOrdenador()!= true){
			hay=listaJugadores.get(1).hayBarcos(x, y);
		}else{
			hay=listaJugadores.get(0).hayBarcos(x, y);
		}
		return hay;
	}
	
	public ArrayList<Integer> radarJugador(int x, int y){
		ArrayList<Integer> r=new ArrayList<Integer>();
		if(listaJugadores.get(0).esOrdenador()== true){
			r=listaJugadores.get(1).radar(x, y);
		}else{
			r=listaJugadores.get(0).radar(x, y);
		}
		
		return r;
	}
	public ArrayList<Integer> radarOrdenador(int x, int y){
		ArrayList<Integer> r=new ArrayList<Integer>();
		if(listaJugadores.get(0).esOrdenador()!= true){
			r=listaJugadores.get(1).radar(x, y);
		}else{
			r=listaJugadores.get(0).radar(x, y);
		}
		
		return r;
	}
	
	public void disparar(String tipo, int x, int y){
		listaJugadores.get(0).disparar(tipo, x, y);
	}
	
	public void disparaElOrdenador(String tipo, int x, int y){
		
	}
	
	
}
