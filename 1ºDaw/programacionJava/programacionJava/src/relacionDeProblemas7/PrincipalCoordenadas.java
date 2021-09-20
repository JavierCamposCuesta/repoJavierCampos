package relacionDeProblemas7;

import java.util.Scanner;

public class PrincipalCoordenadas {

	public static void main(String[] args) {
		
		
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce las coordenadas X y Y del primer punto de la primera linea: ");
		Punto puntoA= new Punto(teclado.nextDouble(),teclado.nextDouble());
		System.out.println("Introduce las coordenadas X y Y del segundo punto de la primera linea: ");

		Punto puntoB= new Punto(teclado.nextDouble(),teclado.nextDouble());
		System.out.println("Introduce las coordenadas X y Y del primer punto de la segunda linea: ");

		Punto puntoA2= new Punto(teclado.nextDouble(),teclado.nextDouble());
		System.out.println("Introduce las coordenadas X y Y del segundo punto de la segunda linea: ");

		Punto puntoB2= new Punto(teclado.nextDouble(),teclado.nextDouble());

		Linea linea1= new Linea(puntoA, puntoB);
		Linea linea2= new Linea(puntoA2, puntoB2);
		
		
		// final String MOVIMIENTO_REALIZADO="El movimiento se ha realizado correctamente";
		
		
		
			System.out.println("1.Mover linea \n2.Mostrar linea \n3.Salir \n4.Comparar lineas");
			int opcion=0;
			char movimiento = 0;
			double mover;
			while (opcion!=3) {
				System.out.println("¿Que opcion quiere realizar?");
				opcion=teclado.nextInt();
				if (opcion>0 && opcion <=4) {
					
					switch (opcion) {
					case 1: {
						System.out.println("A. Arriba \nB. Abajo \nI. Izquierda \nD. Derecha");
						while (movimiento!='A' && movimiento!='B' && movimiento!='I' && movimiento!='D') {
							System.out.println("Introduce un movimiento valido");
							movimiento=(teclado.next().toUpperCase().charAt(0));
							}
						
						
						switch (movimiento) {

						case 'A': {
							System.out.println("¿Cuanto quieres moverlo hacia arriba?");
							mover=teclado.nextDouble();
							linea1.moverArriba(mover);
							break;
						}
						case 'B': {
							System.out.println("¿Cuanto quieres moverlo hacia abajo?");
							mover=teclado.nextDouble();
							linea1.moverAbajo(mover);
							
							break;
						}
						case 'I': {
							System.out.println("¿Cuanto quieres moverlo hacia la izquierda?");
							mover=teclado.nextDouble();
							linea1.moverIzquierda(mover);
							break;
						}
						case 'D': {
							System.out.println("¿Cuanto quieres moverlo hacia la derecha?");
							mover=teclado.nextDouble();
							linea1.moverDerecha(mover);
							break;
						}
						
						
						
						
						}
						movimiento='n';
						break;
					}
					case 2: {
						linea1.mostrarInformacion();
						linea2.mostrarInformacion();
						break;
					}
					case 3: {
						System.out.println("Vuelva pronto");
						break;
					}
					case 4: {
						System.out.println(linea1.equals(linea2));
						break;
					}
				
					}
					
				}
				else {
					System.out.println("La opcion introducida no es correcta");
				}
				
			
			
			
		}
			teclado.close();
		
			}
	
}
			
	

	

