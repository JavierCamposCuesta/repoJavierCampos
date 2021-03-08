package Examen5Marzo;

public class StringUtil {
public boolean compruebaSubcadena(String cadena1, String cadena2) {
	boolean resultado=false;
	int contador=0;
	
	if (cadena1.length()>=cadena2.length()) {
		for (int i=0; i<cadena1.length();) {
			if ( i< cadena2.length() && cadena2.charAt(i)==cadena2.charAt(contador)) {
				contador++;
			}
		 if (contador==cadena2.length()) {
				resultado=true;
			}
		}
	}
	else if (cadena1.length()<cadena2.length()) {
		for (int i=0; i<cadena2.length();) {
			if ( i< cadena1.length() && cadena1.charAt(i)==cadena1.charAt(contador)) {
				contador++;
			}
			if (contador==cadena1.length()) {
				resultado=true;
			}
			
		}
	}
	return resultado;
}
}
