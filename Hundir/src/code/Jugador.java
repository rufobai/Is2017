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
	
	public Jugador(boolean es){
		esOrdenador=es;
		armamentoJug=new Armamento();
		dinero=100;
		t1=new Tablero();
		t2=new Tablero();
		if(esOrdenador== true){
			asignarBarcosOrdenador();
		}
		
		
	}
	public boolean esOrdenador(){
		return esOrdenador;
	}
	
	public boolean activarEscudo(int x, int y){
		return listaBarcos.activarEscudo(x, y);
	}
	
	private int direccion(){
		return (int) (Math.random()*4+1);
	}
	public void anadirBarco(ArrayList<ArrayList<Integer>> list, int length){
		Barco b=new Barco(length);
		b.darPosicion(list);
	}
	public void reparar(int x, int y){
		dinero=dinero-20;
	}
	
	private void asignarBarcosOrdenador(){
		
		t1.anadirBarco(4);
		t1.anadirBarco(3);
		t1.anadirBarco(3);
		t1.anadirBarco(2);
		t1.anadirBarco(2);
		t1.anadirBarco(2);
		t1.anadirBarco(1);
		t1.anadirBarco(1);
		t1.anadirBarco(1);
		t1.anadirBarco(1);
		
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
	public ArrayList<Integer> radar(int x, int y){
		ArrayList<Integer> r=new ArrayList<Integer>();
		
		boolean hay=false;
		for(int x1=x-1; x1==x+1;x1++){
			for(int y1=y-1;y1==y+1;y1++){
				hay=listaBarcos.existeBarco(x1, y1);
				r.add(x1);
				r.add(y1);
			}
		}
		return r;
	}
	
	public void disparar(String tipo, int x, int y){
		
	}
	public static void main(String[] args) {
		Jugador j=new Jugador(true);
		j.t1.imprimir();
	}


}
