package ClasesAbstractas;

public class CuboEsfera extends AbstractFiguraEspacio{
private double radio;
private double lado;
	
	public CuboEsfera (double radio, double lado, double peso) {
		super();
		this.radio=radio;
		this.lado=lado;
		this.peso=peso;
	}
	
	@Override
	public Double calcularVolumen() {
		return (Math.pow(lado, 3)+(((4/3) * Math.PI * Math.pow(this.radio, 3))/2));
	}

}
