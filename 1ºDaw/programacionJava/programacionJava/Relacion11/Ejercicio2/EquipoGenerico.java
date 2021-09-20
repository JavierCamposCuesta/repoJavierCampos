package Ejercicio2;

import java.util.HashSet;


public class EquipoGenerico<T> {
	private String nombre;
	public HashSet<T> lista;
	
	public EquipoGenerico() {
		lista=new HashSet<T>();
	}
	
	
	public  EquipoGenerico(String nombre) {
		this.nombre=nombre;
		lista=new HashSet<T>();
		
	}
	
	
	//Añadir un alumno (recibe como parámetro el objeto alumno a insertar). 
	//Si elalumno ya existe en el equipo debe saltar una excepción.
	public void addAlumno(T elemento) throws Exception{
		
		if(lista.contains(elemento)) {
			throw new Exception("El elemento ya existe en la lista");
		}
		else {
			lista.add(elemento);
			System.out.println("El elemento ha sido añadido");
		}
	}
	
	
	//Borrar un alumno (recibe como parámetro el objeto alumno a borrar). 
	//Si elalumno no existe en el equipo debe saltar una excepción.
	public void eliminarAlumno(T elemento) throws Exception{
		if(lista.remove(elemento)) {
			System.out.println("Elemento eliminado");
		}
		else {
			throw new Exception("El jugador no existe en el equipo");
		}
		
	}
	
	
	//Saber si un alumno pertenece al equipo. Recibe como parámetro el objetoalumno a buscar 
	//y devuelve null si no lo encuentra y el  objeto alumno si existe.
	
	public String buscarAlumno(T elemento) {
		String resultado=null;
		if(lista.contains(elemento)) {
			resultado=elemento.toString();
		}
		return resultado;
	}
	
	
	//Mostrar en pantalla la lista de personas del equipo.
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(T e : lista) {
			sb.append(e+ "\n");
		}
		
		
		return ( sb.toString()+"\n");
	}
	
	
	//Unión de equipos. El método lo llamará un equipo y se le pasará por parámetro
	//el otro equipo con el que se quiere unir. Devuelve un equipo formado por los
	//alumnos de ambos equipos.
	public EquipoGenerico<T> toStringUnirEquipos(EquipoGenerico<T> equipo) throws Exception{
		EquipoGenerico<T> nuevo = new EquipoGenerico<T>();
		for(T e : this.lista) {
			nuevo.addAlumno(e);
		}
		for(T j : equipo.lista) {
			nuevo.addAlumno(j);
		}
		
		
		
		return nuevo;
		
	}
	
	
	//Intersección de equipos.  Idem al anterior pero devuelve un equipo formado por
	//los alumnos que están en los dos equipos
	public EquipoGenerico<T> jugadoresRepetidos(EquipoGenerico<T> elemento) throws Exception{
		EquipoGenerico<T> nuevo = new EquipoGenerico<T>();
		for(T e : this.lista) {
			if(this.lista.contains(e) && elemento.lista.contains(e)) {
				nuevo.addAlumno(e);
			}
		}
		
		
		
		
		return ( nuevo);
		
		
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
		EquipoGenerico other = (EquipoGenerico) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


	
	
	
	

}