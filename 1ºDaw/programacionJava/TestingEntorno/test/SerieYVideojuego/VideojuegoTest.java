package SerieYVideojuego;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class VideojuegoTest {
	
	private static Videojuego videojuego1;
	private static Videojuego videojuego2;
	private static Videojuego videojuego3;
	private static Videojuego videojuego4;
	
	@BeforeAll
    public static void init() {
		videojuego1 = new Videojuego("Pokemon", 1050, "Animacion","Nintendo");
		videojuego2 = new Videojuego("GTAV", 800, "Violencia", "Carmen de Mairena");
		videojuego3 = new Videojuego("Cars", 2000, "Dibujitos", "El Vaquilla");
		videojuego4 = new Videojuego("Cars", 2050, "Dibujitos", "El Vaquilla");
    }

	@Test
	void testGetTitulo() {
		fail("Not yet implemented");
	}

	@Test
	void testSetTitulo() {
		fail("Not yet implemented");
	}

	@Test
	void testGetHorasEstimadas() {
		fail("Not yet implemented");
	}

	@Test
	void testSetHorasEstimadas() {
		fail("Not yet implemented");
	}

	@Test
	void testGetGenero() {
		fail("Not yet implemented");
	}

	@Test
	void testSetGenero() {
		fail("Not yet implemented");
	}

	@Test
	void testGetcompañia() {
		fail("Not yet implemented");
	}

	@Test
	void testSetcompañia() {
		fail("Not yet implemented");
	}

	@Test
	void testEntregar() {
		fail("Not yet implemented");
	}

	@Test
	void testDevolver() {
		fail("Not yet implemented");
	}

	@Test
	void testIsEntregado() {
		fail("Not yet implemented");
	}

	@Test
	void testCompareTo() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsVideojuego() {
		fail("Not yet implemented");
	}

	@Test
	void testVideojuego() {
		fail("Not yet implemented");
	}

	@Test
	void testVideojuegoStringString() {
		fail("Not yet implemented");
	}

	@Test
	void testVideojuegoStringIntStringString() {
		fail("Not yet implemented");
	}

}
