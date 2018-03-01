package com.xy.framework.util.properties;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropertiesUtil {

	public static final String JDBC = "jdbc";
	public static final String CONFIGURE = "configure";

	public static PropertyResourceBundle redis;

	public PropertiesUtil() {
	}

	static {
		redis = (PropertyResourceBundle) ResourceBundle.getBundle("redis", Locale.getDefault());
	}

	/**
	 * 根据key获得对应的value
	 * 
	 * @param strPropertyName
	 *            key
	 * @return String
	 */
	public static String getString(PropertyResourceBundle properTyResourceBundle, String strPropertyName) {
		try {
			return properTyResourceBundle.getString(strPropertyName);
		} catch (Exception e) {
			return strPropertyName;
		}
	}

	public static String getString(PropertyResourceBundle properTyResourceBundle, String strPropertyName,
			Object... obj) {
		String str = properTyResourceBundle.getString(strPropertyName);
		if (str == null) {
			return strPropertyName;
		}
		return MessageFormat.format(str, obj);
	}

	public static PropertyResourceBundle getBundle(PropertyResourceBundle properTyResourceBundle) {
		return properTyResourceBundle;
	}
}
