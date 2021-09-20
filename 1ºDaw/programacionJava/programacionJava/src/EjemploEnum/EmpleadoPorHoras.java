package EjemploEnum;

import java.time.LocalDate;

public class EmpleadoPorHoras extends Empleado {
	
	private double precioPorHora;
	private double horasTrabajadas;
	
	public EmpleadoPorHoras(String nombre, int edad, String nif, double sueldo, double precioPorHora
			 , double horasTrabajadas) {
		this.nombre=nombre;
		this.edad=edad;
		this.nif=nif;
		this.sueldo=sueldo;
		this.precioPorHora=precioPorHora;
		this.horasTrabajadas=horasTrabajadas;
	}

	@Override
	public double calculaSueldo() {
		return (this.sueldo*this.precioPorHora*this.horasTrabajadas);
	}
	
	
}
