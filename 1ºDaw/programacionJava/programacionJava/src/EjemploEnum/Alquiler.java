package EjemploEnum;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Alquiler {

	private Cliente cl;
	private LocalDate fechaIncio;
	private LocalDate fechaFin;
	private int posicionAmarre;
	private Barco barco;
	private double precioTotal;
	
	
	
	public Alquiler() {
		
	}
	
	public Alquiler(Cliente cl, LocalDate fechaInicio, LocalDate fechaFin, int posicionAmarre
			, Barco barco) {
		
		this.cl=cl;
		this.fechaIncio=fechaInicio;
		this.fechaFin=fechaFin;
		this.posicionAmarre=posicionAmarre;
		this.barco=barco;
	}

	public double calularAlquiler() {
		long numeroDias= ChronoUnit.DAYS.between(this.fechaIncio, this.fechaFin)+1;
		this.precioTotal=barco.calcularPrecioBarco()*numeroDias;
		
		return this.precioTotal;
	}
}
