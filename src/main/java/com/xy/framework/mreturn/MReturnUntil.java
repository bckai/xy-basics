package com.xy.framework.mreturn;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class MReturnUntil {

	private static PropertyResourceBundle properTyResourceBundle;

	static {
		properTyResourceBundle = (PropertyResourceBundle) ResourceBundle.getBundle("i18n/zh_CN", Locale.getDefault());
	}

	/**
	 * 未登录
	 */
	public static final String WARNING_NOT_LOGIN = properTyResourceBundle.getString("WARNING_NOT_LOGIN");

	/**
	 * 登陆失败
	 */
	public static final String ERROR_LOGIN = properTyResourceBundle.getString("ERROR_LOGIN");

	/**
	 * 菜单保存失败
	 */
	public static final String ERROR_MOUDLE_SAVE = properTyResourceBundle.getString("ERROR_MOUDLE_SAVE");

	/**
	 * 登陆失败
	 */
	public static final String WARNING_NOT_VERIFICATION = properTyResourceBundle.getString("WARNING_NOT_VERIFICATION");

}
