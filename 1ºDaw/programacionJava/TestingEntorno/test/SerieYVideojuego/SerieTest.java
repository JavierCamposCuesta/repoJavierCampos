package SerieYVideojuego;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import IntroJUnit.Aritmetica;

class SerieTest {
	
	private static Serie serie1;
	private static Serie serie2;
	private static Serie serie3;
	private static Serie serie4;
	
	@BeforeAll
    public static void init() {
        serie1 = new Serie("Torrente", 5, "Comedia", "Santiago Segura");
        serie2 = new Serie("Puente Viejo", 15, "Drama", "Belen Esteban");
        serie3 = new Serie("Bandolero", 10, "Dibujitos", "Tragabuche");
        serie4 = new Serie("Bandolero", 9, "Dibujitos", "Tragabuche");
    }

	@Test
	void testGetTitulo() {
		assertEquals("Torrente", serie1.getTitulo());
	}

	@Test
	void testSetTitulo() {
		serie2.setTitulo("Malasangre");
		assertEquals("Malasangre", serie2.getTitulo());
	}

	

	@Test
	void testEntregar() {
		serie1.entregar();
		assertTrue(serie1.isEntregado());
	}

	@Test
	void testDevolver() {
		serie1.devolver();;
		assertFalse(serie1.isEntregado());
	}

	@Test
	void testIsEntregado() {
		serie1.entregar();
		assertTrue(serie1.isEntregado());
	}

	@Test
	void testCompareTo() {
		assertEquals(serie1.MENOR, serie1.compareTo(serie2));
		assertEquals(serie1.MAYOR, serie2.compareTo(serie1));
	}

	@Test
	void testToString() {
		assertEquals("Informacion de la Serie: \n" +
                "\tTitulo: "+serie1.getTitulo()+"\n" +
                "\tNumero de temporadas: "+serie1.getnumeroTemporadas()+"\n" +
                "\tGenero: "+serie1.getGenero()+"\n" +
                "\tCreador: "+serie1.getcreador(), serie1.toString());
		;
	}

	@Test
	void testEqualsSerie() {
		assertTrue( serie3.equals(serie4));
		assertFalse(serie2.equals(serie4));
	}

	@Test
	void testSerie() {
		fail("Not yet implemented");
	}

	@Test
	void testSerieStringString() {
		fail("Not yet implemented");
	}

	@Test
	void testSerieStringIntStringString() {
		fail("Not yet implemented");
	}

}
