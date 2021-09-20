package EjemploEnum;

public  abstract class Empleado {
	protected String nombre;
	protected int edad;
	protected String nif;
	protected double sueldo;
	
	public double calculaSueldo() {
		return this.sueldo;
	}
	
	
}
