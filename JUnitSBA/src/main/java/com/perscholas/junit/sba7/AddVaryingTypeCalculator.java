package com.perscholas.junit.sba7;

import java.util.List;

public class AddVaryingTypeCalculator {

	public Double addTwoNumbersVaryingType(List<Object> nums) {
		Double sum = 0.0;
		for (Object o : nums) {
			if (o instanceof String) {
				o = Double.parseDouble(((String) o).trim());
			}
			if (o instanceof Character) {
				o = Character.getNumericValue((Character) o);
				if ((Integer) o > 9) {
					throw new IllegalArgumentException();
				}
				o = ((Integer) o).doubleValue();
			}
			if (o instanceof Integer) {
				o = (Integer) o / 1.0;
			}
			sum += (Double) o;
		}
		return sum;
	}
}
