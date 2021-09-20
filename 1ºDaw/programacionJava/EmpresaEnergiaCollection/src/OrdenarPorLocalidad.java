import java.util.Comparator;

public class OrdenarPorLocalidad implements Comparator<GeneradorAbstract>{

	@Override
	public int compare(GeneradorAbstract o1, GeneradorAbstract o2) {
		int resultado;
		if(o1.localidad==o2.localidad) {
			resultado=o1.fechaComienzo.compareTo(o2.fechaComienzo);
		}
		else {
			resultado=o1.localidad.compareTo(o2.localidad);
		}
		return resultado;
	}

}
