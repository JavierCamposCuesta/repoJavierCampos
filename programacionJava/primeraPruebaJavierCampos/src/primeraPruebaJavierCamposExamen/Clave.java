package primeraPruebaJavierCamposExamen;

public class Clave {
	private String clave;
	private int contador=1;
	private String claveComprimida;
	private String claveDescomprimida;
	
	//Constructor
	

	
	public String comprimirClave(String clave) {
		for (int i=0;i<this.clave.length();i++) {
			if ( this.clave.charAt(i+1)<= clave.length() && this.clave.charAt(i)==this.clave.charAt(i+1)) {
				this.contador++;
				
			}
			else {
				String contador=contador+"";
				
				claveComprimida=clave.charAt(i)+contador;
				int  contador=Integer.parseInt(contador);

				contador=1;
			}
			
			
		}
		return this.claveComprimida;
	}
}
