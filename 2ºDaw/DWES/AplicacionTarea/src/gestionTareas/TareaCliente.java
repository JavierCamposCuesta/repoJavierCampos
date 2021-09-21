package gestionTareas;

public class TareaCliente extends TareaAbstract{
	private String nombreCliente;
	private String ciudadCliente;
	
	public TareaCliente(String descripcion, String prioridad, String cliente, String localidad) {
		super(descripcion, prioridad);
		this.nombreCliente=cliente;
		this.ciudadCliente=localidad;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "TareaCliente [nombreCliente=" + nombreCliente + ", ciudadCliente=" + ciudadCliente +
				super.toString();
	}




//Los datos del cliente y ciudad se podrán consultar y modificar.
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getCiudadCliente() {
		return ciudadCliente;
	}
	public void setCiudadCliente(String ciudadCliente) {
		this.ciudadCliente = ciudadCliente;
	}
	
	

}
