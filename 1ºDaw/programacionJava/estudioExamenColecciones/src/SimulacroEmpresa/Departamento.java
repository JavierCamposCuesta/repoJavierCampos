package SimulacroEmpresa;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;





public class Departamento {
	private String nombre;
	private HashSet<Empleado> listaEmpleados;
	
	public Departamento(String nombre) {
		this.nombre=nombre;
		listaEmpleados=new HashSet<Empleado>();
	}
	
//	addEmpleado, debe recibir un empleado y añadirlo a la lista. Devolverá true si 
//	se ha podidoañadir y false si no se ha podido añadir porque ya estaba en ese 
//	departamento o porque elempleado que recibe como argumento es un jefe
	public boolean addEmpleado(Empleado empleado) {
		boolean resultado=false;
		if(empleado instanceof EmpleadoBase && listaEmpleados.add(empleado)) {
				resultado=true;
		}
		return resultado;
		
	}
	
	
//	addJefe,   deber   recibir   como   argumento   un   empleado   que   debe   ser   
//	del   tipo   jefe   dedepartamento y devolverá true si se ha podido añadir y false 
//	en caso contrario. Sólo se podráañadir un jefe de departamento, sea cual sea
	public boolean addJefe(Empleado empleado) {
		boolean fin=false;
		boolean resultado=true;
		if(empleado instanceof JefeDepartamento) {
			Iterator <Empleado> iterator = listaEmpleados.iterator();
			while(iterator.hasNext() && fin==false) {
				Empleado e = iterator.next();
				if(e instanceof JefeDepartamento) {
					fin=true;
				}
			}
			if(fin==true) {
				resultado=false;
			}
			else {
				listaEmpleados.add(empleado);
			}
		}
		return resultado;
	}
	
	
//	obtenerSueldo(), el método no recibe nada y devolverá la suma de todos los 
//	sueldos de todoslos empleados
	public double obtenerSueldo() {
		double totalSueldos=0;
		for(Empleado e: listaEmpleados) {
			totalSueldos+=e.getSueldo();
		}
		return totalSueldos;
	}
	
//	toString(), devuelve una cadena con el nombre del departamento y todos los 
//	empleados(jefes   y   empleados   base).   Los   nombres   de   empleados   
//	deben   mostrarse   ordenados   pornombre.
	public String toString() {
		StringBuilder sb = new StringBuilder();
		List<Empleado> listaEmpleados1 = new ArrayList(listaEmpleados);
		Collections.sort(listaEmpleados1);
		for(Empleado e: listaEmpleados1) {
			sb.append(e.toString());
		}
		
		return this.getNombre() + sb.toString();
		
	}
	
//	ToStringSueldo(),   devuelve   una   cadena   con   el   nombre   del   departamento   
//	y   todos   losempleados (jefes y empleados base). Los nombres de empleados deben 
//	mostrarse ordenadospor sueldo de forma que aparezcan primero los que más cobran.
	public String toStringSueldo() {
		StringBuilder sb = new StringBuilder();
		List<Empleado> listaEmpleados1 = new ArrayList(listaEmpleados);
		Collections.sort(listaEmpleados1, new OrdenarPorSueldo());
		for(Empleado e: listaEmpleados1) {
			sb.append(e.toString());
		}
		return this.getNombre()+ sb.toString();
	}


	public String getNombre() {
		return nombre;
	}

	

}
