package Ciudades;

import java.io.FileWriter;
import java.io.PrintWriter;

public class CargarDatos {
	
	ListaPaises l;
	public CargarDatos() throws Exception {
		l = new ListaPaises("./Ficheros/country.txt");
		l.leerCiudad("./Ficheros/city.txt");
		l.leerDireccion("./Ficheros/address2.txt");
		
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero= new FileWriter("./Ficheros/nuevoFichero.txt");
			pw = new PrintWriter(fichero);
			
			for(Pais pais : l.paises) {
				String totalPais= ("Pais: " + pais.getNombrePais()+ "\t Id: " + pais.getIdPais());
				
				String  totalCiudades = ("\t Total ciudades = " + pais.listaCiudades.size());
				String totalDirecciones=("\t Total direcciones = " + 0);
				int contadorDirecciones=0;
				String nombreCiudades="";
				for(Ciudad ciudad : pais.listaCiudades) {
					contadorDirecciones += ciudad.listaDirecciones.size();
					 nombreCiudades +=ciudad.getNombreCiudad()+" | ";
					
				}
				totalDirecciones = ("\t Total direcciones = " + contadorDirecciones);
				
				pw.println(totalPais + totalCiudades + totalDirecciones);
				pw.println("Nombre ciudades = " + nombreCiudades + "\n");
				
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(null != fichero) {
					fichero.close();
				}
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	
	
	


	


}
