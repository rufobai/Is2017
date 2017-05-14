package code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Jugador {

	public ListaBarcos listaBarcos;
	private Armamento armamentoJug;
	private boolean esOrdenador;
	private Tablero t1;
	private Tablero t2;
	private int dinero;
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
	public int getDinero(){
		return dinero;
	}
	public Tablero getTablero(){
		return t1;
	}
	public void darTablero(Tablero t){
		t2=t;
	}
	
	public boolean activarEscudo(int x, int y){
		if(dinero-20!=0){
			dinero=dinero-20;
			return listaBarcos.activarEscudo(x, y);
		}else{
			return false;
		}
		
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
		Barco b;
		
		
		if(cont==0 ){
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
		e=t1.anadirFragata();
		anadirBarcoALista(new Barco(1, e));
		e=t1.anadirFragata();
		anadirBarcoALista(new Barco(1, e));
		e=t1.anadirFragata();
		anadirBarcoALista(new Barco(1, e));
		e=t1.anadirFragata();
		anadirBarcoALista(new Barco(1, e));
		
	}
	
	public void comprobarBarco(ArrayList<Casilla> e){
		boolean es=false;
		for(int f=0;f==e.size();f++){
			for(int a=0; a==listaBarcos.getLista().size();a++){
				if(listaBarcos.getLista().get(a).esta(e.get(f).getX(), e.get(f).getY())==true){
					es=true;
				}
				
				
			}
		}
		
		
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
		
		while(x1!=x+1&&!hay){
			while(y1!=y+1&&!hay){
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
	public boolean comprar(String tipo){

		if(dinero==0){
			return false;
		}else if(tipo=="M" ){
			
			armamentoJug.anadirMisil();
			dinero=dinero-20;
			return true;
		}else if(tipo=="MOE" ){
			armamentoJug.anadirMisilOE();
			dinero=dinero-20;
			return true;
		}else if(tipo=="MNS"){
			armamentoJug.anadirMisilNS();
			dinero=dinero-20;
			return true;
		}else if(tipo=="MT"){
			armamentoJug.anadirMisilAB();
			dinero=dinero-20;
			
		}else{
			armamentoJug.anadirRadar();
			dinero=dinero-20;
		}
		return true;
		
	}
	
	public ArrayList<Casilla> disparar(String tipo, int x, int y){
		ArrayList<Casilla> m=new ArrayList<Casilla>();
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
	
	public ArrayList<Casilla> dispararO(String tipo, int x, int y){
		System.out.println("--------------EL METODO DISPARAR----000000000----RECIBE: X= " + x + "Y= " + y + "TIPO" + tipo);
		ArrayList<Casilla> m=new ArrayList<Casilla>();
		if(tipo=="B" && armamentoJug.getBombas()!=0){
			System.out.println("EL METODO DISPARAR----000000000 BOM" );
			m=listaBarcos.disparoNormal(x, y);
			armamentoJug.lanzarBomba();
		}else if(tipo=="M" && armamentoJug.getMisiles()!=0){
			System.out.println("EL METODO DISPARAR----000000000 MIS" );
			m=listaBarcos.disparoMisil(x, y);
			armamentoJug.lanzarMisil();
		}else if(tipo=="MOE" && armamentoJug.getMisilOE()!=0){
			System.out.println("EL METODO DISPARAR----000000000 MOE" );
			m=listaBarcos.disparoMOEOrdenador(x, y);
			armamentoJug.lanzarMisilOE();
		}else if(tipo=="MNS" && armamentoJug.getMisilNS()!=0){
			System.out.println("EL METODO DISPARAR----000000000 MNS" );
			m=listaBarcos.disparoMNSOrdenador(x, y);
			armamentoJug.lanzarMisilNS();
		}else{
			System.out.println("EL METODO DISPARAR----000000000 MISILTOTAL" );
			m=listaBarcos.disparoMNSOrdenador(x, y);
			m.addAll(listaBarcos.disparoMOEOrdenador(x, y));
			//m=listaBarcos.disparoMTOrdenador(x, y);
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
		System.out.println("EL RANDOM ES=" + r);
		if(r==1){
			return "MAB";
		}else if(r==2){
			return "MNS";
		}else if(r==3){
			return "MOE";
		}else if(r==4){
			return "M";
		}else{
			return "B";
		}
		
	}


}
