package code;

import java.util.Random;

public class Jugador {

	private ListaBarcos listaBarcos;
	private Armamento armamentoJug;
	private String nombre;
	private boolean esOrdenador;
	private Tablero t1;
	private Tablero t2;
	
	public Jugador(String n, boolean es){
		nombre=n;
		esOrdenador=es;
		armamentoJug=new Armamento();
	}
	
	public boolean activarEscudo(int x, int y){
		return listaBarcos.activarEscudo(x, y);
	}
	
	public int direccion(){
		return (int) (Math.random()*4+1);
	}
	
	public void anadirBarco(int barcos){

	int x=(int) (Math.random()*10+1);
	int y=(int) (Math.random()*10+1);
	int d=direccion();
	while(t1.haySitio(barcos, d)!=true){
		d=direccion();
	}
	new Barco(barcos, x, y, d);

	}



	        


}
