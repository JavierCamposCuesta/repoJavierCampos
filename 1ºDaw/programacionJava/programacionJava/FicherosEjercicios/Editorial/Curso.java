package Editorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Curso {
	private String nombre;
	private ArrayList<Materias> listaMaterias;
	
	public Curso(String nombre) {
		this.nombre=nombre;
		this.listaMaterias = new ArrayList<Materias>();
	}
	
	//Añade una nueva materia a un curso
	public void addMateria(String materia, String titulo, String editorial, String ean, boolean digital ) {
		Materias aux = new Materias(materia, titulo, editorial, ean, digital);
		this.listaMaterias.add(aux);
	}
	
	
	
	

	public String getNombre() {
		return nombre;
	}
	
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Curso other = (Curso) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	
	
	
	//ToString para mostrarlo por pantalla
	public String toPantalla() {
		StringBuilder resul = new StringBuilder("\t\t\t\tCurso=" + nombre + "\n");
		for (Materias aux: this.listaMaterias) {
			resul.append("\t\t\t\t" + aux.toPantalla() + "\n");
		}
		return resul.toString();
		
	}
	
	// Devuelve un mapa con las editoriales usadas en cada una de las materias
		// y el número de veces que se usa
		public HashMap<String,Integer> editorialesUsada() {
			HashMap<String,Integer> editorial = new HashMap<String, Integer>();
			
			for (Materias mat : this.listaMaterias) {
				if (!editorial.containsKey(mat.getEditorial()))
					// Si no existe la editorial la añado en el mapa con valor 1
					editorial.put(mat.getEditorial(), 1);
				else
					// Si ya existe actualizo su valor con lo que tenía antes más 1
					editorial.put(mat.getEditorial(),editorial.get(mat.getEditorial())+1);
			}
			return editorial;
		}
		
		
	// Igual que la anterior pero sólo para una determinada materia
	public HashMap<String,Integer> editorialesUsadaMateria(String materia) {
		HashMap<String,Integer> editorial = new HashMap<String, Integer>();
		
		for (Materias mat : this.listaMaterias) {
			if (mat.getMateria().equals(materia))
				if (!editorial.containsKey(mat.getEditorial()))
					editorial.put(mat.getEditorial(), 1);
				else
					editorial.put(mat.getEditorial(),editorial.get(mat.getEditorial())+1);
		}
		return editorial;
	}
	
	
	// Devuelve un string con el listado de los libros de textos usados en el curso
		public String listadoLibros() {
			StringBuilder resul= new StringBuilder();
			
			for (Materias materia: this.listaMaterias)
				resul.append(materia.getTitulo() + " " + materia.getEditorial() + "\n");
			
			return resul.toString();
		}
	
	

}
