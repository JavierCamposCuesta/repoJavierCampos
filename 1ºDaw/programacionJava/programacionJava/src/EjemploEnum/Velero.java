package EjemploEnum;

public class Velero extends Barco{
	private int numeroMastiles;
	
	
	public Velero() {
		super();
	}
	
	public Velero(String matricula, double eslora, int year, int numeroMastiles) {
		super();
		this.matricula=matricula;
		this.eslora=eslora;
		this.year=year;
		this.numeroMastiles=numeroMastiles;
	}
	
	@Override
	public double calcularPrecioBarco() {
		return super.calcularPrecioBarco()+this.numeroMastiles;
	}
}
