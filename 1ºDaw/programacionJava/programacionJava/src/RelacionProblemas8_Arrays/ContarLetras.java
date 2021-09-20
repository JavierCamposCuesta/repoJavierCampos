package RelacionProblemas8_Arrays;

import java.util.ArrayList;

public class ContarLetras {
	private final String letras="abcdefghijklmnñopqrstuvwxyz";
	private int[] ocurrencias = new int[letras.length()];
	
	public ContarLetras(){
	}
	
	public String contarOcurrencias(String cadena) {
		String resultado="";
		for(int i=0; i<cadena.length();i++) {
			for(int j=0; j<letras.length();j++) {
				if(Character.toLowerCase(letras.charAt(j))==
					Character.toLowerCase(cadena.charAt(i))) {
				ocurrencias[j]++;
				}
			}
		}
		for(int k=0; k<ocurrencias.length;k++) {
			if(ocurrencias[k]>0) {
				resultado=resultado+letras.charAt(k)+" = "+ocurrencias[k]+ "\n";
			}
		}
		return resultado;
	}
	
	
	
	
	

}
