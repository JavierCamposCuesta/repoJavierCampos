package pruebaJUnit52;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import empleado.Empleado;

class BocaDeRiegoTest {

	static Stream<Arguments> parametrosEquals(){
		return Stream.of(
				Arguments.of(2, 1 ),
				Arguments.of(6, 5 )
				
				);
				
	}
	
	@ParameterizedTest
	@MethodSource("parametrosEquals")
	public void testRiega(int totalAgua, int resultado) {
		BocaDeRiego riego1 = new BocaDeRiego(totalAgua);
		try {
			riego1.riega();
		} catch (NoQuedaAguaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertEquals(resultado, riego1.getAguaDisponible());
		
	}

}
