
public class HabitacionDoble extends Habitacion{
	public final static int AFORO_MAXIMO=2;
	public final static double FACTOR_DEPENDIENTE=1.15;
	
	public HabitacionDoble() {
		super();
		this.capacidadMaxima = CapacidadMaxima.DOS;
		this.factorAlquiler=EFactorAlquiler.SIMPLE;
	}

	
	

	@Override
	public String toString() {
		return "Habitacion Doble";
	}




	@Override
	public double calcularPrecioSegunTipo() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
