package Ciudades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class ListaPaises {
	protected  HashSet<Pais> paises;
	
	public ListaPaises(String fichero) throws Exception  {
		this.paises= new HashSet<Pais>();
		
		
		try {
		FileReader f = new FileReader(fichero);
		BufferedReader buffer = new BufferedReader(f);
		
		String linea = buffer.readLine();
		while(linea!= null) {
			String aux[] = linea.split(",");
			
			
			if(aux.length>=3) {
				Pais p = new Pais(Integer.parseInt(aux[0]), aux[1]);
				this.paises.add(p);
			}//else informar del error
			linea=buffer.readLine();
		}
		buffer.close();
		f.close();
		}
		catch(FileNotFoundException e) {
			throw new Exception("No se puede abrir el fichero");
		}
	}
	
	public void leerCiudad(String fichero) throws Exception {

		
		
		try {
		FileReader f = new FileReader(fichero);
		BufferedReader buffer = new BufferedReader(f);
		
		String linea = buffer.readLine();
		
		while(linea!= null) {
			String aux[] = linea.split(",");
			
			
			if(aux.length>=3) {
				Ciudad p = new Ciudad(Integer.parseInt(aux[0]), aux[1]);
				int codigoPais = Integer.parseInt(aux[2]);
				boolean encontrado=false;
				Iterator<Pais> sig = this.paises.iterator();
				
				while(sig.hasNext() && !encontrado) {
					Pais pais = sig.next();
					if(pais.getIdPais() == codigoPais) {
						pais.addCiudad(p);
						encontrado = true;
					}
				}
				
				//this.paises.add(p);
			}//else informar del error
			linea=buffer.readLine();
		}
		buffer.close();
		f.close();
		}
		catch(FileNotFoundException e) {
			throw new Exception("No se puede abrir el fichero");
		}
	}
	
public void leerDireccion(String fichero) throws Exception {

		
		
		try {
		FileReader f = new FileReader(fichero);
		BufferedReader buffer = new BufferedReader(f);
		
		String linea = buffer.readLine();
		while(linea!= null) {
			String aux[] = linea.split(",");
			
			
			if(aux.length>=5) {
				Direccion p = new Direccion(Integer.parseInt(aux[0]), aux[1]);
				
				int codigoCiudad = Integer.parseInt(aux[4]);
				
				boolean encontrado=false;
				Iterator<Pais> sig = this.paises.iterator();
				
				while(sig.hasNext() && !encontrado) {
					Pais pais = sig.next();
					if(pais.addDireccion(codigoCiudad, p)) {
						encontrado = true;
					}
				}
				
				//this.paises.add(p);
			}//else informar del error
			linea=buffer.readLine();
		}
		buffer.close();
		f.close();
		}
		catch(FileNotFoundException e) {
			throw new Exception("No se puede abrir el fichero");
		}
	}
	

	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder();
		for(Pais pais : paises) {
			resul.append(pais.toString() + "\n");
		}
		return resul.toString();
	}
	
//	public void cargarDatos(String nombreFichero) throws Exception{ 
//		String linea;
//		
//			FileReader flujoLectura=new FileReader("./Ficheros/country.txt");
//			BufferedReader filtroLectura=new BufferedReader(flujoLectura);
//			linea=filtroLectura.readLine();
//			
//			while ( linea!=null){
//				System.out.println(linea);
//				String values[] = linea.split(",");
//				Pais p = new Pais(Integer.parseInt(values[0]),values[1]);
//				if(this.paises.contains(p)) {
//					throw new Exception("Pais repetido");
//				}
//				this.paises.add(p);
//				linea=filtroLectura.readLine();
//				}
//			filtroLectura.close();
//			flujoLectura.close();
//			}
		
	
	
	
		}


