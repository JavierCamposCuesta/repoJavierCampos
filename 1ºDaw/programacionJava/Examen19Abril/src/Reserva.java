import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;






public class Reserva implements Comparable<Reserva> {

	public LocalDate inicioReserva;
	public LocalDate finReserva;
	private Instalacion instalacion;
	private List<Cliente> clientes;
	
	public Reserva() {
		clientes= new ArrayList<Cliente>();	
	}
	
	public Reserva(LocalDate inicioReserva, LocalDate finReserva,Instalacion instalacion, Cliente cliente) {
		this.inicioReserva=inicioReserva;
		this.finReserva=finReserva;
		this.instalacion=instalacion;
	}
	
	public Reserva(LocalDate inicioReserva, LocalDate finReserva,Instalacion instalacion) {
		this.inicioReserva=inicioReserva;
		this.finReserva=finReserva;
		this.instalacion=instalacion;
	}
	
	
	
	

	public long calcularDiasReserva() {
		long numeroDias= ChronoUnit.DAYS.between(this.inicioReserva, this.finReserva)+1;
		return numeroDias;
	}
	
	public double calcularPrecioFijo() {
		return (clientes.size()*this.calcularDiasReserva());
	}
	
	
	
	public double obtenerCosteReserva() {
		return ChronoUnit.DAYS.between(inicioReserva, finReserva)*instalacion.getMultiplicadorInstalacion();
	}
	
	
	
	
	
	
	
	@Override
	public int compareTo(Reserva o) {
		
		return this.inicioReserva.compareTo(o.getInicioReserva());
	}
	
	
	@Override
	public String toString() {
		return ("Reserva con fecha de inicio: "+this.inicioReserva);
	}
	
	
	
	
	
	
	
	

	public LocalDate getInicioReserva() {
		return inicioReserva;
	}

	public void setInicioReserva(LocalDate inicioReserva) {
		this.inicioReserva = inicioReserva;
	}

	public LocalDate getFinReserva() {
		return finReserva;
	}

	public void setFinReserva(LocalDate finReserva) {
		this.finReserva = finReserva;
	}

	

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}
	
	

}
