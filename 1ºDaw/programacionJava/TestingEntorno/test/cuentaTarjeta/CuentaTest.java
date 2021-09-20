package cuentaTarjeta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaTest {
	Cuenta cuenta;
	@BeforeEach
	void init() {
		this.cuenta=new Cuenta("12345", "Javier");
	}

	
	//De esta forma probamos el metodo incluyendo las excepciones, de otra forma que se podría
	//hacer es hacer otro metodo a parte para probar las excepciones
	@Test
	void testIngresarDouble() throws Exception{
		double saldo=cuenta.getSaldo();
		try {
			cuenta.ingresar(25);
			assertEquals(saldo+25, cuenta.getSaldo());
			
			cuenta.ingresar(0);
			fail("No lanza la exception al ingresar 0");
		}
		catch(Exception e){
			
		}
		
		
		try {
			cuenta.ingresar(-1);
			fail("No lanza exception al ingresar cantidad negativa");
		}
		catch(Exception e) {
			
		}
	}
	
	

	

	@Test
	void testRetirarDouble() throws Exception{
		
		double saldo=cuenta.getSaldo();
		try {
			cuenta.retirar(25);
			assertEquals(saldo - 25, cuenta.getSaldo());
			
			cuenta.retirar(0);
			assertEquals(saldo - 0, cuenta.getSaldo());
			
			cuenta.retirar(-5);
			fail("No salta la excepcion cuando retiro una cantidad negativa");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Ahora pruebo si al retirar mas de la cantidad que tengo salta la excepcion
		cuenta.ingresar(100);
		try {
			cuenta.retirar(200);
			fail("No salta la exception cuando saco mas de la cantidad que tengo");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	void testAddMovimiento() {
		int numMovs = cuenta.mMovimientos.size();
		Movimiento mov = new Movimiento();
		cuenta.addMovimiento(mov);
		
		assertEquals(numMovs + 1, cuenta.mMovimientos.size());
	}

}
