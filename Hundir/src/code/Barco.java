package code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Barco {
	
	private int longitud;
	public int getLongitud() {
		return longitud;
	}


	private boolean escudo;
	private String estado;
	private int toques;
	public ArrayList<Casilla> lista;
	
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
	
	
	public boolean anadirPosicion(int x, int y){
		boolean es=false;
		Casilla c,c1,c2;
		Iterator<Casilla> itr=lista.iterator();
		if(lista.size()==1){
			c=itr.next();
			es=posible(x, y, c);
		}else if(lista.size()==2){
			c=itr.next();
			c1=itr.next();
			if(c.getX()==c1.getX() && c.getX()==x){
				if(y==c.getY()-1 || y==c.getY()+1|| y==c1.getY()+1 || y==c1.getY()-1){
					es=true;
					
				}
			}else if(c.getY()==c1.getY() && c.getY()==y){
				if(x==c.getX()-1 || x==c1.getX()+1 || x==c.getX()+1 || x==c1.getX()-1){
					es=true;
				}
			}
		}else if(lista.size()==3){
			c=itr.next();
			c1=itr.next();
			c2=itr.next();
			if(c.getX()==c1.getX() && c.getX()==x){
				if(y==c.getY()-1 || y==c.getY()+1 || y==c2.getY()+1 || y==c2.getY()-1){
					es=true;
				}
			}else if(c.getY()==c1.getY() && c.getY()==y){
				if(x==c.getX()-1 || x==c.getX()+1 || x==c2.getX()+1 || x==c2.getX()-1){
					es=true;
				}
			}
		}
		return es;
	}
	public boolean comprobar(int x, int y){
		boolean es=false;
		
		for (int i = 0; i < lista.size()-1; i++) {
			if(x!=lista.get(i).getX()+1 || x!=lista.get(i).getX()-1){
				
			}
		}
		
		
		return es;
		
	}
	
	public boolean posible(int x, int y, Casilla c){
		boolean es=false;
		if(c.getX()==x){
			if(c.getY()-1==y || c.getY()+1==y){
				es=true;
			}
		}else if(c.getY()==y){
			if(c.getX()-1==x || c.getX()+1==x){
				es=true;
			}
		}
		
		return es;
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
		while(a<longitud && !esta){
			
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
		while(a<=longitud-1 && !esta){
			
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
	
	public boolean sepuede(int x, int y){
		boolean es=false;
		
			for (int i = 0; i < lista.size()-1; i++) {
				if(lista.get(i).getX()==x && lista.get(lista.size()-1).getY()+4<=y){
					System.out.println("nose");
					es=true;
				}else if(lista.get(i).getX()==x && lista.get(1).getY()-4>=y){
					System.out.println("nose2");
					es=true;
				}else if(lista.get(i).getY()<=y && lista.get(i).getX()+4<=x){
					System.out.println("aqui si");
					
					es=true;
				}else if(lista.get(i).getY()>=y && lista.get(i).getX()-4>=x){
					System.out.println("aqui no");
					es=true;
				}else if(lista.get(i).getY()+4<=y && lista.get(i).getX()+2<=x || lista.get(i).getY()+4<=y && lista.get(i).getX()!=x ){
					es=true;
				}
				
			}
		return es;
	}
	
	public boolean sepuede2(int x, int y){
		boolean es=false;
		
			for (int i = 0; i < lista.size()-1; i++) {
				if(lista.get(i).getX()==x && lista.get(i).getY()+3<=y){
					es=true;
				}else if(lista.get(i).getX()==x && lista.get(i).getY()-3>=y){
					es=true;
				}else if(lista.get(i).getY()==y && lista.get(i).getX()+3<=x){
					es=true;
				}else if(lista.get(i).getY()==y && lista.get(i).getX()-3>=x){
					es=true;
				}
			}
		return es;
	}
	
	public boolean sepuede3(int x, int y){
		boolean es=false;
		
			for (int i = 0; i < lista.size()-1; i++) {
				if(lista.get(i).getX()==x && lista.get(i).getY()+2<=y){
					es=true;
				}else if(lista.get(i).getX()==x && lista.get(i).getY()-2>=y){
					es=true;
				}else if(lista.get(i).getY()==y && lista.get(i).getX()+2<=x){
					es=true;
				}else if(lista.get(i).getY()==y && lista.get(i).getX()-2>=x){
					es=true;
				}
			}
		return es;
	}
	

}
