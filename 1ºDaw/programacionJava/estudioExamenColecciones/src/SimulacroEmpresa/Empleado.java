package SimulacroEmpresa;



public abstract class Empleado implements Comparable<Empleado>{
	protected String dni;
	protected String nombre;
	protected double sueldo;
	
	public Empleado(String dni, String nombre) {
		this.dni=dni;
		this.nombre=nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		return true;
	}

	
	
	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public double getSueldo() {
		return sueldo;
	}
	
	
	@Override
	public int compareTo(Empleado o) {
		return this.nombre.compareTo(o.nombre);
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", sueldo=" + sueldo + "]";
	}
	
	

	
	
	

}
