package feria;

public class Caseta{
	private String titulo;
	private ClaseCaseta clase;
	private String entidad;
	private int modulo;
	private int idCaseta;
	private int numero;

	public Caseta(String titulo, String clase, String entidad, int modulo, int idCaseta, int numero) {
		this.titulo=titulo;
		this.clase=ClaseCaseta.valueOf(clase);
		this.entidad=entidad;
		this.modulo=modulo;
		this.idCaseta=idCaseta;
		this.numero=numero;
	}
	
	
	
	

	@Override
	public String toString() {
		return "Caseta [titulo=" + titulo + ", clase=" + clase + ", entidad=" + entidad + ", modulo=" + modulo
				+ ", idCaseta=" + idCaseta + ", numero="+numero + "]";
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCaseta;
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
		Caseta other = (Caseta) obj;
		if (idCaseta != other.idCaseta)
			return false;
		return true;
	}





	public int getNumero() {
		return numero;
	}






	public void setNumero(int numero) {
		this.numero = numero;
	}






	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ClaseCaseta getClase() {
		return clase;
	}

	public void setClase(ClaseCaseta clase) {
		this.clase = clase;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public int getIdCaseta() {
		return idCaseta;
	}

	public void setIdCaseta(int idCaseta) {
		this.idCaseta = idCaseta;
	}

	public int getModulo() {
		return modulo;
	}

	public void setModulo(int modulo) {
		this.modulo = modulo;
	}

	
}
