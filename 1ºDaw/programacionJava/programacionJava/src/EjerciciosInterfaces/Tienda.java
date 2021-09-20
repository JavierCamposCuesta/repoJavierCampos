package EjerciciosInterfaces;

public class Tienda implements LocalComercial {

	
	private double largo;
	private double ancho;
	private String actividad; 
	
	private int cantidadProducto;
	
	public Tienda(double largo, double ancho, String actividad) {
		this.largo=largo;
		this.ancho=ancho;
		this.actividad=actividad;
	}
	
	public Tienda(double largo, double ancho, String actividad, int cantidadProducto) {
		this(largo, ancho, actividad);
		this.cantidadProducto=cantidadProducto;
	}
	
	
	@Override
	public double getSuperficieEdificio() {
		return largo*ancho;
	}

	@Override
	public double getPrecioEdificio() {
		
		return getSuperficieEdificio() * PRECIO_LOCAL_COMERCIAL;
	}

	@Override
	public String actividadComercial() {
		return null;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	
}
