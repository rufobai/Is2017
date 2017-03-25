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
		ArrayList<Integer> lis;
		Iterator<Integer> iter;
		Iterator<Barco> it=listaBarcos.iterator();
		while(it.hasNext() || esta==true){
			a=it.next();
			lis=a.saberPosicion();
			iter=lis.iterator();
			if(iter.next()==x && iter.next()==y){
				a.activarEscudo();
				esta=true;
			}
		}
		return esta;
	}
}
