package es.iesjacaranda.corona;

import java.util.Comparator;

public class OrdenarCurados implements Comparator<Corona>{
	@Override
	public int compare(Corona arg0, Corona arg1) {
		int result = (int)(arg0.getCurados()-arg1.getCurados());
		return result;
	}

}
