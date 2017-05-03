package code;

public class Casilla {

	
	private boolean ocupada;
	private boolean dañada;
	private int escudo;
	private int x;
	private int y;
	
	public Casilla(int x1, int y1){
		ocupada=false;
		dañada=false;
		escudo=0;
		x=x1;
		y=y1;
	}
	
	public void cambiarEstado(){
		ocupada=true;
	}
	public boolean getEstado(){
		return ocupada;
	}
	public void darGolpe(){
		dañada=true;
	}
	public boolean getDañada(){
		return dañada;
	}
	public void sanar(){
		dañada=false;
	}
	public int getEscudo(){
		return escudo;
	}
	public void darEscudo(){
		escudo=2;
	}
	public void quitarEscudo(){
		escudo=escudo-1;
	}
	public void destruirEscudo(){
		escudo=0;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
