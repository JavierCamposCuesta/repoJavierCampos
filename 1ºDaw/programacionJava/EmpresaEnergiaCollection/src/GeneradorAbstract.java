import java.time.LocalDate;

public abstract class GeneradorAbstract implements Monetizable, Comparable<GeneradorAbstract>{
	protected int codigo;
	protected LocalDate fechaComienzo;
	protected String localidad;
	protected int potencia;
	
	protected static int CONTADOR=0;

	@Override
	public String toString() {
		return "[codigo=" + codigo + ", fechaComienzo=" + fechaComienzo + ", localidad=" + localidad
				+ ", potencia=" + potencia + "]";
	}



	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getPotencia() {
		return potencia;
	}


	public int getCodigo() {
		return codigo;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		GeneradorAbstract other = (GeneradorAbstract) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(GeneradorAbstract o) {
		
		return this.fechaComienzo.compareTo(o.fechaComienzo);
	}
	
	
	
	
	
	
	
	
	
	

}
