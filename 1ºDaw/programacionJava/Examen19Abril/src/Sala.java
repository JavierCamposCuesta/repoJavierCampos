
public abstract class Sala extends Instalacion{
	
	protected Cliente clienteReserva;
	protected int numeroAsistentes;
	protected Reserva reserva;
	protected int codigo=hashCode();
	protected final static double PRECIO_FIJO=10.75;
	
	public final static int AFORO_MAXIMO=0;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clienteReserva == null) ? 0 : clienteReserva.hashCode());
		result = prime * result + numeroAsistentes;
		return result;
	}

	public double calcularPrecioFijo() {
		return (this.numeroAsistentes*PRECIO_FIJO*this.reserva.calcularDiasReserva());
	}
	
	public abstract double calcularPrecioSegunTipo();
	
	
	

}
