package RelacionProblemas10;

import java.time.LocalDate;

public abstract class Vehiculo {
	protected String matricula;
	protected LocalDate fechaInical;
	protected LocalDate fechaFinal;
	
	
	public static final int PRECIO_BASE=30;

	public Vehiculo() {
		
	}
	public double calcularPrecioFijo() {
		double precioFijo;
		precioFijo= EmpresaTransporte.GAMA_MEDIA.getPrecioPorGama();
		
		return precioFijo;
	}

}
