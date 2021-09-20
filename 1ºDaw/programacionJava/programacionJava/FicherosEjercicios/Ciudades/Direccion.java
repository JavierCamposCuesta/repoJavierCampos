package Ciudades;



public class Direccion implements Comparable<Direccion>{
	private int idDireccion;
	private String nombreDireccion;
	
	public Direccion(int idDireccion, String nombreDireccion) {
		super();
		this.idDireccion=idDireccion;
		this.nombreDireccion=nombreDireccion;
	}
	

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getNombreDireccion() {
		return nombreDireccion;
	}

	public void setNombreDireccion(String nombreDireccion) {
		this.nombreDireccion = nombreDireccion;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDireccion;
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
		Direccion other = (Direccion) obj;
		if (idDireccion != other.idDireccion)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", nombreDireccion=" + nombreDireccion + "]";
	}


	@Override
	public int compareTo(Direccion arg0) {
		// TODO Auto-generated method stub
		return this.getNombreDireccion().compareTo(arg0.getNombreDireccion());
	}
	
	
	

}
