package primeraPruebaJavierCamposExamen;

public class MainClave {
	 String clave;
	 static int contador=1;
	 static String claveComprimida;
	 String claveDescomprimida;
	public static String comprimirClave(String clave) {
		for (int i=0;i<clave.length();i++) {
			if ( clave.charAt(i+1)<= clave.length() && clave.charAt(i)==clave.charAt(i+1)) {
				contador++;
				
			}
			else {
				claveComprimida=clave.charAt(i);
				contador=1;
			}
			
			
		}
		return claveComprimida;
	}
	public static void main(String[] args) {

Clave clave1= new Clave()	;
System.out.println(comprimirClave("aaffgg"));
	}

}
