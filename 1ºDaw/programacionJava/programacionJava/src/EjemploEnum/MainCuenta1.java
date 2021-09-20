package EjemploEnum;

import problemas6OrientacionObjetos1.Cuenta;

public class MainCuenta1 {

	public static void main(String[] args) {
		Titular titular1 = new Titular("dgfsdgsg", 451);
		CuentaJoven cuenta1= new CuentaJoven(100, titular1);
		Cuenta cuenta2= new Cuenta(100, titular1);
		
		System.out.println(cuenta1.esTitularValido());
		System.out.println(cuenta1.titular);

	}

}
