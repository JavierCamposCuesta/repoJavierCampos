package prueba;

import java.util.Scanner;

public class Principal {
	public static final String MENU = 	"1. Servir café solo (1 euro)\n" + 
			"2. Servir leche (0,8 euros)\n" + 
			"3. Servir café con leche (1,5 euros)\n" + 
			"4. Consultar estado máquina. Aparecen los datos de los depósitos y del monedero \n" + 
			"5. Apagar máquina y salir";
	

public static void main(String[] args) {
gestionarInterfaz();
}



public static void mostrarMenu() {
System.out.println(MENU);
}


public static void gestionarInterfaz() {
Scanner teclado = new Scanner(System.in);
int opcion = 0;
MaquinaCafe maquina = new MaquinaCafe();

while(opcion!=5) {
try {
mostrarMenu();
opcion = Integer.parseInt(teclado.nextLine());

switch (opcion) {
case 1:
if(maquina.esPosibleServirCafe()) {
System.out.println("Introduzca "+ MaquinaCafe.PRECIO_CAFE + " euros");
double cantidad = Double.parseDouble(teclado.nextLine());
System.out.println(maquina.darCambio(cantidad, MaquinaCafe.PRECIO_CAFE));
maquina.servirCafe();
}
break;

case 2:
if(maquina.esPosibleServirLeche()) {
System.out.println("Introduzca "+ MaquinaCafe.PRECIO_LECHE + " euros");
double cantidad = Double.parseDouble(teclado.nextLine());
System.out.println(maquina.darCambio(cantidad, MaquinaCafe.PRECIO_LECHE));
maquina.servirLeche();
}
break;
case 3:
if(maquina.esPosibleServirCafeConLeche()) {
System.out.println("Introduzca "+ MaquinaCafe.PRECIO_CAFE_LECHE + " euros");
double cantidad = Double.parseDouble(teclado.nextLine());
System.out.println(maquina.darCambio(cantidad, MaquinaCafe.PRECIO_CAFE_LECHE));
maquina.servirCafeConLeche();
}
break;
case 4: 
System.out.println(maquina);
break;
default:
throw new Exception("La opción seleccionada no es correcta");
}
}catch (Exception ex) {
System.out.println(ex.getMessage());
}
}

}
}


