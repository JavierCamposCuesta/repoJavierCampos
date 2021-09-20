package empresa;

public class MainPrueba {

	public static void main(String[] args) {
		
		Departamento contabilidad = new Departamento("Contabilidad");
		Empleado javier = new EmpleadoBase("41562", "javier", TipoSueldo.ADMINISTRATIVO);
		Empleado ivan = new EmpleadoBase("777", "ivan", TipoSueldo.CONTABLE);
		Empleado ivan1 = new EmpleadoBase("777", "ivan1", TipoSueldo.OPERARIO);
		try {
			Empleado jefe1 = new JefeDepartamento("777", "antonio",1400, 4);
			Empleado jefe2 = new JefeDepartamento("777", "jose",1400, 4);
			System.out.println(contabilidad.addJefe(jefe1));
			System.out.println(contabilidad.addJefe(jefe2));
			jefe1.actualizarSueldo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(contabilidad.addEmpleado(javier));
		
		System.out.println(contabilidad.addEmpleado(ivan));
		System.out.println(contabilidad.addEmpleado(ivan1));
		
		
		System.out.println(contabilidad.toString());
		//contabilidad.empleados;
		
		ivan.actualizarSueldo();
		System.out.println(ivan.sueldo);

		System.out.println(contabilidad.toString());
	}

}
