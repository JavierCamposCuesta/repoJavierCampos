package Ejercicio4Webs;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Historial {
	public ArrayList<PaginaWeb> lista;
	
	public Historial() {
		lista=new ArrayList<PaginaWeb>();
	}
	
	public void nuevaPagina(String url) {
		lista.add(new PaginaWeb(url, LocalDateTime.now()));
	}
	
	//2.Consultar historial completo
	public ArrayList<PaginaWeb> mostrarHistorialCompleto(){
		
		return lista;
	}
	
	//3.Consultar historial de un día.
	public String mostrarHistorialDia(LocalDate fecha){
		StringBuilder sb = new StringBuilder();
		for(PaginaWeb e : lista) {
			if(e.fecha.toLocalDate().isEqual(fecha)) {
				sb.append(e + "\n");
			}
		}
		
		
		return sb.toString();
		
	}
	
	public void borrarHistorial() {
		lista.removeAll(lista);
		System.out.println("Historial borrado correctamente");
	}

}
