
public class SalaCelebraciones extends Sala {
	
	
	
	

	public SalaCelebraciones() {
		super();
		this.capacidadMaxima = CapacidadMaxima.OCHENTA;
		this.factorAlquiler=EFactorAlquiler.CELEBRACIONES;
	}

	@Override
	public double calcularPrecioSegunTipo() {
		// TODO Auto-generated method stub
		return calcularPrecioFijo()*factorAlquiler.getFactor();
	}
	
	@Override
	public String toString() {
		return "Sala Celebraciones";
	}
}
