package Examen5Marzo;

import java.util.Objects;
import java.util.Scanner;

import relacionDeProblemas7.ExceptionJarraLlena;

public class Empleado {
	private String nombre;
	private int edad;
	private String genero;
	private String horario;
	private int codigoIdentificacion;
	private String pass;
	
	//Creo los constructores
	public Empleado() {
		
	}
	
	public Empleado(String nombre, int edad, String genero, String horario) {
		this.nombre=nombre;
		this.edad=edad;
		this.genero=genero;
		this.horario=horario;
	}
	
	
	/*
	 * Para asignar el codigo tomaré los valores de nombre, edad y género.
	 * Considero que con estos atributos podemos identificar y diferenciar a cada uno de los empleados
	 */
	@Override
	public int hashCode() {
		this.codigoIdentificacion=Objects.hash(this.nombre, this.edad, this.genero);
		return Objects.hash(this.nombre, this.edad, this.genero);
		//Utilizo la funcion Objects.hash(atributo, atributo)
		

	}
	
	/**
	 * Este método nos validará la contraseña que queremos asignar, si no es validad nos mostrará excepciones
	 * @param pass le introducimos la posible contraseña
	 * @throws Exception mostrará exceptiones cuando la contraseña no sea valida
	 */
	public void asignarPass(String pass) throws Exception{
		int salir=1;
		while(salir==1) {
			
			if (pass == null) {
				throw new ExceptionValorNulo();
			}
			else if (pass.length()<10) {
				throw new ExceptionPassMinCaracteres();
			}
			else {
				int contadorMayus=0;
				int contadorNumerico=0;
				for(int i=0; i<pass.length();i++) {
					if (Character.isUpperCase(pass.charAt(i))) {
						contadorMayus++;
					}
					else if (Character.isDigit(pass.charAt(i))) {
						contadorNumerico++;
					}
				}
				if (contadorMayus>=2 && contadorNumerico>=3) {
					this.pass=pass;
					System.out.println("Contraseña introducida correctamente");
					salir=0;
				}
				else {
					throw new ExceptionContadorPass();
					
				}
			}
		}
	}
	Scanner teclado = new Scanner(System.in);
	//Introducir datos generales empleados
	public void datosGenerales() {
		System.out.println("Introduce tu nombre");
		this.nombre=teclado.nextLine();
		
		System.out.println("Introduce tu edad");
		this.edad=Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduce tu genero");
		this.genero=teclado.nextLine();
		
		System.out.println("Introduce tu horario");
		this.horario=teclado.nextLine();
		
		System.out.println("Introduce tu contraseña");
		
		
		try {
			this.asignarPass(teclado.nextLine());
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getCodigoIdentificacion() {
		return codigoIdentificacion;
	}

	public void setCodigoIdentificacion(int codigoIdentificacion) {
		this.codigoIdentificacion = codigoIdentificacion;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
