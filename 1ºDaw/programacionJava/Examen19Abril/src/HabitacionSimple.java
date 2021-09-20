
public class HabitacionSimple extends Habitacion{
	
	
	public final static int AFORO_MAXIMO=1;
	public final static double FACTOR_DEPENDIENTE=1.15;
	

	
	
	public HabitacionSimple() {
		super();
		this.capacidadMaxima = CapacidadMaxima.DOS;
		this.factorAlquiler=EFactorAlquiler.SIMPLE;
	}
	
	
	@Override
	public String toString() {
		return "Habitacion Simple";
	}


	@Override
	public double calcularPrecioSegunTipo() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	

}
