package Editorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;



public class Localidad {
	private String nombre;
	private ArrayList<Centro>centros;
	
	public Localidad(String nombre) {
		this.nombre = nombre;
		centros = new ArrayList<Centro>();
	}
	
	public void addCentroCursoMateria(String tipo, String codigo, String nombreCentro, String nombre,
			String materia, String titulo, String editorial, String ean, boolean digital) {
		Centro aux= new Centro(tipo, codigo, nombreCentro);
		int pos = this.centros.indexOf(aux);
		
		if(pos == -1) {
			this.centros.add(aux);
			pos = this.centros.indexOf(aux);
		}
		this.centros.get(pos).addCursoMateria(nombre, materia, titulo, editorial, ean, digital);
	}
	
	
	public String toPantalla() {
		StringBuilder resul = new StringBuilder("\t\tLocalidad=" + nombre + "\n");
		for (Centro aux: this.centros) {
			resul.append(aux.toPantalla() + "\n");
		}
		return resul.toString();
		
	}
	
	// Devuelve un mapa con las editoriales usadas en cada una de las materias
	// y el número de veces que se usa
	public HashMap<String,Integer> editorialesUsada() {
		HashMap<String,Integer> editorial = new HashMap<String, Integer>();
		
		for (Centro centr : this.centros) {
			HashMap<String, Integer> unCentro = centr.editorialesUsada();
			for (String edi: unCentro.keySet()) {
				if (editorial.containsKey(edi)) {
					editorial.put(edi, editorial.get(edi)+ unCentro.get(edi));
				}else {
					editorial.put(edi, unCentro.get(edi));
				}
			}
		}
		return editorial;
		
	}
	
	// Igual que la anterior, pero para una materia determinada.
	public HashMap<String,Integer> editorialesUsadaMateria(String materia) {
		HashMap<String,Integer> editorial = new HashMap<String, Integer>();
		
		for (Centro centr : this.centros) {
			HashMap<String, Integer> unCentro = centr.editorialesUsadaMateria(materia);
			for (String edi: unCentro.keySet()) {
				if (editorial.containsKey(edi)) {
					editorial.put(edi, editorial.get(edi)+ unCentro.get(edi));
				}else {
					editorial.put(edi, unCentro.get(edi));
				}
			}
		}
		return editorial;
		
	}
	// Devuelve un string con el listado de los libros de textos usados en el curso
	// el campo será un 1 se le pasaos el código y 2 si le pasamos el nombre

	public String listadoLibros(String idcentro, int campo) {
		String resul="";
		
		Iterator<Centro> sig = this.centros.iterator();
		
		while (sig.hasNext() && resul.length() == 0) {
			Centro centro = sig.next();
			if (campo == 1) {
				if (centro.getCodigo().equals(idcentro))
					resul = sig.next().listadoLibros();
			}
			if (campo == 2) {
				if (centro.getNombre().equals(idcentro))
					resul = sig.next().listadoLibros();
			}
			
		}
		
		return resul;
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
		Localidad other = (Localidad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	
	
	
	

}
