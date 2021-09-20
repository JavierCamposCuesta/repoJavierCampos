package empleado;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



class EmpleadoTest {

	//Probamos el equals
	static Stream<Arguments> parametrosEquals(){
		return Stream.of(
				Arguments.of("javier", "apellido3", 20, 2000.0, "javier", "apellido3", 25, 2010.0, true),
				Arguments.of("javier", "apellido3", 20, 2000.0, "antonio", "apellido3", 25, 2010.0, false)
				);
				
	}
	
	@ParameterizedTest
	@MethodSource("parametrosEquals")
	public void testEquals(String nombre, String apellido, int edad, double salario, String nombre2, String apellido2, int edad2, 
			double salario2, boolean resultado) {
		Empleado empleado1 = new Empleado(nombre, apellido, edad, salario);
		Empleado empleado2 = new Empleado(nombre2, apellido2, edad2, salario2);
		
		assertEquals(resultado, empleado1.equals(empleado2));
		
	}
	
	//Probamos el compareTo
	static Stream<Arguments> parametrosCompareTo(){
		return Stream.of(
				Arguments.of("javier", "apellido3", 20, 2000.0, "javier", "apellido3", 25, 2010.0, -1),
				Arguments.of("javier", "apellido3", 25, 2000.0, "antonio", "apellido3", 20, 2010.0, 1),
				Arguments.of("javier", "apellido3", 25, 2000.0, "antonio", "apellido3", 25, 2010.0, 0)
				);
				
	}
	
	@ParameterizedTest
	@MethodSource("parametrosCompareTo")
	public void testCompareTo(String nombre, String apellido, int edad, double salario, String nombre2, String apellido2, int edad2, 
			double salario2, int resultado) {
		Empleado empleado1 = new Empleado(nombre, apellido, edad, salario);
		Empleado empleado2 = new Empleado(nombre2, apellido2, edad2, salario2);
		
		assertEquals(resultado, empleado1.compareTo(empleado2));
		
	}
	
	
	//probamos el plusTest
	static Stream<Arguments> parametrosPlus(){
		return Stream.of(
				Arguments.of("javier", "apellido3", 50, 2000.0, true, 200.0, 2200 ),
				Arguments.of("javier", "apellido3", 20, 2000.0, false, 200.0, 2000 )
				);
				
	}
	
	@ParameterizedTest
	@MethodSource("parametrosPlus")
	public void testPlus(String nombre, String apellido, int edad, double salario,  
			boolean resultado, double incremento, double nuevoSalario) {
		Empleado empleado1 = new Empleado(nombre, apellido, edad, salario);
		
		assertEquals(resultado, empleado1.plus(incremento));
		assertEquals(nuevoSalario, empleado1.getSalario());
		
		
	}

}
