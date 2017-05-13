package code;

import java.util.ArrayList;
import java.util.Random;

public class Jugador {

	private ListaBarcos listaBarcos;
	private Armamento armamentoJug;
	private boolean esOrdenador;
	private Tablero t1;
	private Tablero t2;
	private double dinero;
	private int cont;
	private Casilla ultimoDisparo;
	
	public Jugador(boolean es){
		esOrdenador=es;
		ultimoDisparo=null;
		armamentoJug=new Armamento();
		dinero=100;
		t1=new Tablero();
		t2=new Tablero();
		listaBarcos=new ListaBarcos();
		if(esOrdenador== true){
			asignarBarcosOrdenador();
		}
		cont=0;
		
		
		
	}
	public boolean esOrdenador(){
		return esOrdenador;
	}
	public Tablero getTablero(){
		return t1;
	}
	public void darTablero(Tablero t){
		t2=t;
	}
	
	public boolean activarEscudo(int x, int y){
		return listaBarcos.activarEscudo(x, y);
	}
	public ListaBarcos getLista(){
		return listaBarcos;
	}
	public void anadirBarcoALista(Barco b){
		listaBarcos.anadirBarco(b);
	}
	
	private int direccion(){
		return (int) (Math.random()*4+1);
	}
	/*public void anadirBarco(ArrayList<ArrayList<Integer>> list, int length){
		Barco b=new Barco(length);
		b.darPosicion(list);
	}*/
	public void reparar(int x, int y){
		dinero=dinero-20;
		listaBarcos.reparar(x, y);
	}
	public boolean anadirBarcoJug(int x, int y){
		boolean asignado=false;
		Casilla m;
		ArrayList<Casilla> l=new ArrayList<Casilla>();
		if(cont==0    ){
			m=t1.asignarBarco(x, y);
			l.add(m);
			anadirBarcoALista(new Barco(4, l));
			cont=cont+1;
			asignado=true;
		}else if(cont==4|| cont==7){
			m=t1.asignarBarco(x, y);
			l.add(m);
			anadirBarcoALista(new Barco(3, l));
			cont=cont+1;
			asignado=true;
		}else if(cont==10 || cont==12 || cont==14){
			m=t1.asignarBarco(x, y);
			l.add(m);
			anadirBarcoALista(new Barco(2, l));
			cont=cont+1;
			asignado=true;
		}else if( cont==16 || cont==17 || cont ==18 || cont==19){
			m=t1.asignarBarco(x, y);
			l.add(m);
			anadirBarcoALista(new Barco(1, l));
			cont=cont+1;
			asignado=true;
		}else if(listaBarcos.getLista().get(listaBarcos.getLista().size()-1).anadirPosicion(x, y)==true){
			m=t1.asignarBarco(x, y);
			listaBarcos.getLista().get(listaBarcos.getLista().size()-1).getLista().add(m);
			asignado=true;
			cont=cont+1;
		}
		return asignado;
	}
	
	private void asignarBarcosOrdenador(){
		ArrayList<Casilla> e;
		
		e=t1.anadirBarco(4);
		anadirBarcoALista(new Barco(4, e));
		e=t1.anadirBarco(3);
		anadirBarcoALista(new Barco(3, e));
		e=t1.anadirBarco(3);
		anadirBarcoALista(new Barco(3, e));
		e=t1.anadirBarco(2);
		anadirBarcoALista(new Barco(2, e));
		e=t1.anadirBarco(2);
		anadirBarcoALista(new Barco(2, e));
		e=t1.anadirBarco(2);
		anadirBarcoALista(new Barco(2, e));
		e=t1.anadirBarco(1);
		anadirBarcoALista(new Barco(1, e));
		e=t1.anadirBarco(1);
		anadirBarcoALista(new Barco(1, e));
		e=t1.anadirBarco(1);
		anadirBarcoALista(new Barco(1, e));
		e=t1.anadirBarco(1);
		anadirBarcoALista(new Barco(1, e));
		
	}
	

	public Integer getRadar() {
		// TODO Auto-generated method stub
		return armamentoJug.getRadar();
	}

	public Integer getBomba() {
		// TODO Auto-generated method stub
		return armamentoJug.getBombas();
	}

	public Integer getMisiles() {
		// TODO Auto-generated method stub
		return armamentoJug.getMisiles();
	}

	public Integer getMisilNS() {
		// TODO Auto-generated method stub
		return armamentoJug.getMisilNS();
	}

	public Integer getMisilOE() {
		// TODO Auto-generated method stub
		return armamentoJug.getMisilOE();
	}

	public Integer getMisilAB() {
		// TODO Auto-generated method stub
		return armamentoJug.getMisilAB();
	}
	public boolean hayBarcos(int x, int y){
		boolean hay=false;
		int x1=x-1;
		int y1=y-1;
		
		while(x1!=x+1||hay){
			while(y1!=y+1||hay){
				hay=listaBarcos.existeBarco(x1, y1);
				y1++;;
			}
			x1++;
		}
		return hay;
	}
	public ArrayList<Casilla> radar(int x, int y){
		
		armamentoJug.lanzarRadar();
		ArrayList<Casilla> r=t2.radar(x, y);
		return r;
	}
	
	public ArrayList<Casilla> disparar(String tipo, int x, int y){
		ArrayList<Casilla> m=new ArrayList<Casilla>();
		System.out.println("dispararJugador");
		if(tipo=="B" && armamentoJug.getBombas()!=0){
			m=listaBarcos.disparoNormal(x, y);
			armamentoJug.lanzarBomba();
		}else if(tipo=="M" && armamentoJug.getMisiles()!=0){
			m=listaBarcos.disparoMisil(x, y);
			armamentoJug.lanzarMisil();
		}else if(tipo=="MOE" && armamentoJug.getMisilOE()!=0){
			m=listaBarcos.disparoMOE(x, y);
			armamentoJug.lanzarMisilOE();
		}else if(tipo=="MNS" && armamentoJug.getMisilNS()!=0){
			m=listaBarcos.disparoMNS(x, y);
			armamentoJug.lanzarMisilNS();
		}else{
			m=listaBarcos.disparoMT(x, y);
			armamentoJug.lanzarMisilAB();
		}
		return m;
	}
	
	public ArrayList<Integer> dispararOrdenador(){
		ArrayList<Integer> m=new ArrayList<Integer>();
		
		if(ultimoDisparo==null || ultimoDisparo.getEstado()==false){
			int a=(int) (Math.random()*9+1);
			int b=(int) (Math.random()*9+1);
			m.add(a);
			m.add(b);
			ultimoDisparo=t2.getTablero().get(a).get(b);
		}else{
			Casilla c=t2.noDanada(ultimoDisparo);
			m.add(c.getX());
			m.add(c.getY());
			ultimoDisparo=c;
		}
		
		
		return m;
		
	}
	
	public String tipoDisparo(){
		
		int r=(int) (Math.random()*5+1);
		if(r==1){
			return "ab";
		}else if(r==2){
			return "ns";
		}else if(r==3){
			return "oe";
		}else if(r==4){
			return "misil";
		}else{
			return "normal";
		}
		
	}


}
