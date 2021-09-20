package Ejercicio1_Equipo;

public class MainEquipo {

	public static void main(String[] args) {
		Alumno alumno1= new Alumno("Javier", "456");
		Alumno alumno2= new Alumno("Javier", "456");
		Alumno alumno3= new Alumno("Flavio", "444");
		Alumno alumno4= new Alumno("fgdfg", "444");
		Alumno alumno5= new Alumno("Antonio", "123");
		Alumno alumno6= new Alumno("Miguel", "471");
		Alumno alumno7= new Alumno("Mr Potato", "666");
		
		Equipo equipo1 = new Equipo("Betis");
		Equipo equipo2 = new Equipo("Sevilla");
		
		try {
			equipo1.addAlumno(alumno1);
			equipo1.addAlumno(alumno3);
			equipo1.addAlumno(alumno4);
			
			equipo2.addAlumno(alumno5);
			equipo2.addAlumno(alumno6);
			equipo2.addAlumno(alumno7);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		

	}
		System.out.println(equipo1.toString());
		System.out.println(equipo1.buscarAlumno(alumno1));
		
		System.out.println(equipo1.toStringUnirEquipos(equipo2));

	}
	}
