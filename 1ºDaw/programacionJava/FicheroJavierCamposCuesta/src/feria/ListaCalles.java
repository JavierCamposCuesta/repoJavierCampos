package feria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;









public class ListaCalles {
	//Utilizo el tipo de coleccion ArrayList porque me va a resultar mas sencillo a la hora de acceder a los datos, además el fichero
	//no presenta datos repetidos por lo que no voy a necesitar HashSet, de todas formas, al introducir los datos compruebo
	//que estos no se repitan
	private ArrayList<Calle>calles;
	
	public ListaCalles(String fichero) {
		calles = new ArrayList<Calle>();
		
		cargarFichero(fichero);
	}
	private void cargarFichero(String fichero) {
		
		try {
			FileReader fich = new FileReader(fichero);
			BufferedReader filtroLectura = new BufferedReader(fich);
			
			String linea = filtroLectura.readLine();
			
			linea = filtroLectura.readLine();
			
			while(linea != null) {
				String values[] = linea.split(",");
				
				if (values.length>=7) {
					Calle calle = new Calle (values[1],Integer.parseInt(values[7]));
					int pos = this.calles.indexOf(calle);
	
					if (pos == -1) {
						this.calles.add(calle);
						pos = calles.indexOf(calle);
						
					}
					this.calles.get(pos).addCaseta(values[0], values[4], values[5], Integer.parseInt(values[3]), Integer.parseInt(values[6]), Integer.parseInt(values[2]));
					
					
					
				}
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			
		}
				
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public String mostrarCasetas(String nombreCalle) {
		
		boolean fin = false;
		String resultado="Ese nombre no pertenece a ninguna calle";
		Iterator <Calle> iterator = this.calles.iterator();
		
		while(iterator.hasNext() && fin==false) {
			Calle e = iterator.next();
			
			if(e.getNombreCalle().equals(nombreCalle)) {
				resultado=e.mostrarCasetas();
				fin=true;
			}
		}
		return resultado;
	
	}
	
	
//	2. Mostrar para cada una de las calles del recinto ferial el número de casetas que hay en lacalle
	public String mostrarNumeroCasetas() {
		StringBuilder sb = new StringBuilder();
		
		for(Calle calle : this.calles) {
			sb.append(calle.numeroCasetas()+"\n");
		}
		return sb.toString();
	}
	
	
//3. Eliminar una caseta. Elimina la caseta y corrige los numero de las casetas
	public String eliminarCaseta(String nombreCalle, int numero) {
		boolean fin = false;
		String resultado="Error: Ese nombre no pertenece a ninguna calle";
		Iterator <Calle> iterator = this.calles.iterator();
		
		while(iterator.hasNext() && fin==false) {
			Calle e = iterator.next();
			
			if(e.getNombreCalle().equals(nombreCalle)) {
				resultado=e.borrarCaseta(numero);
				fin=true;
			}
		}
		return resultado;
	}
	
	
	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder();
		for (Calle calle: this.calles) {
			resul.append(calle.toString() + "\n");
		}
		return resul.toString();
		
	}
}
		


