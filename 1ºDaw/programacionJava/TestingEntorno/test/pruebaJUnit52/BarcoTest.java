package pruebaJUnit52;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cuentas.Cuenta;
import cuentas.IngresoNegativoException;

class BarcoTest {
	
	static Barco barco1;
	static Barco barco2;
	static Barco barco3;
	
	@BeforeEach
	public  void init() throws IngresoNegativoException {
        barco1 = new Barco("nisu","t90",15);
        barco2 = new Barco("nisu2","t902",20);
        barco3 = new Barco("nisu3","t903",15);
    }

	@Test
	void testObtenerMarca() {
		assertEquals("nisu", barco1.ObtenerMarca());
	}

	@Test
	void testObtenerEslora() {
		assertEquals(15, barco1.ObtenerEslora());
	}

	
	//El modelo no funciona porque en el constructor no se incializa, pero lo cambio en la clase
	@Test
	void testObtenerModelo() {
		assertEquals("t90", barco1.ObtenerModelo());
	}

	@Test
	void testCompareTo() {
		assertEquals(-1, barco1.compareTo(barco2));
		assertEquals(1, barco2.compareTo(barco3));
		assertEquals(0, barco1.compareTo(barco3));
		
	}
	
	@Test
	void testToString() {
		assertEquals("Marca: " + barco1.ObtenerMarca() + " Modelo: "+ barco1.ObtenerModelo() 
		+ " Eslora: " + barco1.ObtenerEslora(), barco1.toString());
	}

}
