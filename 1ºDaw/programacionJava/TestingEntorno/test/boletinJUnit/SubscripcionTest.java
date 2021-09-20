package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubscripcionTest {

	
	@Test
	void testPrecioPorMes() {
		Subscripcion sub1 = new Subscripcion(4, 2);
		Subscripcion sub2 = new Subscripcion(4, -2);
		Subscripcion sub3 = new Subscripcion(4, 3);
		assertEquals(2.0, sub1.precioPorMes());
		assertEquals(0.0, sub2.precioPorMes());
		assertEquals(1.34, sub3.precioPorMes());
	}
	

	@Test
	void testCancel() {
		Subscripcion sub1 = new Subscripcion(4, 2);
		sub1.cancel();
		assertEquals(0, sub1.precioPorMes());
	}

}
