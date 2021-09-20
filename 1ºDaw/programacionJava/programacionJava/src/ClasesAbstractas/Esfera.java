package ClasesAbstractas;

public class Esfera extends AbstractFiguraEspacio {

	private double radio;
	
	public Esfera(double radio, double peso) {
		super();
		this.radio=radio;
		this.peso=peso;
	}
	
	@Override
	public Double calcularVolumen() {
		return (4/3) * Math.PI * Math.pow(this.radio, 3);
	}

}
