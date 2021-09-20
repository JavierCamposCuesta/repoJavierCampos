package EjemploEnum;

import problemas6OrientacionObjetos1.Cuenta;

public class CuentaJoven extends Cuenta{
	
	
	
	
	public CuentaJoven(double saldo, Titular titular) {
		super(saldo, titular);
		this.bonificacion=Bonificacion.CUENTA_JOVEN;
	}
	
	public boolean esTitularValido() {
		boolean resultado= false;
		if(titular.edad >=18 && titular.edad <25 ) {
			resultado=true;
		}
		
		return resultado;
	}
	
	@Override
	public void hacerReintegro(double reintegro) throws Exception{
		if(this.esTitularValido()) {
			super.hacerReintegro(reintegro);
		}
		else {
			throw new Exception("El cliente no cumple las condiciones");
		}
	}
	
	public String mostrar() {
		return "Cuenta joven, la bonificación es de: " + this.bonificacion;
	}
	
	
	

}
