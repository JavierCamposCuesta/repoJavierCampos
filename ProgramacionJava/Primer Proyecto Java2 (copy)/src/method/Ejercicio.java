package method;


public class Ejercicio {
	
	public static final Double PI = 3.14;
	

	public static void main(String[] args) {
				
		// Variables
		
		// Inicio
		
				
				
	}
	
	public static int numeroSolucionesEcuacionSegundoGrado(int a, int b, int c) {
		int solucion;
		if(a==0) {
			solucion=-1;
		}
		else if ((Math.pow(b, 2)-(4*a*c))<0) {
			solucion=0;
		}
		else if ((Math.pow(b, 2)-(4*a*c))==0) {
			solucion=1;
		}
		else {
			solucion=2;
		}
		return solucion;
	}
	
		
	
	
	public static Double solucionSumaEcuacionSegundoGrado(int a, int b, int c) {
		double resultado;
		
		if (numeroSolucionesEcuacionSegundoGrado(a, b, c)<=0) {
			resultado=-1000;
		}
		else if (numeroSolucionesEcuacionSegundoGrado(a, b, c)==1) {
			resultado= (-b/(2*a));
		}
		else  {
			resultado= (-b+Math.sqrt((b*b)-(4*a*c)))/(2*a);
		}
		return resultado;
			
		
	}
	
	
	
	public static Double solucionRestaEcuacionSegundoGrado(int a, int b, int c) {
		double resultado;
		
		if (numeroSolucionesEcuacionSegundoGrado(a, b, c)<=0) {
			resultado=-1000;
		}
		else if (numeroSolucionesEcuacionSegundoGrado(a, b, c)==1) {
			resultado= (-b/(2*a));
		}
		else  {
			resultado= (-b-Math.sqrt((b*b)-(4*a*c)))/(2*a);
		}
		return resultado;
			
	}	
	
	public static Double areaCirculo(Double r) {
		return (r*r)*PI;
	}
	
	public static Double longitudCirculo(Double r) {
		return (2*PI*r);
	}
	
	public static boolean esMultiplo(int a, int b) {
		boolean result = false;
		if ((a%b==0)&& a!=0 && b!=0) {
			return true;
		}
		else {
			return result;
		}
		
	}
	
	public static int horaMayor(int hora1, int min1, int seg1, int hora2, int min2, int seg2) {
		
		
	}
	
	public static int segundosEntre(int hora1, int min1, int seg1, int hora2, int min2, int seg2) {
				
		
	}
	
	public static int maximoComunDivisor(int a, int b) {
		
	}
	
	public static int minimoComunMultiplo(int a, int b) {
		
	}
	
	public static String binario(int num) {
		
	}
	
	public static int decimal(String num) {
		
	}
}
