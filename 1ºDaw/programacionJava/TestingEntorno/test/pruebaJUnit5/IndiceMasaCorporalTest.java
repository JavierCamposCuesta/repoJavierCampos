package pruebaJUnit5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



class IndiceMasaCorporalTest {
	
	static Stream<Arguments> parametrosEquals(){
		return Stream.of(
				Arguments.of(65, 180, "Muy bien" ),
				Arguments.of(20, 180, "Tienes que engordar" ),
				
				Arguments.of(200, 150 ,"Sobrepeso")
				
				);
				
	}

	@ParameterizedTest
	@MethodSource("parametrosEquals")
	public void testDiagnostico (float peso, float altura, String resultado) {
		IndiceMasaCorporal indice1 = new IndiceMasaCorporal(peso, altura);
		
		
		try {
			assertEquals(resultado, indice1.diagnostico());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
