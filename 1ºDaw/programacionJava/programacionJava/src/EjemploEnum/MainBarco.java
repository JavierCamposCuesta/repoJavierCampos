package EjemploEnum;

import java.time.LocalDate;

public class MainBarco {

	public static void main(String[] args) {
		Cliente javier = new Cliente("Javier", "lkjkjjkb" );
		Barco velero= new Velero("hgjhjhk", 10, 2020, 0);
		Barco yate = new Yate("fggfgxf", 10, 2020, 300, 5);
		Barco deportiva = new Deportiva("hgjhjhk", 200, 2020, 300);
		Alquiler alquiler = new Alquiler(javier, LocalDate.now(), LocalDate.now().plusMonths(5), 5 
				, velero);
		Alquiler alquiler2 = new Alquiler(javier, LocalDate.now(), LocalDate.now().plusMonths(5), 5 
				, yate);
		Alquiler alquiler3 = new Alquiler(javier, LocalDate.now(), LocalDate.now().plusMonths(5), 5 
				, deportiva);
		System.out.println(alquiler.calularAlquiler());
		System.out.println(alquiler2.calularAlquiler());
		System.out.println(alquiler3.calularAlquiler());
		
		

	}

}
