package es.iesjacaranda.corona;

import java.util.Comparator;

public class OrdenarFallecidos implements Comparator<Corona>{
	@Override
	public int compare(Corona arg0, Corona arg1) {
		int result = (int)(arg0.getFallecidos()-arg1.getFallecidos());
		return result;
	}

}
