package pruebaJUnit52;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cuentas.IngresoNegativoException;

class TrenTest {

	static Tren tren1;
	
	
	@BeforeEach
	public  void init() throws IngresoNegativoException {
        tren1 = new Tren("Chuchu","Javier");
        
    }
	
	

	@Test
	void testEnganchaVagon() {
		tren1.enganchaVagon(200, 50, "zapatos");
		assertEquals(1, tren1.getNumVagones());
	}
	
	//Solo se puede añadir 5 vagones por tren
	@Test
	void testEnganchaVagonMaximo() {
		tren1.enganchaVagon(200, 50, "zapatos");
		tren1.enganchaVagon(200, 50, "zapatos2");
		tren1.enganchaVagon(200, 50, "zapatos3");
		tren1.enganchaVagon(200, 50, "zapatos4");
		tren1.enganchaVagon(200, 50, "zapatos5");
		tren1.enganchaVagon(200, 50, "zapatos6");
		
		assertEquals(5, tren1.getNumVagones());
		assertFalse(tren1.enganchaVagon(200, 50, "matute"));
	}
	

	//Al crear un tren se crea sin bagones
	@Test
	void testCrearTren() {
		Tren tren2 = new Tren("veloz","pikachu");
		assertEquals(0, tren1.getNumVagones());
	}
	
	
	//Al desenganchar un vagón el número de vagones se decrementa y lanza una excepción si no hay vagones.
	@Test
	void testDesenganchaVagon() {
		tren1.enganchaVagon(200, 50, "zapatos");
		try {
			tren1.desenganchaVagon();
		} catch (NotVagonException e) {
			e.printStackTrace();
		}
		
		assertEquals(0, tren1.getNumVagones());
		
		try {
			tren1.desenganchaVagon();
			fail();
		} catch (NotVagonException e) {
			e.printStackTrace();
		}
		
	}

	

}
