package com.jacaranda.tamano;

public class Principal {
	
	

	public static void main(String[] args) {
		
		
		ListaComunidades lc = new ListaComunidades("./tamanoMunicipioComunidad.json");
		//System.out.println(lc.mostrarDatosYear(2010));
		try {
			lc.addDato("Andalucía", "Total", 2010, 9000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		try {
			System.out.println(lc.mostrarDatosComunidadYear("Andalucía", 2010));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			//System.out.println(lc.mostrarDatosYear(2050));
		lc.guardarDatos("./nuevoFichero.json");
		try {
			System.out.println(lc.comprobarTotal("Andalucía", 2010));
			System.out.println(lc.comprobarTotal("Extremadura", 2010));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(lc.devulveDatosMetodos("Andalucía", "Total", 2010));
		

	}

}
