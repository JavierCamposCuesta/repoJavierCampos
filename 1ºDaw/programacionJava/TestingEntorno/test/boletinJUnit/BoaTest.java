package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoaTest {

	@Test
	void testIsHealthy() {
		Boa boa2 = new Boa("Marylin", 300, "granola bars" );
		assertTrue(boa2.isHealthy());
	}

	@Test
	void testFitsInCage() {
		Boa boa1 = new Boa("Marylin", 300, "niños" );
		assertTrue(boa1.fitsInCage(400));
	}

}
