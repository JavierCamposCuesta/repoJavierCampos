package gestionTareas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;




public class Empresa {
	
	//Utilizo el tipo de coleccion HashSet porque de esta forma me aseguro que las tareas no se van 
	//a repetir 
	private HashSet<TareaAbstract> tareasNoRealizadas;
	private HashSet<TareaAbstract> tareasRealizadas;
	
	public Empresa() {
		tareasNoRealizadas = new HashSet<TareaAbstract>();
		tareasRealizadas = new HashSet<TareaAbstract>();
	}
	
	//Devolverá truesi puede añadir una tarea de empresa y false en caso contrario
	public boolean addTareaEmpresa(String descripcion, String prioridad, String departamento) {
		
		return tareasNoRealizadas.add(new TareaEmpresa(descripcion, prioridad, departamento));
	}
	
	//devolverá true si puede añadir una tarea de un cliente y false en caso contrario.
	public boolean addTareaCliente(String descripcion, String prioridad, String cliente, String localidad) {
		
		return tareasNoRealizadas.add(new TareaCliente(descripcion, prioridad, cliente, localidad));
		}
	
	//devolverá   un   String   con   el   listado   de   tareas   pendientes   de   realizar
	//ordenados de forma ascendente por la fecha de creación.
	public String mostrarTareas() {
		StringBuilder sb = new StringBuilder();
		List<TareaAbstract> tareasNoRealizadas1 = new ArrayList<TareaAbstract>(tareasNoRealizadas);
		Collections.sort(tareasNoRealizadas1);
		for(TareaAbstract e: tareasNoRealizadas1) {
			sb.append(e.toString() + "\n");
		}
		
		return sb.toString();
		
	}
	
	
//	devolverá un String con el listado de tareas existentes ordenadosde forma que salgan 
//	primero las tareas de prioridad Alta, luego las medias y luego las bajas.Para las tareas 
//	con la misma prioridad se ordenarán de forma alfabética por la descripción.
	public String mostrarTareasPrioridad() {
		StringBuilder sb = new StringBuilder();
		List<TareaAbstract> tareasNoRealizadas1 = new ArrayList<TareaAbstract>(tareasNoRealizadas);
		Collections.sort(tareasNoRealizadas1, new OrdenarPorPrioridad());
		for(TareaAbstract e: tareasNoRealizadas1) {
			sb.append(e.toString() + "\n");
		}
		return sb.toString();
		
	}
	
//	devolverá   un   String   en   el   que   se   muestre   el   número   de   tareas
//	pendientes de cada tipo, es decir, algo así como : “Alta- 3, Media-10, Baja-2” 
//	si tenemospendiente 3 tareas de prioridad alta, 10 de prioridad media y 2 de prioridad baja
	public String numTareasPendientes() {
		int alta=0;
		int media=0;
		int baja=0;
		
		for(TareaAbstract e: tareasNoRealizadas) {
			if(e.prioridad== PrioridadTarea.ALTA) {
				alta++;
			}
			else if(e.prioridad==PrioridadTarea.MEDIA){
				media++;
			}
			else {
				baja++;
			}
		}
		return ("Tenemos pendiente "+alta + " tareas de prioridad alta, " + media + 
				" de prioridad media y " + baja +" de prioridad baja");
				
	}
	
//	Este métodono debe devolver nada y debe añadir la tarea que tiene la descripción y la fecha 
//	de creación que recibe como argumento a la lista de tareas resueltas y asignarle la fechad 
//	de soluciónque se le pasa por parámetros. Si la fecha de solución que recibe como parámetro 
//	es menorque la fecha de creación o no existe la tarea se deberá lanzar la correspondiente 
//	excepción.
	public void resolverTarea(String descripcion, LocalDate fechaCreacion, LocalDate fechaSolucion) throws Exception{
		boolean fin=false;
		
		if(fechaSolucion.isBefore(fechaCreacion)) {
			throw new ExceptionFechaSolucionInvalidad();
		}
		 
			Iterator <TareaAbstract> iterator = tareasNoRealizadas.iterator();
			while(iterator.hasNext() && fin==false) {
				TareaAbstract e = iterator.next();
				if(e.descripcion.equals(descripcion) && e.fechaAlta.equals(fechaCreacion)) {
					e.fechaSolucion=fechaSolucion;
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
