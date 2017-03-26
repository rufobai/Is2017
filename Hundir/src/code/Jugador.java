package code;

import java.util.ArrayList;
import java.util.Random;

public class Jugador {

	private ListaBarcos listaBarcos;
	private Armamento armamentoJug;
	private String nombre;
	private boolean esOrdenador;
	private Tablero t1;
	private Tablero t2;
	private double dinero;
	
	public Jugador(String n, boolean es){
		nombre=n;
		esOrdenador=es;
		armamentoJug=new Armamento();
		dinero=100;
		if(esOrdenador== true){
			asignarBarcosOrdenador();
		}
		
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
		anadirBarcoMaquina(4);
		anadirBarcoMaquina(3);
		anadirBarcoMaquina(3);
		anadirBarcoMaquina(2);
		anadirBarcoMaquina(2);
		anadirBarcoMaquina(2);
		anadirBarcoMaquina(1);
		anadirBarcoMaquina(1);
		anadirBarcoMaquina(1);
		anadirBarcoMaquina(1);
	}
	public void anadirBarcoMaquina(int barcos){

	int x=(int) (Math.random()*10+1);
	int y=(int) (Math.random()*10+1);
	int d=direccion();
	while(t1.haySitio(barcos, d)!=true){
		d=direccion();
	}
	Barco b=new Barco(barcos);
	b.asignarEspacio(x, y, d);


	
	}



	        


}
