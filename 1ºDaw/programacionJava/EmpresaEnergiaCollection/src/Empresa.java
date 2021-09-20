import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;







public class Empresa {
	private String nombre;
	
	//Utilizare el tipo de collection HashSet para que no se pueda introducir generadores iguales,
	//o mejor dicho, generadores repetidos, ya que serán iguales cuando el codigo sea el mismo
	public List<GeneradorAbstract> generadores;
	
	public Empresa(String nombre) {
		this.nombre=nombre;
		generadores=new ArrayList<GeneradorAbstract>();
	}
	
	public void addGeneradorSolar(GeneradorSolar generador) {
		generadores.add(generador);
	}
	
	public void addGeneradorEolico(GeneradorEolico generador) {
		generadores.add(generador);
	}
	
	
	//Este metodo devuelve la lista generadores ordenada por fecha
	public String generadoresPorFecha() {
		
		StringBuilder sb = new StringBuilder();
		Collections.sort(generadores);
		for(GeneradorAbstract e : generadores) {
			sb.append(e+ "\n");
		}
		
		
		return (sb.toString());
		
	}
	
	//Este metodo devuelve la lista generadores ordenada por Localidad y si son iguales por fecha
public String generadoresPorLocalidad() {
		
	StringBuilder sb = new StringBuilder();
	Collections.sort(generadores, new OrdenarPorLocalidad());
	for(GeneradorAbstract e : generadores) {
		sb.append(e+ "\n");
	}
	
	return (sb.toString());
		
	}

//Este metodo devuelve la lista de generadores sin ordenar(será en función de como se hayan añadido

public String mostrarGeneradoresEolicos() {
	
	StringBuilder sb = new StringBuilder();
	for(GeneradorAbstract e : generadores) {
		if(e instanceof GeneradorEolico) {
			sb.append(e+ "\n");
		}
	}
	
	return (sb.toString());
		
	}

//Este metodo borra el generador que tenga el codigo que se le pase como parámetro, devuelve true si
//lo elimina y en caso de no existir ningún generador con ese parametro devuelve una excepcion
public boolean eliminarGenerador(int codigo) throws Exception{
	boolean existe=false;
	for(GeneradorAbstract e: generadores) {
		if(e.codigo==codigo) {
			generadores.remove(e);
			existe=true;
		}
	}
	if(existe!=true) {
		throw new ExceptionNoExisteGenerador();
	}
	return existe;
}

//Mostrar total de energia suministrada por la empresa, entiendo que se refiere al total de potencia
public double mostrarTotalEnergia() {
	double totalEnergia=0;
	for(GeneradorAbstract e:generadores) {
		totalEnergia+=e.getPotencia();
	}
	return totalEnergia;
}

//Existe generador en la localidad, muestra true si existe y false si no existe
public boolean existeGeneradorEnLocalidad(String localidad) {
	boolean existe=false;
	 localidad=localidad.toUpperCase();
	for(GeneradorAbstract e:generadores) {
		if(e.localidad.toUpperCase().equals(localidad)) {
			existe=true;
		}
	}
	
	return existe;
}

}











