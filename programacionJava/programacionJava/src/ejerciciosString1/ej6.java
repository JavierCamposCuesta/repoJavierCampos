package ejerciciosString1;

public class ej6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Realizar una función que busque una palabra escondida dentro de un texto. Por ejemplo,
		 *  si la cadena es "shybaoxlna" y la palabra que queremos buscar es "hola", entonces si 
		 *  se encontrará y deberá devolver True, en caso contrario deberá devolver False.
		 */
		
		System.out.println(palabraEscondida("hodfsdgffsdgldfdsfas", "hola"));
	}
	
	public static boolean palabraEscondida(String cadena, String palabra)
	{
		int j =0;
		for (int i=0;i< cadena.length();i++)
		{
			if (palabra.length()>j && cadena.charAt(i)==palabra.charAt(j))
					{
					j++;
					}
		}
		if (palabra.length() == j) 
		{
			return true;
		}
		else
		{
			return false;
		}
			
	}

}
