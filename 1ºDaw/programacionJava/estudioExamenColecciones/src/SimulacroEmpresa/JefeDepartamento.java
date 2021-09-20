package SimulacroEmpresa;

public class JefeDepartamento extends Empleado implements ActualizarSueldo{

	private int antiguedad;
	
	public JefeDepartamento(String dni, String nombre, double sueldo, int antiguedad) throws Exception{
		super(dni, nombre);
		if(sueldo<1300) {
			throw new Exception("El sueldo no puede ser inferior a 1300€");
		}
		else {
			this.sueldo=sueldo;
		}
		this.antiguedad=antiguedad;
		
	}

	@Override
	public void actualizaSueldo() {
		this.sueldo=this.sueldo*1.1;
		
	}

	@Override
	public String toString() {
		return super.toString() + "JefeDepartamento [antiguedad=" + antiguedad + "]";
	}
	
	
	
	
	
	

}
