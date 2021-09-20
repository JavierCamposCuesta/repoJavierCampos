package pruebaJUnit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




class RobotTest {
	
	
	static Robot robot1;
	@BeforeEach
	public  void init(){
		robot1 = new Robot("R1",100,150);
        
    }


	@Test
	void testGetID() {
		assertEquals("R1", robot1.getID());
	}

	@Test
	void testGetVida() {
		assertEquals(100, robot1.getVida());
	}

	@Test
	void testToString() {
		assertEquals("ID: " + robot1.getID() + " Porcentaje de vida: " + robot1.getVida(), robot1.toString());
	}

	@Test
	void testCompareTo() {
		Robot robot2 = new Robot("R2", 200,300);
		assertTrue(robot2.compareTo(robot1)>0);
	}

	@Test
	void testGetFuerza() {
		assertEquals(150, robot1.getFuerza());
	}

	@Test
	void testSetFuerza() {
		robot1.setFuerza(200);
		assertEquals(200, robot1.getFuerza());
	}

}
