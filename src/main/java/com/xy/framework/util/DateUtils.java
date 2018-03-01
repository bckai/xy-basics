package com.xy.framework.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String DATETIME_YMD_FORMAT = "yyyyMMdd";
	public static final String DATETIME_YM_FORMAT = "yyyyMM";
	public static final String DATETIME_Y_FORMAT = "yyyy";

	/**
	 * 时间格式化
	 * 
	 * @param date
	 * @param FORMAT
	 * @return
	 */
	public static String formatDate(Date date, String FORMAT) {
		return new SimpleDateFormat(FORMAT).format(date);
	}

}
