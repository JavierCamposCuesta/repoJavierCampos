import java.time.LocalDate;

public class GeneradorEolico extends GeneradorAbstract{
	private int numeroAspas;
	
	public GeneradorEolico(LocalDate fechaComienzo, String localidad, int potencia, int numeroAspas) {
		this.codigo=this.CONTADOR++;
		this.fechaComienzo=fechaComienzo;
		this.localidad=localidad;
		this.potencia=potencia;
		this.numeroAspas=numeroAspas;
		
	}

	@Override
	public String toString() {
		return super.toString() + "GeneradorEolico [numeroAspas=" + numeroAspas + "]";
	}

	@Override
	public double dinero(double precioEnergia) {
		
		return (this.potencia*this.numeroAspas*precioEnergia);
	}

	

	
	
	
	

}
