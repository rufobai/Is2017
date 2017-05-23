package code;

import java.util.ArrayList;
import java.util.Iterator;


public class ListaBarcos {

	public ArrayList<Barco> listaBarcos;
	
	
	public ListaBarcos(){
		listaBarcos=new ArrayList<Barco>();
	}
	public ArrayList<Barco> getLista(){
		return listaBarcos;
	}
	
	public boolean activarEscudo( int x,  int y){
		Barco a;
		boolean esta=false;
		Iterator<Barco> it=listaBarcos.iterator();
		while(it.hasNext() && !esta){
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
		while(it.hasNext() && !esta){
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
		while(it.hasNext() && !esta){
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
	
	
	public ArrayList<Casilla> disparoNormal(int x, int y){
		Barco a=null;
		boolean esta=false;	
		ArrayList<Casilla> lista= new ArrayList<Casilla>();
		Iterator<Barco> it=listaBarcos.iterator();
		while(it.hasNext() && !esta){
			a=it.next();
			if(a.esta(x, y)){
				a.anadirToque(x,y);
				lista.add(a.buscar(x, y));
				esta=true;
			}
		}
		
		return lista;	
		
	}
	public ArrayList<Casilla> disparoMisil(int x, int y){
		
		Barco a=null;
		boolean esta=false;	
		ArrayList<Casilla> lista= new ArrayList<Casilla>();
		Iterator<Barco> it=listaBarcos.iterator();
		while(it.hasNext() && !esta){
			a=it.next();
			if(a.esta(x, y)){
				a.destruirBarco(x, y);
				lista=a.getLista();
				esta=true;
			}
		}
		return lista;	
	}
	public ArrayList<Integer> disparoMOE(int x, int y){
		
		ArrayList<Integer> lista= new ArrayList<Integer>();
		for(int x1=0;x1<10;x1++){
			lista.add(x1);
			lista.add(y);
		}
		return lista;	
	}
	public ArrayList<Casilla> disparoMOEOrdenador(int x, int y){
		
		ArrayList<Casilla> lista= new ArrayList<Casilla>();
		for(int x1=0;x1<9;x1++){
			lista.addAll(disparoNormal(x1, y));
		}
		return lista;	
	}
	public ArrayList<Integer> disparoMNS(int x, int y){
		ArrayList<Integer> lista= new ArrayList<Integer>();
		for(int y1=0;y1<10;y1++){
			lista.add(x);
			lista.add(y1);
			
			
		}
		return lista;
	}
	public ArrayList<Casilla> disparoMNSOrdenador(int x, int y){
		ArrayList<Casilla> lista= new ArrayList<Casilla>();
		for(int y1=0;y1<9;y1++){
			
			lista.addAll(disparoNormal(x, y1));
			System.out.println("Ennnnnntra aqui"+lista.size());
		}
		return lista;
	}
	/*public ArrayList<Casilla> disparoMT(int x, int y){
		ArrayList<Casilla> lista= new ArrayList<Casilla>();
		lista.addAll(disparoMOE(x, y));
		lista.addAll(disparoMNS(x, y));
		return lista;
	}*/
	/*public ArrayList<Casilla> disparoMTOrdenador(int x, int y){
		ArrayList<Casilla> lista= new ArrayList<Casilla>();
		lista.addAll(disparoMOE(x, y));
		lista.addAll(disparoMNS(x, y));
		return lista;
	}*/
	public void reparar(int x, int y){
		
		Barco a=null;
		boolean esta=false;		
		Iterator<Barco> it=listaBarcos.iterator();
		while(it.hasNext() && !esta){
			a=it.next();
			if(a.esta(x, y)){
				a.reparar(x, y);
				esta=true;
			}
		}
	}
}
