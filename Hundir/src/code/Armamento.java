package code;

public class Armamento {

	
	private int radar;
	private int bombas;
	private int misiles;
	private int misilNS;
	private int misilOE;
	private int misilAB;


	public Armamento(){
		radar=2;
		bombas=1;
		misiles=10;
		misilAB=2;
		misilNS=2;
		misilOE=2;
				
	}

	public int saberRadar(){
		return radar;
	}
	public void lanzarRadar(){
		radar=radar-1;
	}
	public int saberBomba(){
		return bombas;
	}
	public void lanzarBomba(){
		bombas=bombas-1;
	}
	public int saberMisil(){
		return misiles;
	}
	public void lanzarMisil(){
		misiles=misiles-1;
	}
	public int saberMisilNS(){
		return misilNS;
	}
	public void lanzarMisilNS(){
		misilNS=misilNS-1;
	}
	public int saberMisilAB(){
		return misilAB;
	}
	public void lanzarMisilAB(){
		misilAB=misilAB-1;
	}
	public int saberMisilOE(){
		return misilOE;
	}
	public void lanzarMisilOE(){
		misilOE=misilOE-1;
	}
	
	
	
	
	
	
	
	





}
