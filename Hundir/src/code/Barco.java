package code;

import java.util.ArrayList;

public class Barco {
	
	private int longitud;
	private boolean escudo;
	private String estado;
	private int toques;
	private ArrayList<Integer> posicion;
	
	
	public Barco(int length, int pos1, int pos2){
		toques=0;
		longitud = length;
		posicion.add(pos1);
		posicion.add(pos2);
		escudo = false;
	}
	public ArrayList<Integer> saberPosicion(){
		return posicion;
	}
	public boolean estadoEscudo(){
		return escudo;
	}
	public void activarEscudo(){
		escudo=true;
	}
	public void anadirToque(){
		toques=toques +1;
	}
	public boolean destruido(){
		if(toques==longitud){
			return true;
		}else{
			return false;
		}
	}

}
