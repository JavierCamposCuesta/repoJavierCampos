
public class SalaReuniones extends Sala{
	public final static int AFORO_MAXIMO=20;
	public final static double FACTOR_DEPENDIENTE=1;
	
	

	public SalaReuniones() {
		super();
		this.capacidadMaxima = CapacidadMaxima.VEINTE;
		this.factorAlquiler=EFactorAlquiler.REUNIONES;
	}

	@Override
	public double calcularPrecioSegunTipo() {
		// TODO Auto-generated method stub
		return calcularPrecioFijo()*FACTOR_DEPENDIENTE;
	}
	
	@Override
	public String toString() {
		return "Sala Reuniones";
	}

}
