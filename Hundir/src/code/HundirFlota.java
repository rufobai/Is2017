package code;

import java.util.ArrayList;
import java.util.Iterator;



public class HundirFlota {
	
	public ArrayList<Jugador> listaJugadores;
	private static HundirFlota miHundirFlota = new HundirFlota();
	
	private HundirFlota(){
		listaJugadores = new ArrayList<Jugador>();
	}
	
	
	public void empezarPartida(){
		listaJugadores.add(new Jugador(false));
		listaJugadores.add(new Jugador(true));
	}
	
	public static HundirFlota getMiFlota(){
		return miHundirFlota;
	}


	public boolean asignarBarcosJugador(int x, int y) {
		boolean asignado=false;
		
		asignado=listaJugadores.get(0).anadirBarcoJug(x, y);
		
		
		
		return asignado;
		
		
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
	
	public ArrayList<Casilla> radarJugador(int x, int y){
		ArrayList<Casilla> r=new ArrayList<Casilla>();
		if(listaJugadores.get(0).esOrdenador()== true){
			r=listaJugadores.get(1).radar(x, y);
		}else{
			r=listaJugadores.get(0).radar(x, y);
		}
		
		return r;
	}
	public ArrayList<Casilla> radarOrdenador(int x, int y){
		ArrayList<Casilla> r=new ArrayList<Casilla>();
		if(listaJugadores.get(0).esOrdenador()!= true){
			r=listaJugadores.get(1).radar(x, y);
		}else{
			r=listaJugadores.get(0).radar(x, y);
		}
		
		return r;
	}
	public void asignarTaleros(){
		Tablero t1;
		t1=listaJugadores.get(0).getTablero();
		listaJugadores.get(1).darTablero(t1);
		
		t1=listaJugadores.get(1).getTablero();
		listaJugadores.get(0).darTablero(t1);
	}
	
	public ArrayList<Integer> disparar(String tipo, int x, int y){
		
		
		System.out.println("--------------EL METODO DISPARAR------------");
		for(int i = 0; i < 10 ;i++){
			System.out.print(HundirFlota.getMiFlota().listaJugadores.get(1).listaBarcos.listaBarcos.get(i).longitud);
			System.out.println(HundirFlota.getMiFlota().listaJugadores.get(1).listaBarcos.listaBarcos.get(i).lista.size());
		}
		
		
		
		ArrayList<Integer> a=new ArrayList<Integer>();
		ArrayList<Casilla> c=listaJugadores.get(1).disparar(tipo, x, y);
		Iterator<Casilla> itr=c.iterator();
		Casilla casi;
		
		if(c.size() == 0){
			asignarTaleros();
			
		}else{
			while(itr.hasNext()){
				casi=itr.next();
				a.add(casi.getX());
				a.add(casi.getY());
			}
			asignarTaleros();
			
		}
		return a;
	}
	
	public void disparaElOrdenador(){
		
		ArrayList<Integer> a=listaJugadores.get(1).dispararOrdenador();
		String tipo=listaJugadores.get(1).tipoDisparo();
		
		listaJugadores.get(0).disparar(tipo, a.get(0), a.get(1));
		asignarTaleros();
		
	}
	
	
}
