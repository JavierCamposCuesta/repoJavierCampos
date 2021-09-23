package aplicacionPlanificadorTareas;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;







public class Tarea {
	
	//Utilizaré el tipo de coleccion Hashset, porque así me aseguro que las tareas no se van a repetir, además tendremos dos listas,
	// una para las tareas no realizadas y otra para las si realizadas
	
	private HashSet<TareaAbstract> tareasNoRealizadas;
	private HashSet<TareaAbstract> tareasRealizadas;
	
	
	public Tarea() {
		tareasNoRealizadas = new HashSet<TareaAbstract>();
		tareasRealizadas = new HashSet<TareaAbstract>();
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
			if(e.prioridad.equals(Prioridad.ALTA)) {
				alta++;
			}
			else if(e.prioridad.equals(Prioridad.MEDIA)) {
				media++;
			}
			else {
				baja++;
			}
		}
		
		return ("Tenemos pendiente "+alta + " tareas de prioridad alta, " + media + 
				" de prioridad media y " + baja +" de prioridad baja");
	}
	
	
	
//	Método que no devolverá nada, y añadirá la tarea que tiene la descripción y la fecha de creación
//	que reciba como argumento a la lista de tareas resueltas y asignara la fecha de solución que se le pasa
//	también por parámetro. Si la fecha de solución que recibe es menor que la fecha de creación, o no existe
//	la tarea, se mostrará una excepción correspondiente para cada caso.
	
	public void resolverTarea (String descripcion, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
		boolean fin= false;
		
		if(fechaFin.isBefore(fechaInicio)) {
			throw new ExceptionFechaSolucionInvalidad();
		}
			Iterator <TareaAbstract> iterator = tareasNoRealizadas.iterator();
			while(iterator.hasNext() && fin==false) {
				TareaAbstract e = iterator.next();
				if(e.descripcion.equals(descripcion) && e.fechaInicio.equals(fechaFin)) {
					e.fechaFin=fechaFin;
					tareasRealizadas.add(e);
					tareasNoRealizadas.remove(e);
					fin=true;
				}
			}
			if(fin==false) {
				throw new ExceptionNoExisteTarea();
			}
		}
	}


	



