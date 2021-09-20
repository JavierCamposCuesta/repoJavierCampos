package EjemploEnum;

import java.time.LocalDate;

public class EmpleadoTemporal extends Empleado{
	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	
	public EmpleadoTemporal() {
		
	}
	
	public EmpleadoTemporal(String nombre, int edad, String nif, double sueldo, LocalDate fechaAlta,
			LocalDate fechaBaja) {
		this.nombre=nombre;
		this.edad=edad;
		this.nif=nif;
		this.sueldo=sueldo;
		this.fechaAlta=fechaAlta;
		this.fechaBaja=fechaBaja;
	}
	
	
	@Override
	public double calculaSueldo() {
		return this.sueldo;
	}

}
