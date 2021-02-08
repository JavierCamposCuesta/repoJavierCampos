package problemas6OrientacionObjetos1;

public class Complejo {
	private double parteReal;
	private double parteImaginaria;
	
	public Complejo() {}
	
	public Complejo(double parteReal, double parteImaginaria) {
		this.parteReal = parteReal;
		this.parteImaginaria= parteImaginaria;
	}
	
	public Complejo sumarComplejos(double parteReal1, double parteImaginaria1, double parteReal2, double parteImaginaria2 ) {
		parteReal=parteReal1+parteReal2;
		parteImaginaria=parteImaginaria1+parteImaginaria2;
		Complejo resultadoSuma = new Complejo(parteReal, parteImaginaria);
		return resultadoSuma;
	}
	
	public Complejo restarComplejos(double parteReal1, double parteImaginaria1, double parteReal2, double parteImaginaria2 ) {
		parteReal=parteReal1-parteReal2;
		parteImaginaria=parteImaginaria1-parteImaginaria2;
		Complejo resultadoResta = new Complejo(parteReal, parteImaginaria);
		return resultadoResta;
	}
	
	@Override 
	public String toString() {
		return this.parteReal + " + "+ this.parteImaginaria + "i";
		
	}
	

}


