
public class HabitacionSuite extends Habitacion{
	
	public final static int AFORO_MAXIMO=2;
	public final static double FACTOR_DEPENDIENTE=1.9;

	public HabitacionSuite() {
		super();
		this.capacidadMaxima = CapacidadMaxima.DOS;
		this.factorAlquiler=EFactorAlquiler.SUITE;
	}

	@Override
	public double calcularPrecioSegunTipo() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		return "Habitacion Suite";
	}

	

}
