package aplicacionPlanificadorTareas;

import java.time.LocalDate;



public class Main {
	public static void main(String[] args) {
		Tarea e = new Tarea();
		
		
		System.out.println(e.addTareaOtroTipo("Resolver problemas", "alta", "Torrente", "Burguillos"));
		System.out.println(e.addTareaOtroTipo("Limpiar cristales", "baja", "Belen Esteban", "Brenes"));
		System.out.println(e.addTareaClase("Hacer contabilidad", "media", "Contabilidad"));
		System.out.println(e.addTareaClase("Hacer contabilidad", "media", "Contabilidad"));
		System.out.println(e.addTareaClase("Hacer facturas", "alta", "Finanzas"));
		
		
		//Como la fecha de inicio se introduce automaticamente la fecha del sistema cuando crear esa tarea
		// al comparar por fechas no vemos claramente si funciona, pero debería. Esto podríamos corregirlo,
		// si en vez de utilizar LocalDate utilizara LocalDateTime, y entonces al tener en cuenta hasta los segundos si se ordenaria bien 
		//hasta siendo de las misma fecha
		System.out.println(e.mostrarTareas());
		
		//Por prioridad vemos como si lo ordena perfectamente
		System.out.println(e.mostrarTareasPorPrioridad());
		
		//Comprobamos que efectivamente cuenta el numero de tareas
		System.out.println(e.numeroTareasPendientes());
		try {
			e.resolverTarea("Hacer facturas", LocalDate.now(), LocalDate.of(2021, 9, 23));
		} catch (Exception e1) {
			
			System.out.println(e1.getMessage());
		}
		
		//vemos como al resolver una tarea se elimina de la lista de tareas sin realizar, lo comprobamos
		// por ejemplo llamando al metodo de contar las prioridades
		System.out.println(e.numeroTareasPendientes());
		
		
		//Ahora le metemos una descripcion que no se corresponde con ninguna tarea, vemos como salta la exception
		try {
			e.resolverTarea("Hacer facturas gdsgfdgfdsg", LocalDate.now(), LocalDate.of(2021, 9, 23));
		} catch (Exception e1) {
			
			System.out.println(e1.getMessage());
		}
		
		System.out.println(e.numeroTareasPendientes());
		
		
		//Aqui comprobamos que salta la excepcion cuando la fecha de solucion es anterior a la fecha de creacion
		try {
			e.resolverTarea("Hacer contabilidad", LocalDate.now(), LocalDate.of(2021, 1, 1));
		} catch (Exception e1) {
			
			System.out.println(e1.getMessage());
		}
		
		System.out.println(e.numeroTareasPendientes());
		
	

	}
}
