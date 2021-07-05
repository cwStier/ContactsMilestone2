package cst135n.w4.milestone4;

import java.util.Comparator;

public class ComparatorName implements Comparator<BaseContact>{

	@Override
	public int compare(BaseContact arg0, BaseContact arg1) {
		// String compare:  return arg0.getName().compareTo(arg1.getName());
		return arg0.getName().compareTo(arg1.getName());
	}

}
