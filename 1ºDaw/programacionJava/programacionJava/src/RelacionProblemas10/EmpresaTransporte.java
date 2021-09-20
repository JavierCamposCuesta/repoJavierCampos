package RelacionProblemas10;

public enum EmpresaTransporte {
	
	GAMA_ALTA(50),
	GAMA_MEDIA(40),
	GAMA_BAJA(30),
	
	DIESEL(2),
	GASOLINA(3.5);
	
	public int precioPorGama;
	public double precioCombustible;
	
	EmpresaTransporte(double a){
		
	}
	
	EmpresaTransporte(int precioPorGama, double precioCombustible) {
		this.precioPorGama=precioPorGama;
		this.precioCombustible=precioCombustible;
	}

	public int getPrecioPorGama() {
		return precioPorGama;
	}

	public double getPrecioCombustible() {
		return precioCombustible;
	}
	
	
	

}
