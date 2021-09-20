package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ListaComunidades {
	ArrayList<Comunidad> listaComunidades;
	
	public ListaComunidades(String fichero) {
		listaComunidades= new ArrayList<Comunidad>();
		StringBuilder sb = new StringBuilder();
		
		try {
			FileReader file = new FileReader(fichero);
			BufferedReader f = new BufferedReader(file);
			String linea = f.readLine();
			
			while (linea!=null) {
				sb.append(linea);
				linea=f.readLine();
				
			}
			file.close();
			f.close();
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		
		//listaComunidades=gson.fromJson(sb.toString(), ArrayList.class);
		listaComunidades =gson.fromJson(sb.toString(),new TypeToken<ArrayList<Comunidad>>(){}.getType());
	}
	
	
//	Mostrar los datos de todas las comunidades y de España de un año que se pedirápor teclado. 
//	Es decir, se mostrarán todos los datos.
	public String mostrarDatosYear(int year){
		StringBuilder sb = new StringBuilder();
		for(Comunidad comunidad: listaComunidades) {
			for(Municipio municipio : comunidad.getListMunicipio()) {
				
				
				//Creamos un nuevo dato con el año que nos indican y lo buscamos
				Datos nuevoDato = new Datos(year,0);
				if(municipio.getDatos().contains(nuevoDato)) {
				int aux=municipio.getDatos().indexOf(nuevoDato);
				sb.append(comunidad.getNombre()+"\n");
				sb.append(municipio.getDescrip()+"\n");
				sb.append(municipio.getDatos().get(aux).toString() +"\n");
				}
				
				
			}
		}
		return sb.toString();
	}
	
	//Mostrar los datos de una comunidad y un año. Los datos se pedirán por teclado
	public String mostrarDatosComunidadYear(String nombreComunidad, int year) throws Exception{
		StringBuilder sb = new StringBuilder();
		
		//Creamos una nueva comunidad con el nombre que nos indican y la buscamos, para recorrer esa unica comunidad
		Comunidad nuevaComunidad = new Comunidad(nombreComunidad);
		if(listaComunidades.contains(nuevaComunidad)) {
			
			int auxComunidad = listaComunidades.indexOf(nuevaComunidad);
			
			
			sb.append(listaComunidades.get(auxComunidad).getNombre()+"\n");
			for(Municipio municipio : listaComunidades.get(auxComunidad).getListMunicipio()) {
				
				
				
				//Creamos un nuevo dato con el año que nos indican y lo buscamos
				Datos nuevoDato = new Datos(year,0);
				if(municipio.getDatos().contains(nuevoDato)) {
					sb.append(municipio.getDescrip()+"\n");
					int aux=municipio.getDatos().indexOf(nuevoDato);
					sb.append(municipio.getDatos().get(aux).toString() +"\n");
					
				}
				else {
					throw new Exception("El año no existe");
				}
				
			}
		}
		else {
			throw new Exception("La comunidad no existe");
		}

		
		
		return sb.toString();
	}
	
	public String devulveDatosMetodos(String nombreComunidad, String descripcion , int year) {
		StringBuilder sb = new StringBuilder();
		Comunidad comunidad = new Comunidad(nombreComunidad);
		int aux = this.listaComunidades.indexOf(comunidad);
		sb.append(this.listaComunidades.get(aux).getNombre()+"\n");
		sb.append(this.listaComunidades.get(aux).getDatosPorDescripcion(descripcion, year));
		
		return sb.toString();
	}
	
	
	
	
//	Añadir un dato. Se pedirá el nombre de la comunidad y la descripción (descrip).
//	A continuación se pedirá el año y el valor del dato
	public void addDato(String nombreComunidad, String descripcion, int year, int total) throws Exception{
		Comunidad comunidad = new Comunidad(nombreComunidad);
		if(!listaComunidades.contains(comunidad)) {
			throw new Exception("La comunidad no existe");
		}
		else {
			int aux = listaComunidades.indexOf(comunidad);
			Municipio municipio = new Municipio(descripcion);
			if(!listaComunidades.get(aux).getListMunicipio().contains(municipio)) {
				throw new Exception("El municipio no existe");
			}
			else {
				int aux2 = listaComunidades.get(aux).getListMunicipio().indexOf(municipio);
				Datos dato = new Datos(year,total);
				
				if(!listaComunidades.get(aux).getListMunicipio().get(aux2).getDatos().contains(dato)) {
					listaComunidades.get(aux).getListMunicipio().get(aux2).getDatos().add(dato);
				}
				else {
					int aux3 = listaComunidades.get(aux).getListMunicipio().get(aux2).getDatos().indexOf(dato);
					listaComunidades.get(aux).getListMunicipio().get(aux2).getDatos().get(aux3).setDato(total);
				}
				
			}
		}
		
	}
	
	
//	Al salir del menú pregunte si quiere guardar los nuevos datos (“¿Quieres guardar losdatos en un nuevo fichero(S/N)?”) 
//	y en caso afirmativo pida el nombre del fichero aguardar. Se guardará en formato json.
	public void guardarDatos(String nuevoFichero) {
		Gson gson = new Gson();
		String json = gson.toJson(listaComunidades);
		
		final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		final String representacionBonita = prettyGson.toJson(listaComunidades);
		
		
		try {
			FileWriter escribe = new FileWriter(nuevoFichero);
			PrintWriter pw = new PrintWriter(escribe);
			
			
			
			pw.print(representacionBonita);
			
			pw.close();
			escribe.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
//	Comprobar que el valor de Total es la suma de todos los valores: Para ello sedeberá pedir la comunidad y el año. 
//	Se deberá comparar el valor “Total” de eseaño con la suma de todos los datos de todos los municipios menos “Total”. 
//	Sedeberá informar si el valor es igual o en caso de que no sea igual el valor actualy el que debería estar
	public String comprobarTotal(String nombreComunidad, int year) throws Exception{
		int total=0;
		int contador=0;
		String resultado="Los datos si coinciden";
		Comunidad comunidad = new Comunidad(nombreComunidad);
		if(!listaComunidades.contains(comunidad)) {
			throw new Exception("La comunidad no existe");
		}
		else {
			int aux = listaComunidades.indexOf(comunidad);
			for(Municipio municipio:listaComunidades.get(aux).getListMunicipio()) {
				
				
				Datos dato = new Datos(year, 0);
				if(!municipio.getDatos().contains(dato)) {
					throw new Exception("El año no esta registrado");
				}
				else {
					int aux2=municipio.getDatos().indexOf(dato);
					if(municipio.getDescrip().equals("Total")){
						total= municipio.getDatos().get(aux2).getDato();
					}
					else {
						contador+=municipio.getDatos().get(aux2).getDato();
					}
				}
			}
			
		}
		if(total!=contador) {
			resultado="Los datos de "+nombreComunidad+" en el año "+year+" no coinciden, el total debería ser "+contador+ ", en cambio es "+total;
		}
		else {
			resultado="Los datos de "+nombreComunidad+" en el año "+year+" si coinciden, el total es "+total+ ", y la suma es "+contador;
		}
		return resultado;
		
		
	}
	
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Comunidad comunidad : listaComunidades) {
			sb.append(comunidad.toString()+"\n");
		}
		return sb.toString();
	}
	
	

}
