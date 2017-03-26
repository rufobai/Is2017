package code;

import java.util.ArrayList;
import java.util.Iterator;

public class Tablero {

	private ArrayList<ArrayList<Integer>> tablero;
	private int ancho;
	private int alto;
	
	public Tablero(){
		ancho=10;
		alto=10;
	}
	
	
	public void inicializar(){
	
		int a=10;
		ArrayList<Integer> lis;
		Iterator<ArrayList<Integer>> it=tablero.iterator();
		while(it.hasNext()){
			lis=it.next();
			for (int i=0;i<ancho;i++){
				lis.add(a);
				a--;
			}
			a=10;			
			
		}
		
	}
	public boolean haySitio(int cuantos, int direccion){
		
		
		
		return true;
	}
}
