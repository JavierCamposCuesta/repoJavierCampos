package IntroJunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import IntroJUnit.Aritmetica;

class AritmeticaTest {
	
	private static Aritmetica aritmetica;
	
	@BeforeAll
    public static void init() {
        aritmetica = new Aritmetica();
    }
	
	@Test
	void testSuma() {
		assertEquals(2, aritmetica.suma(1, 1));
	}


	@Test
	void testResta() {
		assertEquals(2, aritmetica.resta(4, 2));
	}

	@Test
	void testMultiplicacion() {
		assertEquals(4, aritmetica.multiplicacion(2, 2));
	}

	@Test
	void testDivision() {
		assertEquals(2, aritmetica.division(6, 3));
	}

	@Test
	void testGetUltimaResultado() {
		aritmetica.division(6, 3);
		assertEquals(2, aritmetica.getUltimaResultado());
	}

}
