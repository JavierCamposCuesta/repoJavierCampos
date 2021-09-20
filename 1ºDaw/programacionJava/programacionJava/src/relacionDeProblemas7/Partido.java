package relacionDeProblemas7;

import java.util.Scanner;

public class Partido {
	private int jornada;
	private Equipo local;
	private Equipo visitante;
	private String quiniela;
	Scanner teclado=new Scanner(System.in);
	
	//Constructores
	public Partido() {}
	
	public Partido(Equipo local, Equipo visitante) {
		jornada+=1;
		this.local=local;
		this.visitante=visitante;
	}
	
	/**
	 * 
	 * @param local
	 * @param visitante
	 * @return Devuelve que el resultado se ha añadido correctamente
	 * @throws Exception Envía un error si los equipos son iguales
	 */
	public String ponerResultado(Equipo local, Equipo visitante) throws Exception{
		if (local.getNombre().equals(visitante.getNombre())) {
			throw new Exception("No se puede jugar, los equipos son iguales");
		}
		else {
			golesEquipos();
			quiniela=local.getGoles()+", X, "+visitante.getGoles();
			local.setTotalGoles(local.getTotalGoles()+local.getGoles());
			visitante.setTotalGoles(visitante.getTotalGoles()+visitante.getGoles());
			if (local.getGoles()>visitante.getGoles()) {
				local.setPartidosGanados(local.getPartidosGanados()+1);
			}
			else if (local.getGoles()<visitante.getGoles()) {
				visitante.setPartidosGanados(visitante.getPartidosGanados()+1);
			}
	


		}
		return "Resultado añadido correctamente";
	}
	
	//Este método pide los goles de cada equipo por teclado
	public String golesEquipos(){
		String resultado;
		
		int goles=-1;
		System.out.println("Introduce los goles de cada equipo");
		while (goles<0) {
			System.out.println("Goles equipo local: ");
			goles=teclado.nextInt();
			local.setGoles(goles);
			if (goles<0) {
				System.out.println("Los goles no pueden ser negativos");
			}
		}
		goles=-1;
		System.out.println("Introduce los goles del equipo visitante: ");
		while (goles<0) {
			System.out.println("Goles equipo visitante: ");
			goles=teclado.nextInt();
			visitante.setGoles(goles);
			if (goles<0) {
				System.out.println("Los goles no pueden ser negativos");
			}
		}
		return "El resultado del partido ha sido de: " + local.getGoles()+"-"+visitante.getGoles();

		
	}

	@Override
	public String toString() {
		return "Partido entre equipo local "+local.getNombre()+" y el equipo visitante "+visitante.getNombre()+
				" jugado en el estadio "+ local.getEstadio()+" de la ciudad "+local.getCiudad()+ " ha finalizado con "+
				local.getGoles()+" goles del equipo local y "+visitante.getGoles()+" goles del equipo visitante. \n Resultado de la quiniela= "+this.quiniela;
	}
	
	//ToString
	
	
	
	
	
	
	
	

}
