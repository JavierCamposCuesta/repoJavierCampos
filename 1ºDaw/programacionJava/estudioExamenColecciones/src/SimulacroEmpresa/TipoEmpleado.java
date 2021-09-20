package SimulacroEmpresa;

public enum TipoEmpleado {
ADMINISTRATIVO(1150), OPERARIO(1100), CONTABLE(1350);
	
	private int sueldo;
	TipoEmpleado(int sueldo){
		this.sueldo=sueldo;
	}
	public int getSueldo() {
		return this.sueldo;
	}
}
