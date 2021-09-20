package ShoppingCart;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ShoppingCartTest {
	
	
	private static ShoppingCart carrito2;
	private static Product producto1;
	private static Product producto2;
	private static Product producto3;
	private static Product producto4;
	
	@BeforeEach
    public void init() {
		
		carrito2 = new ShoppingCart();
		producto1 = new Product("Galletas", 3.5);
		producto2 = new Product("Tomate frito", 1.5);
		producto3 = new Product("Salchichas", 2);
		producto4 = new Product("Mortadela", 0.75);
	
		
    }

	@Test
	void testNuevoCarro() {
		ShoppingCart carrito1 = new ShoppingCart();
		assertEquals(0, carrito1.getItemCount());
		
	}
	
	@Test
	void testCarroVacio() {
	
		assertEquals(0, carrito2.getItemCount());
		
	}

	@Test
	void testGetBalance() {
		carrito2.addItem(producto1);
		assertEquals(producto1.getPrice(), carrito2.getBalance());
		double cantidadCarrito = carrito2.getBalance();
		
		//Comprobaré ahora si al añadirle nuevos productos al carrito el total es igual al carrito
		//anterior mas los precios de los nuevos productos
		
		carrito2.addItem(producto2);
		carrito2.addItem(producto3);
		carrito2.addItem(producto4);
		
		assertEquals((cantidadCarrito+producto2.getPrice()+producto3.getPrice()+producto4.getPrice()), carrito2.getBalance());
	}

	
	//Añadimos elementos al carrito y vemos si la cantidad de productos se va incrementando
	@Test
	void testAddItem() {
		carrito2.addItem(producto1);
		assertEquals(1, carrito2.getItemCount());
		
		carrito2.addItem(producto2);
		carrito2.addItem(producto3);
		carrito2.addItem(producto4);
		
		assertEquals(4, carrito2.getItemCount());
		
	
	}

	@Test
	void testRemoveItem() {
		carrito2.addItem(producto2);
		carrito2.addItem(producto3);
		carrito2.addItem(producto4);
		
		try {
			carrito2.removeItem(producto2);
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(2, carrito2.getItemCount());
		
	}
	
	@Test
	void testRemoveItemException() {
		carrito2.addItem(producto2);
		carrito2.addItem(producto3);
		carrito2.addItem(producto4);
		
		
		//Aqui pruebo que la exception funcione, para esto incluyo un fail despues del metodo
		// que deberia de soltar la exception, en el caso de que la exception no funcionase 
		//pasaría a la siguiente linea que es el fail y daria el error en el test.
		try {
			carrito2.removeItem(producto1);
			fail();
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

	

}
