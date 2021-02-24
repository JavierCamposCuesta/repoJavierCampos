package prueba;

public class MaquinaCafe {
	public final static double PRECIO_CAFE = 1;
	public final static double PRECIO_CAFE_LECHE = 1.5;
	public final static double PRECIO_LECHE = 0.8;
	
	public final static int DEPOSITO_VASOS = 80;
	public final static int DEPOSITO_BEBIDAS = 50;
	public final static double MONEDERO_INICIAL = 50;
	
	private int depositoCafe;
	private int depositoLeche;
	private int depositoVasos;
	private double monedero;
	

	

	/**
	 * Constructor con un monedero inicial pasado como argumento
	 * @param monedero
	 */
	public MaquinaCafe(double monedero) {
		super();
		this.monedero = monedero;
		llenarDepositos();
	}

	/**
	 * Constructor sin argumentos. Llama al anterior a través de this()
	 */
	public MaquinaCafe() {
		this(MONEDERO_INICIAL);
	}
	
			
	
	/**
	 * Vacía el monedero de la máquina de café
	 */
	public void vaciarMonedero() {
		this.monedero = 0;
	}
	
	/**
	 * Llena todos los depósitos de la máquina de café
	 */
	public void llenarDepositos() {
		this.depositoCafe=DEPOSITO_BEBIDAS;
		this.depositoLeche=DEPOSITO_BEBIDAS;
		this.depositoVasos=DEPOSITO_VASOS;
	}
	
	
	/**
	 * Actualiza el monedero si existe cantidad para proporcionar el cambio y devuelve un 
	 * mensaje indicando la cantidad devuelta
	 * @param cantidadIntroducida por el cliente
	 * @param precio de la bebida
	 * @return mensaje con el cambio devuelto
	 * @throws Exception si no existe cantidad suficiente para dar el cambio
	 */
	public String darCambio(double cantidadIntroducida, double precio) throws Exception {
		double cambio = 0;
		
		if(cantidadIntroducida < precio) {
			throw new Exception("La cantidad introducida es insuficiente.");
		}else if ((cantidadIntroducida-precio) > this.monedero) {
			throw new Exception("No tenemos suficiente cambio. ");
		}else {
			cambio = cantidadIntroducida - precio;
		}
		this.monedero-=cambio;
		
		return String.format("Su cambio es de %.2f euros", cambio);
	}
	
	/**
	 * Comprueba si los depósitos de café y vasos tienen existencias
	 * @return true si hay vasos y café disponible
	 * @throws Exception excepción con el mensaje específico
	 */
	public boolean esPosibleServirCafe() throws Exception {
		boolean esPosibleServir = true;
		if(this.depositoCafe <=  0) {
			esPosibleServir = false;//no necesaria
			throw new Exception("Lo sentimos, no queda café. ");
		}else if(this.depositoVasos <= 0) {
			esPosibleServir = false;//no necesaria
			throw new Exception("Lo sentimos, no quedan vasos. ");
		}
		return esPosibleServir;
	}
	
	/**
	 * Comprueba si los depósitos de leche y vasos tienen existencias
	 * @return true si hay vasos y leche disponible
	 * @throws Exception excepción con el mensaje específico
	 */	
	public boolean esPosibleServirLeche() throws Exception {
		boolean esPosibleServir = true;
		if(this.depositoLeche <=  0) {
			esPosibleServir = false;//no necesaria
			throw new Exception("Lo sentimos, no queda leche. ");
		}else if(this.depositoVasos <= 0) {
			esPosibleServir = false;//no necesaria
			throw new Exception("Lo sentimos, no quedan vasos. ");
		}
		return esPosibleServir;
	}
	
	/**
	 * Comprueba si los depósitos de café, leche y vasos tienen existencias
	 * @return true si hay vasos, leche y café disponible
	 * @throws Exception excepción con el mensaje específico
	 */	
	public boolean esPosibleServirCafeConLeche() throws Exception {
		boolean esPosibleServir = true;
		if(this.depositoLeche <=  0) {
			esPosibleServir = false;//no necesaria
			throw new Exception("Lo sentimos, no queda leche. ");
		}else if(this.depositoCafe <= 0) {
			esPosibleServir = false;//no necesaria
			throw new Exception("Lo sentimos, no queda café. ");
		}else if(this.depositoVasos <= 0) {
			esPosibleServir = false;//no necesaria
			throw new Exception("Lo sentimos, no quedan vasos. ");
		}
		return esPosibleServir;	}
	
	/**
	 * Actualiza el estado de la máquina cuando se sirve café
	 */
	public void servirCafe() {
		this.depositoCafe--;
		this.depositoVasos--;
		this.monedero+=PRECIO_CAFE;

	}

	/**
	 * Actualiza el estado de la máquina cuando se sirve café con leche
	 */

	public void servirCafeConLeche(){
		this.depositoCafe--;
		this.depositoLeche--;
		this.depositoVasos--;
		this.monedero+=PRECIO_CAFE_LECHE;
	}
	
	/**
	 * Actualiza el estado de la máquina cuando se sirve leche
	 */
	public void servirLeche() throws Exception{
		this.depositoLeche--;
		this.depositoVasos--;
		this.monedero+=PRECIO_LECHE;
	}
	

	/**
	 * Nos proporciona información sobre el estado de la máquina
	 */
	@Override
	public String toString() {
		return "Existen: "+ this.depositoLeche + " dosis de leche, "
				+ this.depositoCafe + " dosis de café "
				+ this.depositoVasos + " vasos y "
				+ this.monedero + " euros. ";
	}
	
	public boolean equals(Object obj) {
		boolean equals = false;
		
		if(this==obj) {
			equals = true;
			
		}else if (obj instanceof MaquinaCafe) {
			MaquinaCafe otraMaquina = (MaquinaCafe) obj;
			equals = (this.depositoCafe==otraMaquina.depositoCafe
						&& this.depositoLeche == otraMaquina.depositoLeche
						&& this.depositoVasos == otraMaquina.depositoVasos
						&& this.monedero == otraMaquina.monedero
					);
			
		}
		return equals;
}
}
