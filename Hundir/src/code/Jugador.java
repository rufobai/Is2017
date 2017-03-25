package code;

public class Jugador {

	private ListaBarcos listaBarcos;
	private Armamento armamentoJug;
	private String nombre;
	private boolean esOrdenador;
	
	public Jugador(String n, boolean es){
		nombre=n;
		esOrdenador=es;
		armamentoJug=new Armamento();
	}
	
	public boolean activarEscudo(int x, int y){
		return listaBarcos.activarEscudo(x, y);
	}
}
