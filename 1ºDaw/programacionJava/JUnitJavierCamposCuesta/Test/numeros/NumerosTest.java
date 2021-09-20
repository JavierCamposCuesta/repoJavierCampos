package numeros;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



class NumerosTest {

	static Stream<Arguments> parametrosEquals(){
		return Stream.of(
				Arguments.of(10, 15, false, 10, 15, true, false, 25),
				Arguments.of(3, 6, false, 2, 7, true, true, 9 ),
				Arguments.of(7, 17, true, 5, 47, true,  true, 24 ),
				Arguments.of(7, 50, false, 8, 10, false,  false, 57 ),
				Arguments.of(7, 50, false, 8, 51, false,  false, 57 ),
				Arguments.of(7, 50, false, 7, 10, false,  false, 57 ),
				Arguments.of(7, 50, false, 6, 10, false,  false, 57 ),
				Arguments.of(7, 50, false, 8, 60, false,  false, 57 ),
				Arguments.of(4, 8, false, 2, 7, false,  false, 12 )
				
				
				);
				
	}

	@ParameterizedTest
	@MethodSource("parametrosEquals")
	public void testNumeros (int x, int  y, boolean resultadoPrimos, int limInferior, int limSuperior, boolean excluyeLimites, boolean incluyeLimites, int suma ) {
		Numeros numero1 = new Numeros(x, y);
		
		
		
			assertEquals(resultadoPrimos, numero1.primos());
			assertEquals(excluyeLimites, numero1.intervaloAbierto(limInferior, limSuperior));
			assertEquals(incluyeLimites, numero1.intervaloCerrado(limInferior, limSuperior));
			assertEquals(suma, numero1.suma());
		
		
	}

}
