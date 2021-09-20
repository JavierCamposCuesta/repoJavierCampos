package EjemploEnum;

public class Deportiva extends Barco{
	protected int cv;
	
	public Deportiva() {
		super();
	}
	
	public Deportiva(String matricula, double eslora, int year, int cv) {
		super();
		this.matricula=matricula;
		this.eslora=eslora;
		this.year=year;
		this.cv=cv;
	}
	
	@Override
	public double calcularPrecioBarco() {
		return (eslora*10*VALOR_FIJO)+this.cv;
	}
}
