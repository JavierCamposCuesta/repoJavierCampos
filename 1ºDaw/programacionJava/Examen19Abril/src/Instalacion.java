import java.util.ArrayList;
import java.util.List;

public abstract class Instalacion {
	
	private Habitacion habitacion;
	private Sala sala;
	protected Reserva reserva;
	public List<Habitacion> habitaciones;
	public List<Sala> salas;
	protected CapacidadMaxima capacidadMaxima;
	protected EFactorAlquiler factorAlquiler;
	
	public static int CONTADOR_INSTALACIONES =0;
	public String codigoInstalacion;
	
	public static final double FACTOR_FIJO = 10.75;

	public Instalacion() {
		habitaciones= new ArrayList<Habitacion>();
		salas= new ArrayList<Sala>();
		
	}
	
	public double getMultiplicadorInstalacion() {
		return FACTOR_FIJO*capacidadMaxima.getCapacidad()*factorAlquiler.getFactor();
	}
	
	
	 public List<Habitacion> listarHabitaciones() {
		 return getHabitaciones();
	 }
	 public List<Sala> listarSalas() {
		 return getSala();
	 }
	 
	 
	 public List<Habitacion> getHabitaciones() {
			return habitaciones;
		}
		
		public List<Sala> getSala() {
			return salas;
		}
	
	
	

}
