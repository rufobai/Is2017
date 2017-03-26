package code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Barco {
	
	private int longitud;
	private boolean escudo;
	private String estado;
	private int toques;
	private ArrayList<ArrayList<Integer>> posicion;
	
	
	public Barco(int length, int pos1, int pos2, int direccion){
		toques=0;
		longitud = length;
		escudo = false;
		posicion=new ArrayList<ArrayList<Integer>>();
		asignarEspacio(pos1, pos2, direccion);
		
	}
	private void asignarEspacio(int pos1, int pos2, int direccion){
		int p1=pos1;
		int p2=pos2;
		Iterator<ArrayList<Integer>> it=posicion.iterator();
		ArrayList<Integer> lis;
		if(direccion==1){
			for(int x=1;x<=longitud;x++){
				posicion.add(new ArrayList<Integer>());
				lis=it.next();
				lis.add(p1);
				lis.add(p2);
				p2++;
			}
			
		}else if(direccion==2){
			for(int x=1;x<=longitud;x++){
				posicion.add(new ArrayList<Integer>());
				lis=it.next();
				lis.add(p1);
				lis.add(p2);
				p1++;
			}
		}else if(direccion==3){
			for(int x=1;x<=longitud;x++){
				posicion.add(new ArrayList<Integer>());
				lis=it.next();
				lis.add(p1);
				lis.add(p2);
				p2--;
			}
		}else{
			for(int x=1;x<=longitud;x++){
				posicion.add(new ArrayList<Integer>());
				lis=it.next();
				lis.add(p1);
				lis.add(p2);
				p1--;
			}
		}
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

}
