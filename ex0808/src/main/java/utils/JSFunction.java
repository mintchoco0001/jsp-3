package utils;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TryCatchFinally;

public class JSFunction {

	public static void alertLocation(String msg, String url, JspWriter out) {
		try {
			String script = "<script>" + "alert('" + msg + "');" + "location.href='" + url + "';" + "</script>";
			out.print(script);
		} catch (Exception e) {
			System.out.println("스크립트 경고창 이동 오류");
		}

	}

	public static void alertBack(String msg, JspWriter out) {
		try {
			String script = "<script>" + "alert('" + msg + "');" + "history.back();" + "</script>";
			out.print(script);
		} catch (Exception e) {
			System.out.println("스크립트 돌아가기 오류");
		}
	}

}
