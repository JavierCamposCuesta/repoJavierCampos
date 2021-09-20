package ClasesAbstractas;

public abstract class AbstractFiguraEspacio {

	private final Double DENSIDAD_AGUA = 1.1;
	protected Double peso;
	
	public abstract Double calcularVolumen();
	
	public Double calcularDensidad() {
		return (this.peso/calcularVolumen());
	};
	
	public boolean flotaEnElAgua() {
		return (DENSIDAD_AGUA > calcularDensidad());
	};
	
	
	
}
