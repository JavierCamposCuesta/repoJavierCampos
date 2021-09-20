package pruebaJUnit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LuchaRobotsTest {

	
	static LuchaRobots lucha1;
	@BeforeEach
	public  void init(){
		lucha1 = new LuchaRobots("Benito Villamarin","Antonio");
		
        
    }
	
	
	@Test
	void testLuchaRobots() {
		assertEquals(0, lucha1.getNumLuchadores());
	}

	@Test
	void testAñadeRobot() {
		lucha1.añadeRobot("R1", 150, 200);
		lucha1.añadeRobot("R2", 150, 200);
		lucha1.añadeRobot("R3", 150, 200);
		
		assertEquals(2, lucha1.getNumLuchadores());
		
	}
	@Test
	void testModificaEstadio() {
		LuchaRobots lucha2 = new LuchaRobots("Burguillos","Manolo");
		assertEquals(0, lucha2.getNumLuchadores());
		try {
			lucha2.setEstadio("Pizjuan");
		} catch (NotAllowedChangeException e) {
			
			fail();
		}
		
		
		try {
			lucha2.añadeRobot("R2", 150, 200);
			lucha2.setEstadio("Carranza");
			fail();
		} catch (NotAllowedChangeException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	

}
