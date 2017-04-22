package code;

public class Casilla {

	
	private boolean ocupada;
	
	public Casilla(){
		ocupada=false;
	}
	
	public void cambiarEstado(){
		ocupada=true;
	}
	public boolean getEstado(){
		return ocupada;
	}
}
