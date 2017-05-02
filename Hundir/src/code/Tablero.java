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
		tablero=new ArrayList<ArrayList<Casilla>>();
		inicializar();
	}
	
	public ArrayList<ArrayList<Casilla>> getTablero(){
		return tablero;
	}
	
	public void inicializar(){
	
		
		for(int x=0;x<=9;x++){
			tablero.add(x, new ArrayList<Casilla>());
			for(int y=0;y<=9;y++){
				tablero.get(x).add(y, new Casilla());
			}
		}
		
	}
	
	public boolean haySitio(int cuantos, int direccion,int x, int y){		
		try{
			boolean esta=false;
			int p1=x;
			int p2=y;
			int z=0;
			System.out.println(2);
			if(direccion==1){
				System.out.println(2);
					while(z<=cuantos-1 || esta!=false){
						if(tablero.get(x).get(y).getEstado()== true){
							esta=true;
						}
						z++;
					p2++;
				}
				
			}else if(direccion==2){
				while(z<=cuantos-1 || esta!=false){
					if(tablero.get(x).get(y).getEstado()== true){
						esta=true;
					}
					z++;
					p1++;
				}
			}else if(direccion==3){
				while(z<=cuantos-1 || esta!=false){
					if(tablero.get(x).get(y).getEstado()== true){
						esta=true;
					}
					z++;
					p2=p2-1;
				}
			}else{
				while(z<=cuantos-1 || esta!=false){
					if(tablero.get(x).get(y).getEstado()== true){
						esta=true;
					}
					z++;
					p1=p2-1;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	private int direccion(){
		return (int) (Math.random()*4+1);
	}
	
	public void anadirBarco(int length){
		try{
		int x=(int) (Math.random()*9+1);
		System.out.println("coordenadada" + x);
		int y=(int) (Math.random()*9+1);
		System.out.println("coordenadada" + y);
		int d=direccion();
		System.out.println(1);
		/*while(haySitio(length, d,x,y)==false){
			System.out.println(2);
			d=direccion();
		}*/
		
		int p1=x;
		int p2=y;
		if(d==1){
			for(int z=0;z<=length-1;z++){

				Casilla m=tablero.get(p1).get(p2);
				System.out.println("esta en la pos" + p1 +p2);
				m.cambiarEstado();
				p2++;
			}
			
		}else if(d==2){
			for(int z=0;z<=length-1;z++){

				Casilla m=tablero.get(p1).get(p2);
				System.out.println("esta en la pos" + p1 +p2);
				m.cambiarEstado();
				p1++;
			}
		}else if(d==3){
			for(int z=0;z<=length-1;z++){

				Casilla m=tablero.get(p1).get(p2);
				System.out.println("esta en la pos" + p1 +p2);
				m.cambiarEstado();
				p2=p2-1;
			}
		}else{
			for(int z=0;z<=length-1;z++){
				Casilla m=tablero.get(p1).get(p2);
				System.out.println("esta en la pos" + p1 +p2);
				m.cambiarEstado();
				p1=p1-1;
			}
		}
		}catch(Exception e){
			this.anadirBarco(length);
		}
		
	}
	
	public void imprimir(){
		
		
		for(int z=0;z<=9;z++){
			for(int x=0;x<=9;x++){
				Casilla m=tablero.get(z).get(x);
				System.out.println(m.getEstado());
			}
		}
	}
	
}
