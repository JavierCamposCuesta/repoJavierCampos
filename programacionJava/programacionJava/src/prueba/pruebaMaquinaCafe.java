package prueba;

import java.util.Scanner;

public class pruebaMaquinaCafe {
	//Atributos
	private int depositoCafe;
	private int depositoLeche;
	private int depositoVasos;
	private double monedero;
	private double cambio;
	private double pago;
	private String resultado;
	
	public static final int PRECIO_CAFE=1;
	public static final double PRECIO_LECHE = 0.8;
	public static final double PRECIO_CAFE_CON_LECHE=1.5;
	
	Scanner teclado= new Scanner(System.in);
	
	//Constructores 
	
	public pruebaMaquinaCafe(double monedero) {
		llenarMaquina();
		this.monedero=monedero;
	}
	
	
	public void llenarMaquina() {
		this.depositoCafe=50;
		this.depositoLeche=50;
		this.depositoVasos=80;

	}
	
	public String servirCafe() throws Exception {
		System.out.println("El cafe cuesta: "+ PRECIO_CAFE+ " introduzca el pago: ");
		this.pago = Double.parseDouble(teclado.nextLine());
		if (this.depositoCafe<= 0 || this.depositoVasos<=0) {
			throw new Exception("No es posible servir porque no nos quedan existencias");
			
		}
		else if (pago<PRECIO_CAFE) {
			throw new Exception("La cantidad introducida no es suficiente");
		}
		return resultado;
		
	}	

}
