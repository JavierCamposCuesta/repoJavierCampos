package feria;

import java.util.Comparator;



public class OrdenarPorNumero implements Comparator<Caseta>{

	@Override
	public int compare(Caseta o1, Caseta o2) {
		int resultado = o1.getNumero()-o2.getNumero();
		
		return resultado;
	}

}
