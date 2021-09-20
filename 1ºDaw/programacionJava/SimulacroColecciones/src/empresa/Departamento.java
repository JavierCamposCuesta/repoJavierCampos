package empresa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Departamento {
	
	private String nombreDepartamento;
	public List<Empleado> empleados; 

	public Departamento(String nombreDepartamento) {
		this.nombreDepartamento=nombreDepartamento;
		empleados=new ArrayList<Empleado>();
		
	}
	
	public boolean addEmpleado(Empleado empleado) {
		boolean resultado=false;
		
		
		//Si empleado no instancia a empleadoBase es porque es jefe, por lo tanto resultado=false;
		if(empleado instanceof EmpleadoBase) {
			resultado=true;
		//Si el empleado es igual a otro empleado de la lista los empleados estarian repetidos, por lo tanto resultao=false;
			if(empleados.isEmpty()) {
				empleados.add(empleado);
				resultado=false;
				return true;
			}
			else {
			for(Empleado e : empleados) {
				if(empleado.hashCode()==e.hashCode()) {
					resultado=false;
				}
			}
			}
		}
		if(resultado == true) {
			empleados.add(empleado);
			
		}
		
		
		return resultado;
		
	}
	
	
	public boolean addJefe(Empleado empleado) {
		boolean resultado=false;
		
		if(empleados.isEmpty()) {
			empleados.add(empleado);
			resultado=false;
			return true;
		}
		else {
			
		
		if(empleado instanceof JefeDepartamento) {
			resultado=true;
			for(Empleado e : empleados) {
			//Si hay algun empleado en la lista del tipo jefeDepartamento no podremos incluirlo ya que maximo es un jefe
			//En este caso no haria falta comprobar si es el mismo empleado el que está en la lista
				if(e instanceof JefeDepartamento) {
					resultado=false;
				}
			}
		}
		}
		if(resultado == true) {
			empleados.add(empleado);
		}
		
		return resultado;
		
	}
	
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	
	
	
	
//Este metodo lo que hace es primero ordenar la lista y posteriormente crear un stringBuilder de los ToString de los empleados
//este toString estará ordenado por nombres, por lo que simplemente imprime el nombre del departamente y el stringBuilder
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Collections.sort(empleados);
		for(Empleado e : empleados) {
			sb.append(e+ "\n");
		}
		
		//System.out.println(sb.toString());
		return (this.nombreDepartamento + sb.toString());
	}
	
	

	public double obtenerSueldo() {
		double sumaSueldos=0;
		for(Empleado e : empleados) {
			sumaSueldos+= e.sueldo;
		}
		return sumaSueldos;
	}
	
	public String toStringSueldo() {
		StringBuilder sb = new StringBuilder();
		
		//De esta forma ordenamos por el comparator que hemos creado en la clase ObdenarSueldo
		Collections.sort(empleados, new OrdenarSueldo());
		for(Empleado e : empleados) {
			sb.append(e+ "\n");
		}
		
		//System.out.println(sb.toString());
		return (this.nombreDepartamento + sb.toString());
	}
	
	

}
