package empresa;

public class EmpleadoBase extends Empleado{
	public static final IncrementoSueldo FACTOR_SUELDO = IncrementoSueldo.EMPLEADO;
	private TipoSueldo tipoEmpleado;
	
	public EmpleadoBase(String dni, String nombre, TipoSueldo tipoEmpleado) {
		this.dni=dni;
		this.nombre=nombre;
		this.sueldo=tipoEmpleado.getSueldo();
		this.incremento=IncrementoSueldo.EMPLEADO;
		this.tipoEmpleado = tipoEmpleado;
	}

}
