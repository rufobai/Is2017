package code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Barco {
	
	private int longitud;
	private boolean escudo;
	private String estado;
	private int toques;
	private ArrayList<ArrayList<Integer>> posicion=new ArrayList<ArrayList<Integer>>();
	private ArrayList<Casilla> pos;
	
	public Barco(int length){
		toques=0;
		longitud = length;
		escudo = false;
		
	}
	public void darPosicion(ArrayList<ArrayList<Integer>> p){
		posicion=p;
	}
	public void reparar(int x, int y){
		
	}
	
	public void darEspacio(int pos1, int pos2, int direccion){
		int p1=pos1;
		int p2=pos2;
		
		ArrayList<Casilla> lis=new ArrayList<Casilla>();
		Iterator<Casilla> it= lis.iterator();
	}
	
	
	
	
	
	
	public ArrayList<ArrayList<Integer>> saberPosicion(){
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
	public boolean esta(int pos1, int pos2){
		boolean esta=false;
		ArrayList<Integer> lis;
		Iterator<ArrayList<Integer>> it=posicion.iterator();
		Iterator<Integer> iter;
		while(it.hasNext() || esta){
			lis=it.next();
			iter=lis.iterator();
			if(iter.next()==pos1 && iter.next()==pos2){
				esta=true;
			}
		}
		return esta;
	}
	
	public ArrayList<Integer> devolverPosicion(){
		ArrayList<Integer> lista=new ArrayList<Integer>();
		
	
		ArrayList<Integer> lis;
		Iterator<ArrayList<Integer>> it=posicion.iterator();
		while(it.hasNext()){
			lis=it.next();
			lista.addAll(lis);
			
		}
		return lista;
	}

}
