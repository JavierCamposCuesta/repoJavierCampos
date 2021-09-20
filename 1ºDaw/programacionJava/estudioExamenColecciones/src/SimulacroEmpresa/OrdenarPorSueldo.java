package SimulacroEmpresa;

import java.util.Comparator;

public class OrdenarPorSueldo implements Comparator<Empleado>{

	@Override
	public int compare(Empleado o1, Empleado o2) {
		int result = (int)(o2.getSueldo()-o1.getSueldo());
		return result;
	}

}
