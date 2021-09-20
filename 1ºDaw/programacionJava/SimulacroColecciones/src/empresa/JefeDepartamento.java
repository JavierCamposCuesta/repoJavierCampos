package empresa;

public class JefeDepartamento extends Empleado {
	
	
	
	private int antiguedad;
	

	public JefeDepartamento(String dni, String nombre,double sueldo, int antiguedad) throws Exception {
		this.dni=dni;
		this.nombre=nombre;
		this.incremento=IncrementoSueldo.JEFE;
		if(sueldo<1300) {
			throw new Exception("El sueldo de un jefe no puede ser inferior a 1300€");
		}
		else {
			this.sueldo=sueldo;
		}
		
		this.antiguedad=antiguedad;
		
	}
	
	

}
