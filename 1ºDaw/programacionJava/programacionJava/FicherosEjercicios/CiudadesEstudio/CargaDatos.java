package CiudadesEstudio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CargaDatos {
	
	ArrayList<Country> listaPaises;
	private String ficheroCountry;
	private String ficheroCity;
	private String ficheroAddress;
	
	public CargaDatos(String ficheroCountry, String ficheroCity, String ficheroAddress) {
		this.ficheroCountry=ficheroCountry;
		this.ficheroCity=ficheroCity;
		this.ficheroAddress=ficheroAddress;
		
		this.listaPaises= new ArrayList<Country>();
	
	}
	
	public void cargarPais(String ficheroCountry) {
		
	}
	public void cargarAddress(String ficheroAddress) {
		
		try {
			FileReader f = new FileReader(ficheroAddress);
			BufferedReader buffer = new BufferedReader(f);
			
			String linea = buffer.readLine();
			
			while(linea != null) {
				String aux[]=linea.split(",");
				
				if(aux.length>=3) {
					Address direccion = new Address(Integer.parseInt(aux[0]),aux[3]);
				}
				
				
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
