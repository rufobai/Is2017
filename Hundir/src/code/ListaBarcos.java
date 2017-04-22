package code;

import java.util.ArrayList;
import java.util.Iterator;


public class ListaBarcos {

	private ArrayList<Barco> listaBarcos;
	
	
	public ListaBarcos(){
		listaBarcos=new ArrayList<Barco>();
	}
	
	public boolean activarEscudo( int x,  int y){
		Barco a;
		boolean esta=false;
		Iterator<Barco> it=listaBarcos.iterator();
		while(it.hasNext() || esta==true){
			a=it.next();
			if(a.esta(x, y)){
				a.activarEscudo();
				esta=true;
			}
		}
		return esta;
	}
	public boolean existeBarco(int x,  int y){
		Barco a;
		boolean esta=false;		
		Iterator<Barco> it=listaBarcos.iterator();
		while(it.hasNext() || esta==true){
			a=it.next();			
			if(a.esta(x, y)){
				esta=true;
			}
		}
		return esta;
	}
	public Barco buscarBarco(int x,  int y){
		Barco a=null;
		boolean esta=false;		
		Iterator<Barco> it=listaBarcos.iterator();
		while(it.hasNext() || esta==true){
			a=it.next();
			if(a.esta(x, y)){
				esta=true;
			}
		}
		return a;		
	}
	
	public void anadirBarco(Barco b){
		listaBarcos.add(b);
	}
	
	public ArrayList<Integer> disparoNormal(int x, int y){
		
		Barco a=null;
		boolean esta=false;	
		ArrayList<Integer> lista= new ArrayList<Integer>();
		Iterator<Barco> it=listaBarcos.iterator();
		while(it.hasNext() || esta==true){
			a=it.next();
			if(a.esta(x, y)){
				a.anadirToque();
				lista.add(x);
				lista.add(y);
				esta=true;
			}
		}
		if(esta==false){
			lista.add(0);
		}
		return lista;	
		
	}
	public void disparoMisil(int x, int y){
		
	}
	public void disparoMOE(int x, int y){
		
	}
	public void disparoMNS(int x, int y){
		
	}
	public void disparoMT(int x, int y){
		
	}
}
