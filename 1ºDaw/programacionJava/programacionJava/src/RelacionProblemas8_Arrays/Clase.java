package RelacionProblemas8_Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clase {
	
	//Declaro la lista de alumnos. Si no inicializo es null
	private List<Alumno> alumnos;
	
	private final double NOTA_APROBADO=5;
	
	public Clase() {
		super();
		//Inicializo la lista de clase
		alumnos= new ArrayList<Alumno>();
	}
	
	
	public String getAlumnosAprobados() {
		StringBuilder aprobados = new StringBuilder("Lista de aprobados: \n");
		for(int i=0; i<alumnos.size();i++) {
			Alumno al = alumnos.get(i);
			if(al.getNota()>=NOTA_APROBADO) {
				aprobados.append(al.toString()+"\n");
			}
		}
		return aprobados.toString();
	}
	
	public String getAlumnosSuspensos() {
		StringBuilder suspensos = new StringBuilder("Lista de suspensos: \n");
		for(int i=0; i<alumnos.size();i++) {
			Alumno al = alumnos.get(i);
			if(al.getNota()<NOTA_APROBADO) {
				suspensos.append(al.toString()+"\n");
			}
		}
		return suspensos.toString();
	}
	
	public double getNotaMediaClase() {
		double sumaNotas=0;
		double result=0;
		//isEmpty comprueba que la lista no tennga 0 valores
		if(!alumnos.isEmpty()) {
			for(Alumno alumno : alumnos){
				sumaNotas+=alumno.getNota();
			}
			result=sumaNotas/alumnos.size();
		}
		return result;
	}
	
	//De esta forma tenemos los metodos de maxima y minima nota mas reducido
	
	public String getMaximaNota() {
		return getNotaLimiteDeClase(true);
	}
	
	public String getMinimaNota() {
		return getNotaLimiteDeClase(false);
	}
	
	//Lo que hacemos es agrupar las dos condiciones de maxima y minima nota 
	//Le pasamos un valor booleano que lo recibe de los metodos anteriores y 
	//con esto elegimos la opcion que se pide
	private String getNotaLimiteDeClase(boolean maximaNota) {
		String result="No hay alumnos";
		if(!this.alumnos.isEmpty()) {
			Collections.sort(this.alumnos);
			int posicion = maximaNota? this.alumnos.size()-1 : 0;
			String mensaje= maximaNota ? "máxima" : "mínima";
			result = "La "+mensaje+ " nota es: " + this.alumnos.get(posicion).getNota();
		}
		return result;
	}
	
	public String getAlumnosSuperanNota(double notaCorte) {
		StringBuilder aprobados = new StringBuilder("Lista de alumnos que superan la nota es: \n");
		for(int i=0; i<alumnos.size();i++) {
			Alumno al = alumnos.get(i);
			if(al.getNota()>=notaCorte) {
				aprobados.append(al.toString()+"\n");
			}
		}
		return aprobados.toString();
	}
	
	
	
	
	public void addAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	

}
