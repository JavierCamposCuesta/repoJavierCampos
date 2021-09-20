package SimulacroEmpresa;

public class EmpleadoBase extends Empleado implements ActualizarSueldo{

	TipoEmpleado tipo;
	
	public EmpleadoBase(String dni, String nombre, String tipoEmpleado) throws Exception{
		super(dni, nombre);
		tipoEmpleado=tipoEmpleado.toUpperCase();
		if(TipoEmpleado.valueOf(tipoEmpleado)!= null) {
			this.tipo=TipoEmpleado.valueOf(tipoEmpleado);
		}
		else {
			throw new Exception("El tipo de empleado no existe");
		}
		this.sueldo=tipo.getSueldo();
		
	}

	@Override
	public void actualizaSueldo() {
		this.sueldo=this.sueldo*1.025;
		
	}

	@Override
	public String toString() {
		return super.toString()+"EmpleadoBase [tipo=" + tipo + "]";
	}
	
	
	


}
