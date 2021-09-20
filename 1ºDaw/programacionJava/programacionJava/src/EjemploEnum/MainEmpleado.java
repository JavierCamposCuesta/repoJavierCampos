package EjemploEnum;

import java.time.LocalDate;

public class MainEmpleado {

	public static void main(String[] args) {
	Empleado empleado = new EmpleadoFijo("javier", 23, "dgssdgs", 2000, LocalDate.of(2020, 3, 25));
	System.out.println(empleado.calculaSueldo());

	}

}
