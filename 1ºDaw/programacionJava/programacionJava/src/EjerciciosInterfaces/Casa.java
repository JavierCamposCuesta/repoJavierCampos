package EjerciciosInterfaces;

public class Casa implements IEdificio{
	
	private double largo;
	private double ancho;
	private int plantas;
	
	private int habitantes;
	

	public Casa(double largo, double ancho, int plantas) {
		this.largo=largo;
		this.ancho=ancho;
		this.plantas=plantas;
	}
	
	public Casa(double largo, double ancho, int plantas, int habitantes) {
		this(largo, ancho, plantas);
		this.habitantes=habitantes;
	}

	@Override
	public double getSuperficieEdificio() {
		return ancho*largo*plantas;
	}

	@Override
	public double getPrecioEdificio() {
		return PRECIO_POR_METRO*getSuperficieEdificio();
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

	public int getPlantas() {
		return plantas;
	}

	public void setPlantas(int plantas) {
		this.plantas = plantas;
	}

	public int getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
	
	
	

}
