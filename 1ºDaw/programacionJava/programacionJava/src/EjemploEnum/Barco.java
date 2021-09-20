package EjemploEnum;

public abstract class Barco {

	protected String matricula;
	protected double eslora;
	protected int year;
	
	public static final int VALOR_FIJO = 20;
	public static final int VALOR_METROS = 10;
	
	
	
	
	
	public double calcularPrecioBarco() {
		return eslora*VALOR_METROS*VALOR_FIJO;
	}
	
	
}
