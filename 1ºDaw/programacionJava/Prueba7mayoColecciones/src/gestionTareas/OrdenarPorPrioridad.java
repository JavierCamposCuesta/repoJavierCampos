package gestionTareas;

import java.util.Comparator;

public class OrdenarPorPrioridad implements Comparator<TareaAbstract>{

	@Override
	public int compare(TareaAbstract o1, TareaAbstract o2) {
		int resultado;
		if(o1.prioridad.getNumeroHoras()==o2.prioridad.getNumeroHoras()) {
			resultado=o1.descripcion.compareTo(o2.descripcion);
		}
		else {
			resultado=o1.prioridad.getNumeroHoras()-(o2.prioridad.getNumeroHoras());
		}
		return resultado;
	}

}
