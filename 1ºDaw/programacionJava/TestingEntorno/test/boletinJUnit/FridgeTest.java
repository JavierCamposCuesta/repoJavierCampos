package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class FridgeTest {
	

	@Test
	void testPut() {
		Fridge nevera = new Fridge();
		
		assertTrue(nevera.put("Lentejas"));
		assertFalse(nevera.put("Lentejas"));
	}

	@Test
	void testContains() {
		Fridge nevera = new Fridge();
		nevera.put("Macarrones");
		assertTrue(nevera.contains("Macarrones"));
		
	}

	@Test
	void testTake() {
		Fridge nevera = new Fridge();
		nevera.put("Macarrones");
		
		
	}

}
