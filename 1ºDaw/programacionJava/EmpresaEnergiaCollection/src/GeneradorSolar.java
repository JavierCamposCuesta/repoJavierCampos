import java.time.LocalDate;

public class GeneradorSolar extends GeneradorAbstract{
	private int numeroPaneles;
	private double metrosCuadrados;
	private TipoPanel tipo;
	
	public GeneradorSolar(LocalDate fechaComienzo, String localidad, int potencia, int numeroPaneles,
			double metrosCuadrados, TipoPanel tipo) {
		this.codigo=this.CONTADOR++;
		this.fechaComienzo=fechaComienzo;
		this.localidad=localidad;
		this.potencia=potencia;
		this.numeroPaneles=numeroPaneles;
		this.metrosCuadrados=metrosCuadrados;
		this.tipo=tipo;
		
	}

	@Override
	public String toString() {
		return super.toString()+"GeneradorSolar [coeficiente solar=" + metrosCuadrados/numeroPaneles + ", tipo="
				+ tipo + "]";
	}
	
	@Override
	public double dinero(double precioEnergia) {
		
		return (this.potencia*this.numeroPaneles*precioEnergia);
	}
	
	
	
	


}
