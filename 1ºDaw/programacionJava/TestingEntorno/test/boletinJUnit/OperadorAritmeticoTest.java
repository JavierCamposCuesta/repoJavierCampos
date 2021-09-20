package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperadorAritmeticoTest {

	@Test
	void testSuma() {
		assertEquals(2, OperadorAritmetico.suma(1, 1));
	}

	@Test
	void testDivision() {
		try {
			assertEquals(2, OperadorAritmetico.division(4, 2));
			OperadorAritmetico.division(5, 0);
			fail("No salta la excepcion cuando el segundo parametroe es igual a 0");
		}
		catch(Exception e) {
			
		}
	}

}
