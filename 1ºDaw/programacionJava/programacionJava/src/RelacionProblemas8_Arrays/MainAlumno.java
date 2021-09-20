package RelacionProblemas8_Arrays;

import java.util.Collection;
import java.util.Collections;

public class MainAlumno {

	public static void main(String[] args) {
		Clase primeroB = new Clase();
		
		primeroB.addAlumno(new Alumno("Javier", "Campos", "Cuesta",8.5));
		primeroB.addAlumno(new Alumno("Flavio", "Campos", "Cuesta",9));
		primeroB.addAlumno(new Alumno("Rafa", "Campos", "Cuesta",6));
		primeroB.addAlumno(new Alumno("Pedro", "Campos", "Cuesta",3));
		primeroB.addAlumno(new Alumno("Adela", "Campos", "Cuesta",4));
		primeroB.addAlumno(new Alumno("Fran", "Campos", "Cuesta",5));
		primeroB.addAlumno(new Alumno("Joaquin", "Campos", "Cuesta",9.5));

		Collections.sort(primeroB.getAlumnos());
		System.out.println(primeroB.getAlumnosAprobados());
		System.out.println(primeroB.getAlumnosSuspensos());
		System.out.println(primeroB.getNotaMediaClase());
		System.out.println(primeroB.getMaximaNota());
		System.out.println(primeroB.getMinimaNota());
		System.out.println(primeroB.getAlumnosSuperanNota(6));
		
		System.out.println();
		
		

	}

}
