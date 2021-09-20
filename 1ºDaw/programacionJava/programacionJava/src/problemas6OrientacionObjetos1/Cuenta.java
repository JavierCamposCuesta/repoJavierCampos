package problemas6OrientacionObjetos1;

import EjemploEnum.Bonificacion;
import EjemploEnum.Titular;

public class Cuenta {
	private int numeroReintegros;
	private int numeroIngresos;
	private double saldo;
	public Titular titular;
	public Bonificacion bonificacion;
	
	

	
	public Cuenta(double saldo, Titular titular) {
		this.saldo = saldo;
		this.titular=titular;
	}
	
	
	//operacion 1
	public void hacerReintegro(double reintegro) throws Exception{
		if (saldo>0 && saldo >= reintegro && reintegro>0) {
			saldo=saldo-reintegro;
			numeroReintegros++;
		}
		else {
			throw new Exception("La operacion no se puede realizar");
		}
		
	}
	//operacion 2
	public void hacerIngreso(double ingreso) {
		if (ingreso>0) {
			saldo+=ingreso;
			numeroIngresos++;
		}
		else {
			System.out.println("La operacion no se puede realizar");
		}
		
	}
	//operacio 3
	public String getStatus() {
		return "El saldo es " + this.saldo + " el numero de ingresos es "
				+ this.numeroIngresos + " y el de reintegros " + this.numeroReintegros;
	}
	// operacion 4
	public String getSaldoFinal() {
		return "El saldo final es "+ saldo;
	}
	
}
