package relacionDeProblemas7;

public class PrincipalProducto {

	public static void main(String[] args) {
		Producto television= new Producto("Television", 500);
		Producto television2= new Producto("Television", 500);
		Producto radio= new Producto("Radio", 20);
		
		
		radio.setIva(21);
		System.out.println(television);
		System.out.println("-------------------------------");
		System.out.println(radio);
		System.out.println("-------------------------------");
		System.out.println(television.precioVenta());
		System.out.println("-------------------------------");
		System.out.println(television.hashCode());
		System.out.println(television2.hashCode());
		
	}

}
