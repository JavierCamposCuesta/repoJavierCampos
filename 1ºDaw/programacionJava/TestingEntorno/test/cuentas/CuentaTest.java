package cuentas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import IntroJUnit.Aritmetica;

class CuentaTest {
	
	static Cuenta cuenta1;
	@BeforeEach
	public  void init() throws IngresoNegativoException {
        cuenta1 = new Cuenta("100", "Javier");
        cuenta1.ingresar("Ingreso inicio", 100);
    }

	@Test
	void testIngresar() {
	try {
		cuenta1.ingresar("Ingreso prueba", 100);
	} catch (IngresoNegativoException e) {
		e.printStackTrace();
	}
	
	assertEquals(200, cuenta1.getSaldo());
		
	}
	
	@Test
	void testIngresarException() {
	try {
		cuenta1.ingresar("Ingreso prueba", -100);
		fail();
	} catch (IngresoNegativoException e) {
		e.printStackTrace();
	}
	}

	@Test
	void testRetirar() {
		try {
			cuenta1.retirar("Retiro prueba", 50);
		} catch (IngresoNegativoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(50, cuenta1.getSaldo());
	}
	
	@Test
	void testRetirarNegativo() {
		try {
			cuenta1.retirar("Retiro prueba", -50);
			fail();
		} catch (IngresoNegativoException e) {
			e.printStackTrace();
		} catch (SaldoInsuficienteException e) {
			fail();
		}
	}
	
	@Test
	void testRetirarSaldoInsuficiente() {
		try {
			cuenta1.retirar("Retiro prueba", 550);
			fail();
		} catch (IngresoNegativoException e) {
			fail();
		} catch (SaldoInsuficienteException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testAddMovimiento() {
		
		//Le insertamos un movimiento
		Movimiento m=new Movimiento();
		m.setConcepto("Concepto prueba");
		m.setImporte(-100);
		
		cuenta1.addMovimiento(m);
		
		//Tenemos que tener dos movimientos porque al crear la cuenta con un saldo inicial
		//ya tenemos el primer movimiento
		assertEquals(2, cuenta1.mMovimientos.size());
		
		
		//Comprobamos que al añadir otroa ingreso se añade tambien otro movimiento
		try {
			cuenta1.ingresar("Ingreso prueba", 100);
		} catch (IngresoNegativoException e) {
			e.printStackTrace();
		}
		
		assertEquals(3, cuenta1.mMovimientos.size());
		
		//Probamos tambien que el concepto se añade correctamente
		assertEquals("Concepto prueba",m.getConcepto());
		
	}

}
