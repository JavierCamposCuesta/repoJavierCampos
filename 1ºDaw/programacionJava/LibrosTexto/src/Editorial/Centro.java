package Editorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Centro {
	private String nombre;
	private String codigo;
	private TipoCentro tipoCentro;
	
	private ArrayList<Curso>cursos;
	
	public Centro(String tipo, String codigo, String nombre) {
		super();
		try {
			this.tipoCentro = TipoCentro.valueOf(tipo); 
		} catch (Exception e) {
			// Si no aparece el tipo adecuado le pongo público
			this.tipoCentro = TipoCentro.PUBLICO;
		}
		this.codigo=codigo;
		this.nombre=nombre;
		cursos=new ArrayList<Curso>();
	}
	
	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setTipoCentro(TipoCentro tipoCentro) {
		this.tipoCentro = tipoCentro;
	}


	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public TipoCentro getTipoCentro() {
		return tipoCentro;
	}

	
	
	//Añade una materia a un curso. Si el curso no existe loo crea
	public void addCursoMateria(String nombre, String materia, String titulo, 
			String editorial, String ean, boolean digital ) {
		Curso aux = new Curso(nombre);
		int pos = this.cursos.indexOf(aux);
		
		if(pos == -1) {
			this.cursos.add(aux);
			pos = cursos.indexOf(aux);
		}
		this.cursos.get(pos).addMateria(materia, titulo, editorial, ean, digital);
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Centro other = (Centro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}





	
	
	public String toPantalla() {
		StringBuilder resul = new StringBuilder("\t\t\tCentro=" + nombre + "\n");
		for (Curso aux: this.cursos) {
			resul.append(aux.toPantalla() + "\n");
		}
		return resul.toString();
		
	}
	
	// Devuelve un mapa con las editoriales usadas en cada una de las materias
	// y el número de veces que se usa
	public HashMap<String,Integer> editorialesUsada() {
		HashMap<String,Integer> editorial = new HashMap<String, Integer>();
		
		for (Curso curs : this.cursos) {
			HashMap<String, Integer> unCurso = curs.editorialesUsada();
			for (String edi: unCurso.keySet()) {
				if (editorial.containsKey(edi)) {
					editorial.put(edi, editorial.get(edi)+ unCurso.get(edi));
				}else {
					editorial.put(edi, unCurso.get(edi));
				}
			}
		}
		return editorial;
	}
	
	// Igual que la anterior, pero para una materia determinada.
	public HashMap<String,Integer> editorialesUsadaMateria(String materia) {
		HashMap<String,Integer> editorial = new HashMap<String, Integer>();
		
		for (Curso curs : this.cursos) {
			HashMap<String, Integer> unCurso = curs.editorialesUsadaMateria(materia);
			for (String edi: unCurso.keySet()) {
				if (editorial.containsKey(edi)) {
					editorial.put(edi, editorial.get(edi)+ unCurso.get(edi));
				}else {
					editorial.put(edi, unCurso.get(edi));
				}
			}
		}
		return editorial;
	}
	
	// Devuelve un string con el listado de los libros de textos usados en el curso

	public String listadoLibros() {
		StringBuilder resul= new StringBuilder();
		
		for (Curso curso: this.cursos)
			resul.append(curso.listadoLibros());
		
		return resul.toString();
	}
	
	

}
