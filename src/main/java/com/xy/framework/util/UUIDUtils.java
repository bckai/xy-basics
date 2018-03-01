package com.xy.framework.util;

import java.util.Date;
import java.util.Random;

public class UUIDUtils {
	// 可选字符
	private static final String codes = "123456789ABCDEFGHJKMNPQRSTUVWXYZ";

	/**
	 * 编号
	 * 
	 * @return
	 */
	public static String UUIDNumber() {
		return DateUtils.formatDate(new Date(), DateUtils.DATETIME_YMD_FORMAT) + randomChar() + randomChar()
				+ randomChar() + randomChar() + randomChar();
	}

	/**
	 * 随机生成一个字符
	 * 
	 * @return
	 */
	private static char randomChar() {
		Random r = new Random();
		int index = r.nextInt(codes.length());
		return codes.charAt(index);
	}
}
