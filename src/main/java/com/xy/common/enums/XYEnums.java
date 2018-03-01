package com.xy.common.enums;

public class XYEnums {

	/**
	 * 登录用户账号类型
	 * 
	 * @author Administrator
	 *
	 */
	public enum User_Identity_Type {
		ID, PHONE, MAIL, WECHAT, QQ
	}

	/**
	 * POST /uri 创建 DELETE /uri/xxx 删除 PUT /uri/xxx 更新或创建 GET /uri/xxx 查看
	 * 
	 * @author Administrator
	 *
	 */
	public enum METHOD {
		GET, POST, DELETE, PUT
	}
}
