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

	public int getBombas() {
		return bombas;
	}

	public int getMisiles() {
		return misiles;
	}

	public int getMisilNS() {
		return misilNS;
	}

	public int getMisilOE() {
		return misilOE;
	}

	public int getMisilAB() {
		return misilAB;
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
