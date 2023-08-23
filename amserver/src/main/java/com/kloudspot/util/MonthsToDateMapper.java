package com.kloudspot.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class MonthsToDateMapper {
	
	public static Date monthsToDate(Date presentDate, double months) {
		LocalDate localDate = presentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		localDate = localDate.plusMonths((int) months);

		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
	
}
