
public abstract class Habitacion extends Instalacion{
	
	
	
	


	public Habitacion() {
		super();
		this.codigoInstalacion="Habitacion"+this.CONTADOR_INSTALACIONES;
		CONTADOR_INSTALACIONES++;
	
	}
	
	
	
	public abstract double calcularPrecioSegunTipo();

	

	
	
	

}
