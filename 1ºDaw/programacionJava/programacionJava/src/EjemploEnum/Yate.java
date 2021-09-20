package EjemploEnum;

public class Yate extends Deportiva{
	private int numeroCamarotes;
	
	public Yate() {
		super();
	}
	
	public Yate(String matricula, double eslora, int year, int cv, int numeroCamarotes) {
		super();
		this.matricula=matricula;
		this.eslora=eslora;
		this.year=year;
		this.numeroCamarotes=numeroCamarotes;
		
	}
	
	@Override
	public double calcularPrecioBarco() {
		return (eslora*10*VALOR_FIJO)+this.cv+this.numeroCamarotes;
		
	}
}
