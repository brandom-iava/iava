// Source File Name:   WebHelper.java

package com.iava.utils;

import java.io.PrintStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.http.*;

public final class WebHelper {

	public WebHelper() {
	}
	public static void setCookie(HttpServletResponse response,
			String cookieName, String cookieValue) {
		try {
			Cookie cookie = new Cookie(URLEncoder.encode(cookieName, "GBK"),
					URLEncoder.encode(cookieValue, "GBK"));
			response.addCookie(cookie);
		} catch (Exception e) {
			System.out
					.println("/***************\u5199\u5165cookie\u9519\u8BEF*********************/");
			System.out.println(e.getCause());
			System.out
					.println("/***************\u5199\u5165cookie\u9519\u8BEF*********************/");
		}
	}

	public static String getCookie(HttpServletRequest request, String cookieName) {
		String value = null;
		try {
			Cookie cks[] = request.getCookies();
			for (int i = 0; i < cks.length; i++) {
				if (!URLDecoder.decode(cks[i].getName(), "GBK")
						.equalsIgnoreCase(cookieName))
					continue;
				value = URLDecoder.decode(cks[i].getValue(), "GBK");
				break;
			}

		} catch (Exception e) {
			System.out
					.println("/***************\u8BFB\u53D6cookie\u9519\u8BEF*********************/");
			System.out.println(e.getCause());
			System.out
					.println("/***************\u8BFB\u53D6cookie\u9519\u8BEF*********************/");
		}
		return value;
	}

	public static String toChinese(String strvalue) {
		try {
			if (strvalue == null) {
				return null;
			} else {
				strvalue = new String(strvalue.getBytes("ISO8859_1"), "GBK");
				return strvalue;
			}
		} catch (Exception e) {
			return null;
		}
	}
}
