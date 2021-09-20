package Editorial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import Ciudades.Ciudad;
import Ciudades.Pais;

public class ListaProvincia {
	ArrayList<Provincia> provincias;
	
	public ListaProvincia(String fichero) throws IOException {
		provincias = new ArrayList<Provincia>();
		
		cargarFichero(fichero);
		
	}
	
	private void cargarFichero(String nombreFichero) {
		try {
			FileReader fich = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(fich);
			String linea = filtroLectura.readLine();
			
			linea = filtroLectura.readLine();
			while(linea!= null) { 
				String values[] = linea.split(",");
				if (values.length>=9) {
					Provincia aux = new Provincia (values[0]);
					int pos = this.provincias.indexOf(aux);
	
					if (pos == -1) {
						this.provincias.add(aux);
						pos = provincias.indexOf(aux);
					}
					boolean digital;
					if (values.length>=9)
						digital = values[9].equals("S");
					else
						digital = false;
					String tipo= "PRIVADO";
					if (values[2].startsWith("Colegio") || values[2].startsWith("Instituto"))
						tipo = "PUBLICO";
					this.provincias.get(pos).addLocalidadCentroCursoMateria(values[1],tipo, values[3], values[4], values[5], values[6], values[7], values[8], values[9], digital);
				}	
			linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public String toPantalla() {
		StringBuilder resul = new StringBuilder();
		for (Provincia aux: this.provincias) {
			resul.append(aux.toPantalla() + "\n");
		}
		return resul.toString();
		
	}
	
	
	
	
	// Devuelve un string con la editorial más usada de una provincia.
		public String editorialMasUsada(String nombreProvincia) {
			StringBuilder resul = new StringBuilder();
			boolean encontrada = false;
			Iterator<Provincia> sig = this.provincias.iterator();
			
			while (sig.hasNext() && !encontrada) {
				Provincia pro = sig.next();
				if (pro.getNombre().equals(nombreProvincia)) {
					HashMap<String, Integer> unaProvincia = pro.editorialesUsada();
					String nombre="";
					int max = 0;
					for (String edi: unaProvincia.keySet()) {
						if (unaProvincia.get(edi)> max ) {
							max = unaProvincia.get(edi);
							nombre = edi;
						}
					}
					resul.append("En la provincia " + nombreProvincia + " la editorial más usada es " + nombre + " " + max + " veces\n");
					encontrada = true;
					
				}
				
			}
			return resul.toString();
		}
		
		// Devuelve un string con la editorial más usada de una provincia y localidad
		public String editorialMasUsada(String provincia, String localidad) {
			StringBuilder resul = new StringBuilder();
			boolean encontrada = false;
			Iterator<Provincia> sig = this.provincias.iterator();
			
			while (sig.hasNext() && !encontrada) {
				Provincia pro = sig.next();
				if (pro.getNombre().equals(provincia)) {
					HashMap<String, Integer> unaProvincia = pro.editorialesUsada(localidad);
					String nombre="";
					int max = 0;
					for (String edi: unaProvincia.keySet()) {
						if (unaProvincia.get(edi)> max ) {
							max = unaProvincia.get(edi);
							nombre = edi;
						}
					}
					resul.append("En la provincia " + provincia + " la editorial más usada es " + nombre + " " + max + " veces\n");
					encontrada = true;
					
				}
			}
			return resul.toString();
		}
		
		// Devuelve un string con la editorial más usada de todas las provincias.
		
		public String editorialMasUsada() {
			StringBuilder resul = new StringBuilder();

			for (Provincia pro: this.provincias) {
					HashMap<String, Integer> unaProvincia = pro.editorialesUsada();
					String nombre="";
					int max = 0;
					for (String edi: unaProvincia.keySet()) {
						if (unaProvincia.get(edi)> max ) {
							max = unaProvincia.get(edi);
							nombre = edi;
						}
					}
					resul.append("En la provincia " + pro.getNombre() + " la editorial más usada es " + nombre + " " + max + " veces\n");						
			}
			return resul.toString();
		}
		
		// Devuelve un string con la editorial más usada en una materia
		
		public String editorialMasUsadaMateria(String materia) {
			HashMap<String,Integer> editorial = new HashMap<String, Integer>();
			
			for (Provincia provi : this.provincias) {
				HashMap<String, Integer> unaProvincia = provi.editorialesUsadaMateria(materia);
				for (String edi: unaProvincia.keySet()) {
					if (editorial.containsKey(edi)) {
						editorial.put(edi, editorial.get(edi)+ unaProvincia.get(edi));
					}else {
						editorial.put(edi, unaProvincia.get(edi));
					}
				}
			}
			// Ahora saco la mamyor
			String nombre="";
			int max = 0;
			for (String edi: editorial.keySet()) {
				if (editorial.get(edi)> max ) {
					max = editorial.get(edi);
					nombre = edi;
				}
			}
			return "la editorial " + nombre + " está " + max +" veces";
			
		}
		
		
		// Devuelve un string con la editorial más usada de una provincia, localidad y materia.
		
		public String editorialMasUsadaMateria(String provincia, String localidad, String materia) {
			StringBuilder resul = new StringBuilder();
			boolean encontrada = false;
			Iterator<Provincia> sig = this.provincias.iterator();
			
			while (sig.hasNext() && !encontrada) {
				Provincia pro = sig.next();
				if (pro.getNombre().equals(provincia)) {
					HashMap<String, Integer> unaProvincia = pro.editorialesUsada(localidad, materia);
					String nombre="";
					int max = 0;
					for (String edi: unaProvincia.keySet()) {
						if (unaProvincia.get(edi)> max ) {
							max = unaProvincia.get(edi);
							nombre = edi;
						}
					}
					resul.append("En la localidad " + localidad + " de la provincia " + provincia + " en la materia " + materia + " la editorial más usada es " + nombre + " " + max + " veces\n");
					encontrada = true;	
				}
			}
			
			return resul.toString();
		}
		
		// el campo será un 1 se le pasaos el código y 2 si le pasamos el nombre
		public String listadoLibros(String idcentro, int campo) {
			String resul="";
			
			Iterator<Provincia> sig = this.provincias.iterator();
			
			while (sig.hasNext() && resul.length() == 0) {
				resul = sig.next().listadoLibros(idcentro, campo);
			}
			
			return resul;
		}

}
