package RelacionProblemas8_Arrays;

public class Fecha {
	public int yearBisiesto(int year) {
		int resultado=0;
		if (year>0) {
			//Con esta condicion si es cierta el año es bisiesto
			if((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
				resultado=1;
			}
			//Si no ha entrado en la condicion anterior es porque el año no es bisiesto
			else {
				resultado=2;
			}
		}
		
		return resultado;
	}
	
	
	
	
	
	public String comprobarFechaCorrecta(int dia, int mes, int year) throws Exception{
		boolean resultado = false;
		String formatoLargo="";
		String[]meses= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

		if(dia>0 && dia<=31 && mes>0 && mes<=12 && year>0) {
			
		if (mes==1 || mes==3 || mes==5 || mes==7 || mes ==8 || mes==10 || mes==12) {
			if(dia<=31) {
				resultado=true;
			}
		}
		else if(mes==2) {
			if(yearBisiesto(year)==1) {
				if(dia<=29) {
					resultado=true;
				}
				else {
					throw new Exception("Los dias introducidos no son correctos con este mes");
				}
				
			}
			else if(yearBisiesto(year)==2) {
				if(dia<=28) {
					resultado=true;
				}
				else {
					throw new Exception("Los dias introducidos no son correctos con este mes");

				}
			}
			else {
				throw new Exception("El año introducido no es correcto");
			}
			
		}
		else {
			if(dia<=30) {
				resultado=true;
			}
			else {
				throw new Exception("Los dias introducidos no son correctos con este mes");

			}
		}
		}
		else {
			throw new Exception("La fecha introducida no es correcta");

		}
		if(resultado) {
			formatoLargo="La fecha en formato largo es: "+dia+" de "+meses[mes-1]+" de "+year;

		}
		
		
		
		return formatoLargo;
	}
	
	
	
	
	
	
	
	
	
}
