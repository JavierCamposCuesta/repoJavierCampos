package primeraPruebaJavierCamposExamen;

public class Compresor {
	public String encriptar(String cadena) {
		StringBuilder sb=new StringBuilder();
		if (cadena!= null && cadena.length()>0) {
			char a=cadena.charAt(0);
			int contador=1;
			
			for (int i=1;i<cadena.length();i++) {
				if (a==cadena.charAt(i)) {
					contador++;
				}
			
				else {
					sb.append(a).append(contador);
					a=cadena.charAt(i);
					contador=1;
				}
				
			}
		}
		return sb.toString();
	}
	
	public String desencriptar(String cadena) {
		StringBuilder resultado= new StringBuilder();
		if(cadena!=null && !cadena.isBlank() && cadena.length()>2) {
			char caracterARepetir=cadena.charAt(0);
			for (int i=1; i<cadena.length();i++) {
				String veces="";
				if(Character.isDigit(cadena.charAt(i))) {
					veces+=cadena.charAt(i);
				}
				else {
					int vecesNum=Integer.parseInt(veces);
					for (int j=0;j<vecesNum;j++) {
						resultado.append(caracterARepetir);
					}
					veces="";
					caracterARepetir=cadena.charAt(i);
				}
			}
		}
		return resultado.toString();
	}
	

}
