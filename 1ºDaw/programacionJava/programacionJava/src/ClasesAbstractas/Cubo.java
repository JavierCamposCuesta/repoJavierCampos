package ClasesAbstractas;

public class Cubo extends AbstractFiguraEspacio{

	private double lado;
	
	public Cubo(double lado, double peso) {
		super();
		this.lado=lado;
		this.peso=peso;
	}
	
	@Override
	public Double calcularVolumen() {
		return Math.pow(lado, 3);
	}
	
	@Override
	public Double calcularDensidad() {
		return (this.peso/calcularVolumen());
	};

}
