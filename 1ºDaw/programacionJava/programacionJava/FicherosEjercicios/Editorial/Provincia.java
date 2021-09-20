package Editorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import Ciudades.Ciudad;
import Ciudades.Direccion;

public class Provincia {
	private String nombre;
	private ArrayList<Localidad> localidades;
	
	public Provincia(String nombre) {
		this.nombre=nombre;
		localidades = new ArrayList<Localidad>();
	}
	
	public void addLocalidadCentroCursoMateria(String nombreLocalidad, String tipo, String codigo, String nombreCentro
			, String nombreCurso, String materia, String titulo, String editorial, String ean, boolean digital) {
		Localidad aux = new Localidad(nombreLocalidad);
		int pos = localidades.indexOf(aux);
		
		if(pos == -1) {
			localidades.add(aux);
			pos=localidades.indexOf(aux);
		}
		localidades.get(pos).addCentroCursoMateria(tipo, codigo, nombreCentro, nombreCurso, materia, titulo, editorial, ean, digital);
	}
	
	
	public String toPantalla() {
		StringBuilder resul = new StringBuilder("\tLocalidad=" + nombre + "\n");
		for (Localidad aux: this.localidades) {
			resul.append(aux.toPantalla() + "\n");
		}
		return resul.toString();
		
	}
	
	public HashMap<String,Integer> editorialesUsada() {
		HashMap<String,Integer> editorial = new HashMap<String, Integer>();
		
		for (Localidad local : this.localidades) {
			HashMap<String, Integer> unaLocalidad = local.editorialesUsada();
			for (String edi: unaLocalidad.keySet()) {
				if (editorial.containsKey(edi)) {
					editorial.put(edi, editorial.get(edi)+ unaLocalidad.get(edi));
				}else {
					editorial.put(edi, unaLocalidad.get(edi));
				}
			}
		}
		return editorial;
		
	}
	
	// Devuelve un mapa con las editoriales usadas en cada una de las materias
	// y el número de veces que se usa
	
	public HashMap<String,Integer> editorialesUsadaMateria(String materia) {
		HashMap<String,Integer> editorial = new HashMap<String, Integer>();
		
		for (Localidad local : this.localidades) {
			HashMap<String, Integer> unaLocalidad = local.editorialesUsadaMateria(materia);
			for (String edi: unaLocalidad.keySet()) {
				if (editorial.containsKey(edi)) {
					editorial.put(edi, editorial.get(edi)+ unaLocalidad.get(edi));
				}else {
					editorial.put(edi, unaLocalidad.get(edi));
				}
			}
		}
		return editorial;
		
	}
	
	// Devuelve un mapa con las editoriales usadas en cada una de las materias
	// y el número de veces que se usa para una localidad
	public HashMap<String,Integer> editorialesUsada(String localidad) {
		HashMap<String,Integer> editorial = new HashMap<String, Integer>();
		boolean encontrada = false;
		Iterator<Localidad> sig = this.localidades.iterator();
		while (sig.hasNext() && !encontrada){
			Localidad local = sig.next();
			if (local.getNombre().equals(localidad)) {
				HashMap<String, Integer> unaLocalidad = local.editorialesUsada();
				for (String edi: unaLocalidad.keySet()) {
					if (editorial.containsKey(edi)) {
						editorial.put(edi, editorial.get(edi)+ unaLocalidad.get(edi));
					}else {
						editorial.put(edi, unaLocalidad.get(edi));
					}
				}
				encontrada = true;
			}
		}
		return editorial;
		
	}
	
	// Igual que el anterior pero para una localidad y materia determinada
	public HashMap<String,Integer> editorialesUsada(String localidad, String materia) {
		HashMap<String,Integer> editorial = new HashMap<String, Integer>();
		boolean encontrada = false;
		Iterator<Localidad> sig = this.localidades.iterator();
		while (sig.hasNext() && !encontrada){
			Localidad local = sig.next();
			if (local.getNombre().equals(localidad)) {
				HashMap<String, Integer> unaLocalidad = local.editorialesUsadaMateria(materia);
				for (String edi: unaLocalidad.keySet()) {
					if (editorial.containsKey(edi)) {
						editorial.put(edi, editorial.get(edi)+ unaLocalidad.get(edi));
					}else {
						editorial.put(edi, unaLocalidad.get(edi));
					}
				}
				encontrada = true;
			}
		}
		return editorial;
		
	}
	
	// Devuelve un string con el listado de los libros de textos usados en el curso
	// el campo será un 1 se le pasaos el código y 2 si le pasamos el nombre

	public String listadoLibros(String idcentro, int campo) {
		String resul="";
		
		Iterator<Localidad> sig = this.localidades.iterator();
		
		while (sig.hasNext() && resul.length() == 0) {
			resul = sig.next().listadoLibros(idcentro, campo);
		}
		
		return resul;
	}
	
	

	
	
	
	
	
	

	public String getNombre() {
		return nombre;
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
		Provincia other = (Provincia) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	
	
	

}
