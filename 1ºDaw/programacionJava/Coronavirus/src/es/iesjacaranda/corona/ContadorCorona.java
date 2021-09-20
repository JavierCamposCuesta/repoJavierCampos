package es.iesjacaranda.corona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;





public class ContadorCorona {
	private ArrayList<Corona>coronas;
	
	public ContadorCorona() {
		coronas = new ArrayList<Corona>();
	}
	
	
		
	
		
	
	
	public void addCoronaContagios(Informacion paciente, int valorAnterior) {
		Corona corona = new Corona();
		corona.setFecha(paciente.getFecha());
		corona.setContagiados(paciente.getValor()-valorAnterior);
		if(!this.coronas.contains(corona)) {
			coronas.add(corona);
		}
	}
	
	public void addCoronaCurados(Informacion paciente, int valorAnterior) {
		
		Corona corona = new Corona();
		corona.setFecha(paciente.getFecha());
		if(!coronas.contains(corona)) {
			coronas.add(corona);
			corona.setCurados(paciente.getValor()-valorAnterior);
		}
		else {
			int pos= coronas.indexOf(corona);
			coronas.get(pos).setCurados(paciente.getValor()-valorAnterior);
		}
		
	}
	
	public void addCoronaFallecidos(Informacion paciente, int valorAnterior) {
		
		Corona corona = new Corona();
		corona.setFecha(paciente.getFecha());
		if(!coronas.contains(corona)) {
			coronas.add(corona);
			corona.setFallecidos(paciente.getValor()-valorAnterior);
		}
		else {
			int pos= coronas.indexOf(corona);
			coronas.get(pos).setFallecidos(paciente.getValor()-valorAnterior);
		}
	}
	
//	Mejor día: Esta opción mostrará el día en el que se produjo menos contagios, 
//	el día en el quese produjo menos muertes y el día en que se produjeron más altas
	

	public String ordenarContagios() {
		Collections.sort(coronas, new OrdenarContagios());
		StringBuilder sb = new StringBuilder();
		for(Corona corona : coronas) {
			sb.append(corona.toString());
		}
		return sb.toString();
	}
	
	
//	Mejor día: Esta opción mostrará el día en el que se produjo menos contagios, el día en el que
//	se produjo menos muertes y el día en que se produjeron más altas
	public String mejorDia() {
		StringBuilder sb = new StringBuilder();
		Collections.sort(coronas, new OrdenarContagios());
		sb.append("El dia con menos contagios es: " + coronas.get(0).getFecha() + " con " + coronas.get(0).getContagiados() + " contagios \n");   
		
		Collections.sort(coronas, new OrdenarCurados());
		sb.append("El dia con mas curados es: " + coronas.get(0).getFecha() + " con " + coronas.get(coronas.size()-1).getCurados() + " curados \n");
	
		Collections.sort(coronas, new OrdenarFallecidos());
		sb.append("El dia con menos fallecidos es: " + coronas.get(0).getFecha() + " con " + coronas.get(0).getFallecidos() + " fallecidos \n");
	
		return sb.toString();
	
	}
	
//	Mejor día a partir de: se pedirá un día y un mes (un valor numérico para el día y un valor
//			String para el mes) y se mostrarán los mismos datos que en la opción anterior pero a partir
//			del día introducido.
	
	//Aqui convierto la fecha que me pasan
	public LocalDate convertirFecha(int dia, String mes, int year) {
		String[] meses={"", "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre"
                , "octubre", "noviembre", "diciembre"};
		int mes1=0;
		for(int i =0; i<meses.length;i++) {
			if(meses[i].equalsIgnoreCase(mes)) {
				mes1=i;
			}
		}
		

		LocalDate fecha = LocalDate.of(year, mes1, dia);
		return fecha;
	}
	
	//Este metodo ordena la lista a partir de la fecha y coge los valores que le interesa
	public String mejorDiaAPartirDe(int dia, String mes, int year) {
		ArrayList<Corona> fechasNuevas = new ArrayList<Corona>();
		Collections.sort(coronas);
		for(Corona corona:coronas) {
			if(corona.getFecha().isAfter(convertirFecha(dia,mes,year))) {
				fechasNuevas.add(corona);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Collections.sort(fechasNuevas, new OrdenarContagios());
		sb.append("El dia con menos contagios es: " + fechasNuevas.get(0).getFecha() + " con " + fechasNuevas.get(0).getContagiados() + " contagios \n");   
		
		Collections.sort(fechasNuevas, new OrdenarCurados());
		sb.append("El dia con mas curados es: " + fechasNuevas.get(0).getFecha() + " con " + fechasNuevas.get(fechasNuevas.size()-1).getCurados() + " curados \n");
	
		Collections.sort(fechasNuevas, new OrdenarFallecidos());
		sb.append("El dia con menos fallecidos es: " + fechasNuevas.get(0).getFecha() + " con " + fechasNuevas.get(0).getFallecidos() + " fallecidos \n");
		
		return sb.toString();
	}
	
	
//	Peor día: Esta opción mostrará el día en el que se produjo más contagios, el día en el que se
//	produjo más muertes y el día en que se produjeron menos altas.
	
public String peorDia() {
	StringBuilder sb = new StringBuilder();
	Collections.sort(coronas, new OrdenarContagios());
	sb.append("El dia con mas contagios es: " + coronas.get(coronas.size()-1).getFecha() + " con " + coronas.get(coronas.size()-1).getContagiados() + " contagios \n");   
	
	Collections.sort(coronas, new OrdenarCurados());
	sb.append("El dia con menos curados es: " + coronas.get(coronas.size()-1).getFecha() + " con " + coronas.get(0).getCurados() + " curados \n");

	Collections.sort(coronas, new OrdenarFallecidos());
	sb.append("El dia con mas fallecidos es: " + coronas.get(coronas.size()-1).getFecha() + " con " + coronas.get(coronas.size()-1).getFallecidos() + " fallecidos \n");

	return sb.toString();
}

//Peor día a partir de: se pedirá un día y un mes (un valor numérico para el día y un valor
//String para el mes) y se mostrarán los mismos datos que en la opción anterior pero a partir
//del día introducido.
public String peorDiaAPartirDe(int dia, String mes, int year) {
	ArrayList<Corona> fechasNuevas = new ArrayList<Corona>();
	Collections.sort(coronas);
	for(Corona corona:coronas) {
		if(corona.getFecha().isAfter(convertirFecha(dia,mes,year))) {
			fechasNuevas.add(corona);
		}
	}
	
	StringBuilder sb = new StringBuilder();
	Collections.sort(fechasNuevas, new OrdenarContagios());
	sb.append("El dia con mas contagios es: " + fechasNuevas.get(fechasNuevas.size()-1).getFecha() + " con " + fechasNuevas.get(fechasNuevas.size()-1).getContagiados() + " contagios \n");   
	
	Collections.sort(fechasNuevas, new OrdenarCurados());
	sb.append("El dia con menos curados es: " + fechasNuevas.get(fechasNuevas.size()-1).getFecha() + " con " + fechasNuevas.get(0).getCurados() + " curados \n");

	Collections.sort(fechasNuevas, new OrdenarFallecidos());
	sb.append("El dia con mas fallecidos es: " + fechasNuevas.get(fechasNuevas.size()-1).getFecha() + " con " + fechasNuevas.get(fechasNuevas.size()-1).getFallecidos() + " fallecidos \n");
	
	return sb.toString();
}



//Número de contagios, número de muertes y número de curados en un día (se pedirá día y
//mes).

	public String informacionDia(int dia, String mes, int year) {
		Corona coronaCopia= new Corona(convertirFecha(dia, mes, year),0,0,0);
		StringBuilder sb = new StringBuilder();
		int aux;
		if(coronas.contains(coronaCopia)) {
			aux=coronas.indexOf(coronaCopia);
			sb.append("Ese dia hubo " + coronas.get(aux).getContagiados() + " contagios \n");
			sb.append("Ese dia hubo " + coronas.get(aux).getCurados() + " curados \n");
			sb.append("Ese dia hubo " + coronas.get(aux).getFallecidos() + " fallecidos \n");
			
		}
		else {
			sb.append("Ese dia no se registraron datos");
		}
		return sb.toString();
	}
	
	
//	. Media de contagios, de muertes y de curados.
	
	public String mediaInfo() {
		int totalContagios=0;
		int totalCurados=0;
		int totalFallecidos=0;
		
		StringBuilder sb = new StringBuilder();
		
		for(Corona corona: coronas) {
			totalContagios+=corona.getContagiados();
			totalCurados+=corona.getCurados();
			totalFallecidos+=corona.getFallecidos();
		}
		sb.append("Media contagios " + (totalContagios/coronas.size())+"\n");
		sb.append("Media curados " + (totalCurados/coronas.size())+"\n");
		sb.append("Media fallecidos " + (totalFallecidos/coronas.size())+"\n");
		
		return sb.toString();
	}






	@Override
	public String toString() {
		Collections.sort(coronas);
		StringBuilder sb = new StringBuilder();
		for(Corona corona : coronas) {
			sb.append(corona.toString());
		}
		return sb.toString();
	}
	
	
	
}
