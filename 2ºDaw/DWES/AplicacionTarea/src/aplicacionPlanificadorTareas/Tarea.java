package aplicacionPlanificadorTareas;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import gestionTareas.PrioridadTarea;



public class Tarea {
	
	//Utilizaré el tipo de coleccion Hashset, porque así me aseguro que las tareas no se van a repetir, además tendremos dos listas,
	// una para las tareas no realizadas y otra para las si realizadas
	
	private HashSet<TareaAbstract> tareasNoRealizadas;
	private HashSet<TareaAbstract> tareasRealizadas;
	
	public void Tarea() {
		this.tareasNoRealizadas = new HashSet<TareaAbstract>();
		this.tareasRealizadas = new HashSet<TareaAbstract>();
	}
	
	
	//Tendremos métodos para añadir tareas, serán dos, uno para añadir una tarea educativa o otro para tareas de otro tipo
	//Ambos métodos devolverán true si se puede añadir la tarea, o false en caso contrario
	
	//Metodo para las tareas de clase
	public boolean addTareaClase(String descripcion, String prioridad, String asignatura) {
		return tareasNoRealizadas.add(new TareaDeClase(descripcion, prioridad, asignatura));
		
	}
	
	//Método para otro tipos de tareas
	public boolean addTareaOtroTipo ( String descripcion, String prioridad, String descripcionDetallada, String ubicacion) {
		return tareasNoRealizadas.add(new TareaDeOtroTipo(descripcion, prioridad, descripcionDetallada, ubicacion));
	}
	
	
	//Método para mostrar un String con el listado de tareas pendientes de realizar ordenadas por fecha de creacion.
	public String mostrarTareas() {
		StringBuilder sb = new StringBuilder();
		
		//Para poder ordenar la lista primero tenemos que convertirla en ArrayList
		List<TareaAbstract> listaTareas = new ArrayList<TareaAbstract>(tareasNoRealizadas); 
		Collections.sort(listaTareas);
		
		for(TareaAbstract e: listaTareas) {
			sb.append(e.toString() + "\n");
		}
		
		return sb.toString();
	}
	
//	Método para mostrar un String con la lista de tareas existentes ordenadas de forma que salgan primero las tareas de prioridad alta, 
	// luego las de media y por último las de baja prioridad. Cuando tengan la misma prioridad se ordenarán alfabéticamente.
	public String mostrarTareasPorPrioridad() {
		StringBuilder sb = new StringBuilder();
		
		//Para poder ordenar la lista primero tenemos que convertirla en ArrayList
		List<TareaAbstract> listaTareas = new ArrayList<TareaAbstract>(tareasNoRealizadas); 
		
		Collections.sort(listaTareas, new OrdenarPorPrioridad());
		
		for(TareaAbstract e: listaTareas) {
			sb.append(e.toString() + "\n");
		}
		
		return sb.toString();
	}
	
	
//	Metodo para devolver un String en el que se muestre el número de tareas
//	pendientes de cada tipo, es decir, algo así como : “Alta- 3, Media-10, Baja-2” 
//	si tenemos pendiente 3 tareas de prioridad alta, 10 de prioridad media y 2 de prioridad baja
	public String numeroTareasPendientes() {
		int alta=0;
		int media=0;
		int baja=0;
		
		for(TareaAbstract e : tareasNoRealizadas) {
			if(e.prioridad.equals(PrioridadTarea.ALTA)) {
				alta++;
			}
			else if(e.prioridad.equals(PrioridadTarea.MEDIA)) {
				media++;
			}
			else {
				baja++;
			}
		}
		
		return ("Tenemos pendiente "+alta + " tareas de prioridad alta, " + media + 
				" de prioridad media y " + baja +" de prioridad baja");
	}

}
