package Ejercicio1_Equipo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;







public class Equipo {
	private String nombre;
	public HashSet<Alumno> jugadores;
	public HashSet<Alumno> nuevoEquipo;
	public HashSet<Alumno> jugadoresRepetidos;
	
	public Equipo(String nombre) {
		this.nombre=nombre;
		jugadores=new HashSet<Alumno>();
		nuevoEquipo=new HashSet<Alumno>();
		jugadoresRepetidos=new HashSet<Alumno>();
	}
	
	
	//Añadir un alumno (recibe como parámetro el objeto alumno a insertar). 
	//Si elalumno ya existe en el equipo debe saltar una excepción.
	public void addAlumno(Alumno alumno) throws Exception{
		
		if(jugadores.add(alumno)) {
			jugadores.add(alumno);
		}
		else {
			throw new Exception("El alumno ya está en la lista");
			
		}
	}
	
	
	//Borrar un alumno (recibe como parámetro el objeto alumno a borrar). 
	//Si elalumno no existe en el equipo debe saltar una excepción.
	public void eliminarAlumno(Alumno alumno) throws Exception{
		if(jugadores.remove(alumno)) {}
		else {
			throw new Exception("El jugador no existe en el equipo");
		}
		
	}
	
	
	//Saber si un alumno pertenece al equipo. Recibe como parámetro el objetoalumno a buscar 
	//y devuelve null si no lo encuentra y el  objeto alumno si existe.
	
	public String buscarAlumno(Alumno alumno) {
		String resultado=null;
		if(jugadores.contains(alumno)) {
			resultado=alumno.toString();
		}
		return resultado;
	}
	
	
	//Mostrar en pantalla la lista de personas del equipo.
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Alumno e : jugadores) {
			sb.append(e+ "\n");
		}
		
		
		return ( sb.toString()+"\n");
	}
	
	
	//Unión de equipos. El método lo llamará un equipo y se le pasará por parámetro
	//el otro equipo con el que se quiere unir. Devuelve un equipo formado por los
	//alumnos de ambos equipos.
	public String toStringUnirEquipos(Equipo equipo2) {
		for(Alumno e : this.jugadores) {
			nuevoEquipo.add(e);
		}
		for(Alumno e : equipo2.jugadores) {
			nuevoEquipo.add(e);
		}
		StringBuilder sb = new StringBuilder();
		for(Alumno e : nuevoEquipo) {
			sb.append(e+ "\n");
		}
		
		
		return ( sb.toString()+"\n");
		
	}
	
	
	//Intersección de equipos.  Idem al anterior pero devuelve un equipo formado por
	//los alumnos que están en los dos equipos
	public String toStringJugadoresRepetidos(Equipo equipo2) {
		for(Alumno e : this.jugadores) {
			if(this.jugadores.contains(e) && equipo2.jugadores.contains(e)) {
				this.jugadoresRepetidos.add(e);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Alumno e : jugadoresRepetidos) {
			sb.append(e+ "\n");
		}
		
		
		return ( sb.toString()+"\n");
		
		
	}
	
	
	

}
