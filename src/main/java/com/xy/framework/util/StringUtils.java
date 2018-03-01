package com.xy.framework.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
	public static String DateToString(Date date) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	public static void main(String[] args) {
		System.out.println(StringUtils.DateToString(new Date()));
	}
}
