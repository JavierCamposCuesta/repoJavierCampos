package Editorial;

public class Materias {
	private String materia;
	private String titulo;
	private String editorial;
	private String ean;
	private boolean digital;
	
	public Materias(String materia, String titulo, String editorial, String ean, boolean digital) {
		this.materia=materia;
		this.titulo=titulo;
		this.editorial=editorial;
		this.ean=ean;
		this.digital=digital;
	}
	
	

	public String getNombre() {
		return materia;
	}

	public String getEditorial() {
		return editorial;
	}
	
	

	public String getTitulo() {
		return titulo;
	}


	public String getEan() {
		return ean;
	}

	public boolean getDigital() {
		return digital;
	}
	
	

	public String getMateria() {
		return materia;
	}



	public void setMateria(String materia) {
		this.materia = materia;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}



	public void setEan(String ean) {
		this.ean = ean;
	}



	public void setDigital(boolean digital) {
		this.digital = digital;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ean == null) ? 0 : ean.hashCode());
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
		Materias other = (Materias) obj;
		if (ean == null) {
			if (other.ean != null)
				return false;
		} else if (!ean.equals(other.ean))
			return false;
		return true;
	}

	
	public String toPantalla() {
		return "Libro [nombre=" + materia + ", editorial=" + editorial + ", ean=" + ean + ", digital=" + digital + "]";
	}



	
	
	

}
