package EjemploArrays;

public class PruebaArrays {

	public static void main(String[] args) {
		/**
		int[] listaPrueba = new int[5];
		
		for(int i=0; i<listaPrueba.length;i++) {
			listaPrueba[i]= i+1;
			System.out.println(listaPrueba[i]);
		}**/
		
		int[][] listaPrueba1 = new int[3][3];
		
		for(int i=0; i<listaPrueba1.length;i++) {
			for (int j=0; j<listaPrueba1[i].length;j++) {
				listaPrueba1[i][j]=j+1;
				System.out.println(listaPrueba1[i][j]);
			}
			
		}
		
		

	}

}
