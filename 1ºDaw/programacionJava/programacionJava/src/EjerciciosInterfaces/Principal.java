package EjerciciosInterfaces;

public class Principal {

	public static void main(String[] args) {
		IEdificio casa = new Casa(30,10,3);
		System.out.println(casa.getSuperficieEdificio());
		System.out.println(casa.getPrecioEdificio());
		
		System.out.println(((Casa)casa).getHabitantes());
		
		
		Tienda mediamark = new Tienda(100, 50, "Venta productos electronica");
		LocalComercial mm = new Tienda(100, 50, "Venta productos electronica");
		IEdificio mmm = new Tienda(100, 50, "Venta productos electronica");
		
		
	}

}
