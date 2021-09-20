package EjemploEnum;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmpleadoFijo extends Empleado{
	private LocalDate fechaAlta;
	
	public EmpleadoFijo(String nombre, int edad, String nif, double sueldo, LocalDate fechaAlta) {
		this.nombre=nombre;
		this.edad=edad;
		this.nif=nif;
		this.sueldo=sueldo;
		this.fechaAlta=fechaAlta;
	}
	
	@Override
	public double calculaSueldo() {
		long yearTrabajado = ChronoUnit.YEARS.between(fechaAlta, LocalDate.now());
		return (this.sueldo+(yearTrabajado*20));
	}
	
}
