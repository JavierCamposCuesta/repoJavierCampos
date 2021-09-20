package proyectos;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ProyectoTest {
	
	Proyecto proyecto1;
	
	@BeforeEach
	public  void init() throws FechaInicialFinalNoValidaException, FechaInicialProyectoNoValidaException {
        proyecto1 = new Proyecto("Proyectito1", LocalDate.of(2021, 6, 10), LocalDate.of(2021, 9, 10));
        
    }

	@Test
	void testProyecto() {
		
		//Compruebo que las exceptiones del constructor funcionan perfectamente
		try {
			Proyecto proyecto2= new Proyecto("p2", LocalDate.of(2020, 6, 10), LocalDate.of(2021, 9, 10));
			fail();
		} catch (FechaInicialFinalNoValidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FechaInicialProyectoNoValidaException e) {
			// TODO Auto-generated catch block
			fail();
		}
		
		try {
			Proyecto proyecto2= new Proyecto("p2", LocalDate.of(2021, 6, 10), LocalDate.of(2020, 9, 10));
			fail();
		} catch (FechaInicialFinalNoValidaException e) {
			// TODO Auto-generated catch block
			fail();
		} catch (FechaInicialProyectoNoValidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Test
	void testAddTarea() {
		
		//Con una fecha valida y una cantidad de dias valida no debe fallar
		try {
			proyecto1.addTarea("Tarea1", LocalDate.of(2021, 07, 10), 10);
		} catch (FechaInicialTareaNoValidaException e) {
			fail();
		} catch (DuracionTareaNoValidoException e) {
			fail();
		}
		
		
		//Comprobamos que ha añadido la tarea con el toString
		assertEquals("Proyecto Proyectito1 con código 0. Fecha de comienzo 2021-06-10. Fecha final:2021-09-10\n"
				+ "Task Tarea1, Fecha inicio=2021-07-10, duración=10.En proceso\n", proyecto1.toString() );
		
//		Si la duración es negativa, lanzará una exception
		try {
			proyecto1.addTarea("Tarea1", LocalDate.of(2021, 07, 10), -10);
			fail();
		} catch (FechaInicialTareaNoValidaException e) {
			// TODO Auto-generated catch block
			fail();
		} catch (DuracionTareaNoValidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Si la fecha es anterior a la fecha de inicio del proyecto lanzará una exception
		try {
			proyecto1.addTarea("Tarea1", LocalDate.of(2021, 05, 10), 10);
			fail();
		} catch (FechaInicialTareaNoValidaException e) {
			e.printStackTrace();
		} catch (DuracionTareaNoValidoException e) {
			fail();
		}
		
		
//		Si la fecha es posterir a la fecha de finalizaciónd el proyecto lanzará una exception
		try {
			proyecto1.addTarea("Tarea1", LocalDate.of(2021, 10, 10), 10);
			fail();
		} catch (FechaInicialTareaNoValidaException e) {
			
			e.printStackTrace();
		} catch (DuracionTareaNoValidoException e) {
			fail();
		}
		
		
	}

	@Test
	void testDelTask() {
//		Borra la tarea que tiene el concepto que se la pasa por argumento.
		//Primero le añado una tarea para poder eliminarla;
		try {
			proyecto1.addTarea("Tarea1", LocalDate.of(2021, 07, 10), 10);
		} catch (FechaInicialTareaNoValidaException e) {
			fail();
		} catch (DuracionTareaNoValidoException e) {
			fail();
		}
		
		//Eliminar el Tarea2 deberia de mostrar false porque no existe
		assertFalse(proyecto1.delTask("Tarea2"));
		
		//Eliminar el Proyectito2 debería de salir true
		assertTrue(proyecto1.delTask("Tarea1"));
		
		//Este test falla porque el metodo no es correcto
		
		//Compruebo que ha eliminado la tarea
		assertEquals("Proyecto Proyectito1 con código 0. Fecha de comienzo 2021-06-10. Fecha final:2021-09-10\n", proyecto1.toString());
		
		
		
	}

	@Test
	void testEndTask() {
		//Primero le añado una tarea para poder finalizarla;
				try {
					proyecto1.addTarea("Tarea1", LocalDate.of(2021, 07, 10), 10);
				} catch (FechaInicialTareaNoValidaException e) {
					fail();
				} catch (DuracionTareaNoValidoException e) {
					fail();
				}
				
//				Si la tarea no existe y no se puede dar por finalizada devuelve false
				assertFalse(proyecto1.endTask("Tarea2"));
				
				//Si la tarea se da por finalizada devuelve true
				assertTrue(proyecto1.endTask("Tarea1"));
				
				
		
	}

	@Test
	void testToString() {
		System.out.println("Proyecto Proyectito1 con código 0. Fecha de comienzo 2021-06-10. Fecha final:2021-09-10");
		System.out.println(proyecto1.toString());
		assertEquals("Proyecto Proyectito1 con código 0. Fecha de comienzo 2021-06-10. Fecha final:2021-09-10\n", proyecto1.toString());
	}

}
