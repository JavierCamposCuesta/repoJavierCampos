package com.jacaranda.tamano;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TamanoMunicipioComunidad {

	private ArrayList<Comunidad> comunidades;

	public TamanoMunicipioComunidad() {
		comunidades = new ArrayList<Comunidad>();
	}
	
	
	
	public String verificaTotal(String com, int ano) {
		StringBuilder respuesta= new StringBuilder();
		int suma=0;
		int vuelta=0;
		int total=0;
		Comunidad buscada=new Comunidad(com);
		for (Municipio m : comunidades.get(comunidades.indexOf(buscada)).getListMunicipio()) {
			for (Datos d : m.getDatos()) {
				if (vuelta==0) {
					total=d.getDato();
					vuelta++;
				}else {
					suma+=d.getDato();
				}
			}
		}
		if (total!=suma) {
			respuesta.append("El valor total esperado es: "+total+", y el obtenido es: "+suma);
		}
		else {
			respuesta.append("El valor total esperado con el obtenido coincide");
		}
		
		return respuesta.toString();
		}
	
	
	public boolean verificaDatos(String com,String descrip) throws Exception {
		boolean respuesta=false;
		Comunidad busca= new Comunidad(com);
		if (!comunidades.contains(busca)) {throw new Exception("No existe esa comunidad");}
		
		
		int contador=0;
		for (Comunidad c : comunidades) {
			if (c.equals(busca)) {
				for (Municipio m : c.getListMunicipio()) {
					if (m.getDescrip().equals(descrip)) {
						contador++;
					}
				}
			}
			
		}
		if (contador==0) {throw new Exception("No existe esa descripcion");}
		
		respuesta=true;
		
		return respuesta;
	}
	
	public boolean anadeDato(String com,String descrip,int ano,int valor) {
		
		Comunidad busca= new Comunidad(com);
		Datos dato=new Datos(ano,valor);
		boolean result=false;
		for (Comunidad c : comunidades) {
			if (c.equals(busca)) {
				
				for (Municipio m : c.getListMunicipio()) {
					if (m.getDescrip().toLowerCase().equals(descrip.toLowerCase())) {
						m.addDatos(dato);
						result=true;
					}
				}
			}
			
		}
		return result;
		
	}
	
	
	public String muestraPorAno(int ano) throws Exception{
		//ir bajando de nivel 
		
		StringBuilder resultado= new StringBuilder();
		for (Comunidad c: comunidades) {
			resultado.append(c.getNombre()+":\n");
			
			for (Municipio m : c.getListMunicipio()) {
				resultado.append("\t"+m.getDescrip()+": ");
				
				for (Datos d : m.getDatos()) {
					if (d.getAno()==ano) {
						resultado.append(d.getDato()+"\n");
					}
				}
			}		
		}
		
		
		
		return resultado.toString();
	}
	
	
	
	public String muestraComunidadAno(int ano, String nombre) throws Exception {
	
		Comunidad busca = new Comunidad(nombre);
		
		
		StringBuilder resultado= new StringBuilder();
		for (Comunidad c: comunidades) {
			if (c.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
				
			
			resultado.append(c.getNombre()+":\n");
			
			for (Municipio m : c.getListMunicipio()) {
				resultado.append("\t"+m.getDescrip()+": ");
				
				for (Datos d : m.getDatos()) {
					if (d.getAno()==ano) {
						resultado.append(d.getDato()+"\n");
						}
					}
				}
			}
		}
		
		
		return resultado.toString();
	}
	
	
	public void leer(String fichero) {
		
		String linea;
		StringBuilder resul = new StringBuilder();
		try
		{
			FileReader flujoLectura=new FileReader(fichero);
			BufferedReader filtroLectura=new BufferedReader(flujoLectura);
			linea=filtroLectura.readLine();
			while ( linea!=null)
			{
				resul.append(linea);
				linea=filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
			}
		catch(FileNotFoundException e){
		System.out.println("No existe el fichero ");
		}
		catch(IOException e){
		System.out.println( e.getMessage());
		}
		
		Gson gson = new Gson();
		
		this.comunidades = gson.fromJson(resul.toString(), new TypeToken<ArrayList<Comunidad>>() {}.getType()); 
			
	}




	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Comunidad c : comunidades) {
			result.append("\n"+c.toString()+"\n");
		}
		
		return result.toString();
	}
	
	

	
	
}
