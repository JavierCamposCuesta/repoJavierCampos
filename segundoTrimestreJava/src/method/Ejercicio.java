package method;


public class Ejercicio {
	
	public static final Double PI = 3.14;
	

	public static void main(String[] args) {
				
		// Variables
		
		// Inicio
		
				
				
	}
	
	public static int numeroSolucionesEcuacionSegundoGrado(int a, int b, int c) {
		int solucion=2;
		if (a==0) {
			solucion=-1;
		}
		else if (b*b-(4*a*c)==0) {
			solucion=1;
		}
		else if (b*b-(4*a*c)<0) {
			solucion=0;
		}
		
		return solucion;
	}
	
	public static Double solucionSumaEcuacionSegundoGrado(int a, int b, int c) {
		double solucion;
		
		
		if (numeroSolucionesEcuacionSegundoGrado(a,b,c)==-1){
			solucion=-1000;
		}
		else if (numeroSolucionesEcuacionSegundoGrado(a,b,c)==0){
			solucion=-1000;
		}
		else {
			solucion=(-b + Math.sqrt((b*b)-(4*a*c)))/(2*a);
		}
		return solucion;
		
	}
	
	
	
	public static Double solucionRestaEcuacionSegundoGrado(int a, int b, int c) {
		double solucion;
		
		
		if (numeroSolucionesEcuacionSegundoGrado(a,b,c)==-1){
			solucion=-1000;
		}
		else if (numeroSolucionesEcuacionSegundoGrado(a,b,c)==0){
			solucion=-1000;
		}
		else {
			solucion=(-b - Math.sqrt((b*b)-(4*a*c)))/(2*a);
		}
		return solucion;
		
	}	
	
	public static Double areaCirculo(Double r) {
		double area=PI*r*r;
		return area;
		
	}
	
	public static Double longitudCirculo(Double r) {
		double longitud=2*PI*r;
		return longitud;
	}
	
	public static boolean esMultiplo(int a, int b) {
		boolean multiplo=false;
		if ((b==0) || (a==0)) {
			multiplo=false;
		}
		else if (a%b==0){
			multiplo=true;
		}
		return multiplo;
		
	}
	
	public static int horaMayor(int hora1, int min1, int seg1, int hora2, int min2, int seg2) {
		int horaMayor;
		if ((hora1>=0) && (hora1 < 24) && (hora2>=0) && (hora2<24) && (min1>=0) && (min1<=60) && (seg1>=0) && (seg1<=60) && (min2>=0) && (min2<=60) && (seg2>=0) && (seg2<=60)) {
			if (hora1>hora2) {
				horaMayor=1;	
			}
			else if (hora2>hora1) {
				horaMayor=2;
			}
			else {
				if (min1>min2) {
					horaMayor=1;
				}
				else if (min2>min1) {
					horaMayor=2;
				}
				else {
					if (seg1>seg2) {
						horaMayor=1;
					}
					else if(seg2>seg1) {
						horaMayor=2;
					}
					else {
						horaMayor=0;
					}
				}
			}
		}
		else {
			horaMayor=-1000;
		}
		return horaMayor;
	}
	
	public static int segundosEntre(int hora1, int min1, int seg1, int hora2, int min2, int seg2) {
		int calculaSegundos;
				if (horaMayor(hora1, min1, seg1, hora2, min2, seg2)==1) {
					calculaSegundos=((((hora1*3600)+(min1*60)+seg1))-(((hora2*3600)+(min2*60)+seg2)));
				}
				else if (horaMayor(hora1, min1, seg1, hora2, min2, seg2)==2) {
					calculaSegundos=((((hora2*3600)+(min2*60)+seg2))-(((hora1*3600)+(min1*60)+seg1)));
				}
				else if (horaMayor(hora1, min1, seg1, hora2, min2, seg2)==0) {
					calculaSegundos=0;
				}
				else {
					calculaSegundos=-1000;
				}
				return calculaSegundos;
		
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
