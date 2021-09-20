import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader buffer = new BufferedReader(new FileReader("./Ficheros/prueba.json"));
		String ficheroCadena="";
		String aux = buffer.readLine();{
			while(aux != null)
			{
				ficheroCadena=ficheroCadena + aux;
				aux = buffer.readLine();
			}
			//System.out.println(ficheroCadena);
			
			Gson gson = new Gson();
			
//			Properties propiedades = gson.fromJson(ficheroCadena, Properties.class);
//			
//			System.out.println(propiedades.getProperty("nombre"));
//			System.out.println(propiedades.getProperty("apellidos"));
//			System.out.println(propiedades.getProperty("edad"));
			
			
			
			//Para modificarlo asi el json tiene que estar sin lo de lista del principio
			
//		Persona p1 = gson.fromJson(ficheroCadena, Persona.class);
//		System.out.println(p1);
//			
//		ArrayList<Persona> lista = gson.fromJson(ficheroCadena, new TypeToken<ArrayList<Persona>>(){}.getType());
//		
//		for(Persona p : lista) {
//			System.out.println(p);
//			}
			
			
			//El fichero tinee que tener lo de lista para poder leerlo asi
			ListaPersona l = gson.fromJson(ficheroCadena, ListaPersona.class);
			System.out.println(l);
			
			
			l.addPersona("jose", "perez", 50);
			l.addPersona("pepe", "gutierrez", 12);
			l.addPersona("paco", "campos", 32);
			
			String resultado = gson.toJson(l);
			
			Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
			String representaBonita = prettyGson.toJson(l);
			
			FileWriter f = new FileWriter("./Ficheros/nuevo.json");
			PrintWriter bufferEscritura = new PrintWriter(f);
			
			bufferEscritura.println(representaBonita);
			bufferEscritura.close();
			f.close();
			
			}
	}

}
