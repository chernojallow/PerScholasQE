package com.perscholas.junit.sba.bonus;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ConvertTime {
	public static Object dateTypeConversion(Object obj) {
		Timestamp ts;
		LocalDateTime ldt;
		if (obj instanceof LocalDateTime) {
			ts = Timestamp.valueOf((LocalDateTime) obj);
			return ts;
		} else if (obj instanceof Timestamp) {
			ldt = ((Timestamp) obj).toLocalDateTime();
			return ldt;
		}

		return obj;
	}
}