package gestionTareas;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Empresa e = new Empresa();
		
		System.out.println(e.addTareaCliente("Resolver problemas", "alta", "Torrente", "Burguillos"));
		System.out.println(e.addTareaCliente("Limpiar cristales", "baja", "Belen Esteban", "Brenes"));
		System.out.println(e.addTareaEmpresa("Hacer contabilidad", "media", "Contabilidad"));
		System.out.println(e.addTareaEmpresa("Hacer contabilidad", "media", "Contabilidad"));
		System.out.println(e.addTareaEmpresa("Hacer facturas", "alta", "Finanzas"));
		
		
		//Como la fecha de inicio se introduce automaticamente la fecha del sistema cuando crear esa tarea
		// al comparar por fechas no vemos claramente si funciona, pero debería. Esto podríamos corregirlo,
		// si en vez de utilizar LocalDate utilizara LocalDateTime, pero por falta de tiempo no lo voy a hacer
		// pero sería simplemente eso, y entonces al tener en cuenta hasta los segundos si se ordenaria bien 
		//hasta siendo de las misma fecha
		System.out.println(e.mostrarTareas());
		
		//Por prioridad vemos como si lo ordena perfectamente
		System.out.println(e.mostrarTareasPrioridad());
		
		//Comprobamos que efectivamente cuenta el numero de tareas
		System.out.println(e.numTareasPendientes());
		try {
			e.resolverTarea("Hacer facturas", LocalDate.now(), LocalDate.of(2021, 12, 12));
		} catch (Exception e1) {
			
			System.out.println(e1.getMessage());
		}
		
		//vemos como al resolver una tarea se elimina de la lista de tareas sin realizar, lo comprobamos
		// por ejemplo llamando al metodo de contar las prioridades
		System.out.println(e.numTareasPendientes());
		
		
		//Ahora le metemos una descripcion que no se corresponde con ninguna tarea, vemos como salta la exception
		try {
			e.resolverTarea("Hacer facturas gdsgfdgfdsg", LocalDate.now(), LocalDate.of(2021, 12, 12));
		} catch (Exception e1) {
			
			System.out.println(e1.getMessage());
		}
		
		System.out.println(e.numTareasPendientes());
		
		
		//Aqui comprobamos que salta la excepcion cuando la fecha de solucion es anterior a la fecha de creacion
		try {
			e.resolverTarea("Hacer contabilidad", LocalDate.now(), LocalDate.of(2021, 1, 1));
		} catch (Exception e1) {
			
			System.out.println(e1.getMessage());
		}
		
		System.out.println(e.numTareasPendientes());
		
	

	}
	
	

}
