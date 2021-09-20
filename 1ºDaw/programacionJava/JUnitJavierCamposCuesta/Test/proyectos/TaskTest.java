package proyectos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {


	@Test
	void testEnded() {
		
		//Para comprobar que end cambia cuando finalizas un proyecto lo hago a través del toString
		Task tarea = new Task();
		
		//Antes de finalizarlo el toString deberia ser el siguiente
		assertEquals(("Task " + tarea.getConcept() + ", Fecha inicio=" + tarea.getIniDate() 
		+ ", duración=" + tarea.getDays() + ".En proceso") , tarea.toString());
		
		tarea.ended();
		
		//Una vez finalizado el toString tiene que cambiar a el siguieten
		
		
		assertEquals(("Task " + tarea.getConcept() + ", Fecha inicio=" + tarea.getIniDate() 
				+ ", duración=" + tarea.getDays() + ".Terminado") , tarea.toString());
	}

	@Test
	void testToString() {
		Task tarea = new Task();
		
		//Antes de finalizarlo el toString deberia ser el siguiente
		System.out.println(tarea.toString());
		assertEquals(("Task " + tarea.getConcept() + ", Fecha inicio=" + tarea.getIniDate() 
		+ ", duración=" + tarea.getDays() + ".En proceso") , tarea.toString());
	}

}
