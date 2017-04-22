package code;

import java.util.ArrayList;
import java.util.Iterator;

public class Tablero {

	private ArrayList<ArrayList<Casilla>> tablero;
	private int ancho;
	private int alto;
	
	public Tablero(){
		ancho=10;
		alto=10;
	}
	
	
	public void inicializar(){
	
		int a=10;
		ArrayList<Casilla> lis;
		Iterator<ArrayList<Casilla>> it=tablero.iterator();
		while(it.hasNext()){
			lis=it.next();
			for (int i=0;i<ancho;i++){
				lis.add(new Casilla());
				a--;
			}
			a=10;			
			
		}
		
	}
	public boolean haySitio(int cuantos, int direccion){		
		
		return true;
	}
}
