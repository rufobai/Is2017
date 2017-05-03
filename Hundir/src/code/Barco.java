package code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Barco {
	
	private int longitud;
	private boolean escudo;
	private String estado;
	private int toques;
	private ArrayList<Casilla> lista;
	
	public Barco(int length, ArrayList<Casilla> l){
		toques=0;
		longitud = length;
		escudo = false;
		lista=l;
	}
	
	public void reparar(int x, int y){
		Casilla m=buscar(x, y);
		m.sanar();
	}

	public ArrayList<Casilla> getLista(){
		return lista;
	}
	public boolean estadoEscudo(){
		return escudo;
	}
	public void activarEscudo(){
		escudo=true;
		int a=0;
		while(a<=longitud-1){
			lista.get(a).darEscudo();
		}
		
	}
	public void anadirToque(int x, int y){
		if(toques!=longitud){
			Casilla m=buscar(x,y);
			if(m.getEscudo()!=0){
				m.quitarEscudo();
			}else{
				m.darGolpe();
				toques=toques +1;
			}
		}
	}
	public void quitarEscudo(){
		
		int a=0;
		while(a<=longitud-1){
			lista.get(a).quitarEscudo();
		}
		if(lista.get(0).getEscudo()==0){
			escudo=false;
		}
	}
	public boolean destruido(){
		if(toques==longitud){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean esta(int x, int y){
		int a=0;
		boolean esta=false;
		while(a<=longitud-1 || esta){
			
			if(lista.get(a).getX()==x && lista.get(a).getY()==y){
				esta=true;
			}
			a++;
		}
		
		return esta;
	}
	public Casilla buscar(int x, int y){
		int a=0;
		boolean esta=false;
		Casilla c=null;
		while(a<=longitud-1 || esta){
			
			if(lista.get(a).getX()==x && lista.get(a).getY()==y){
				esta=true;
				c=lista.get(a);
			}
			a++;
		}
		return c;
	}
	
	
	public void destruirBarco(int x, int y){
		if(toques!=longitud){
			int a=0;
			Casilla m=buscar(x,y);
			if(m.getEscudo()==0){
				while(a<=longitud-1 ){
					m=lista.get(a);
					m.darGolpe();
				}
				toques=longitud;
			}else{
				quitarEscudo();
			}
		}
		
	}

}
