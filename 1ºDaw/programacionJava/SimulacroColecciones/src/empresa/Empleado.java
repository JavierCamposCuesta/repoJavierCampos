package empresa;

public class Empleado implements Comparable<Empleado> , ActualizableSueldo {
	
	protected String dni;
	protected String nombre;
	protected double sueldo;
	protected IncrementoSueldo incremento;
	
	
	
	
	
	

	@Override
	public void actualizarSueldo() {
		this.sueldo=this.sueldo+(this.sueldo*(this.incremento.getIncremento()/100));
		
	}







	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}







	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}







	@Override
	public String toString() {
		return " [nombre=" + nombre + ", sueldo=" + sueldo + "]";
	}







	@Override
	public int compareTo(Empleado o) {
		return this.nombre.compareTo(o.nombre);
	}







	public double getSueldo() {
		return sueldo;
	}
	
	

}
