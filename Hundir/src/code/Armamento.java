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
		bombas=105;
		misiles=1;
		misilAB=2;
		misilNS=2;
		misilOE=2;
				
	}

	public int getRadar() {
		return radar;
	}
	public void anadirRadar(){
		radar=radar+1;
	}

	public int getBombas() {
		return bombas;
	}

	public int getMisiles() {
		return misiles;
	}
	public void anadirMisil(){
		misiles=misiles+1;
	}

	public int getMisilNS() {
		return misilNS;
	}
	public void anadirMisilNS(){
		misilNS=misilNS+1;
	}

	public int getMisilOE() {
		return misilOE;
	}
	public void anadirMisilOE(){
		misilOE=misilOE+1;
	}

	public int getMisilAB() {
		return misilAB;
	}
	public void anadirMisilAB(){
		misilAB=misilAB+1;
	}
	
	public boolean saberRadar(){
		if(radar!=0){
			return true;
		}else{
			return false;
		}
		
	}
	public void lanzarRadar(){
		radar=radar-1;
	}
	public boolean saberBomba(){
		if(bombas!=0){
			return true;
		}else{
			return false;
		}	}
	public void lanzarBomba(){
		bombas=bombas-1;
	}
	public boolean saberMisil(){
		if(misiles!=0){
			return true;
		}else{
			return false;
		}
	}
	public void lanzarMisil(){
		misiles=misiles-1;
	}
	public boolean saberMisilNS(){
		if(misilNS!=0){
			return true;
		}else{
			return false;
		}
	}
	public void lanzarMisilNS(){
		misilNS=misilNS-1;
	}
	public boolean saberMisilAB(){
		if(misilAB!=0){
			return true;
		}else{
			return false;
		}
	}
	public void lanzarMisilAB(){
		misilAB=misilAB-1;
	}
	public boolean saberMisilOE(){
		if(misilOE!=0){
			return true;
		}else{
			return false;
		}
	}
	public void lanzarMisilOE(){
		misilOE=misilOE-1;
	}
	
	
	
	
	
	
	
	





}
