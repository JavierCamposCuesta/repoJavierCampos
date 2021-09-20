package es.iesjacaranda.corona;

import java.util.Comparator;



public class OrdenarContagios implements Comparator<Corona>{

	

	@Override
	public int compare(Corona arg0, Corona arg1) {
		int result = (int)(arg0.getContagiados()-arg1.getContagiados());
		return result;
	}

}
