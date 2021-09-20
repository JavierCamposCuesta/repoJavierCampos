import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;




public class Hotel {

	
	
	public List<Reserva> reservas;
	public List<Instalacion> instalaciones;
	
	public Hotel() {	
		super();
		reservas= new ArrayList<Reserva>();
		instalaciones= new ArrayList<Instalacion>();
		
	}
	
	public List<Instalacion> getInstalaciones() {
		return instalaciones;
	}

	public void inicializarHotel() {
		instalaciones= new ArrayList<Instalacion>();
		reservas= new ArrayList<Reserva>();
		
			instalaciones.add(new HabitacionSimple());
			instalaciones.add(new HabitacionSimple());
			instalaciones.add(new HabitacionSimple());
			instalaciones.add(new HabitacionSimple());
			instalaciones.add(new HabitacionSimple());
			instalaciones.add(new HabitacionDoble());
			instalaciones.add(new HabitacionDoble());
			instalaciones.add(new HabitacionDoble());
			instalaciones.add(new HabitacionSuite());
			
			instalaciones.add(new SalaCelebraciones());
			instalaciones.add(new SalaCelebraciones());
			instalaciones.add(new SalaReuniones());
			instalaciones.add(new SalaReuniones());
			
			reservas.add(new Reserva(LocalDate.now().plusDays(50), LocalDate.now().plusDays(51), instalaciones.get(0)));
			reservas.add(new Reserva(LocalDate.now().plusDays(41), LocalDate.now().plusDays(46), instalaciones.get(0)));
			reservas.add(new Reserva(LocalDate.now().plusDays(15), LocalDate.now().plusDays(18), instalaciones.get(0)));

		
	}
	

	public  void listarInstalaciones() {
		StringBuilder sb = new StringBuilder();
		for(Instalacion i : instalaciones) {
			sb.append(i+ "\n");
		}
		System.out.println(sb.toString());
	}
	
	public void addReserva(Reserva reserva) {
		this.reservas.add(new Reserva());
	}
	
	public double calcularIngresosGenerados() {
		double totalIngreso = 0.0;
		for(Reserva r : reservas) {
			totalIngreso+=r.obtenerCosteReserva();
		}
		return totalIngreso;
		
		
	}
	
	public void listarReservaInstalaciones() {
		Collections.sort(this.reservas);
		StringBuilder sb = new StringBuilder();
		for(Reserva r : reservas) {
			sb.append(r+ "\n");
		}
		System.out.println(sb.toString());
	
	}
	
	public void listarInstalacionesEnFecha(LocalDate fechaLimite) {
		
		for(Reserva r : reservas) {
			if(r.getInicioReserva().isAfter(fechaLimite)) {
				System.out.println(r.getInstalacion());
			}
			
		}
		
		
}

	public void setInstalaciones(List<Instalacion> instalaciones) {
		this.instalaciones = instalaciones;
	}
	
	
	
	
	
	
	
	
}
