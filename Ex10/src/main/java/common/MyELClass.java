package common;

import java.util.Iterator;

public class MyELClass {
	public String getGender(String jumin) {
		String returnStr = "";

		int beginIdx = jumin.indexOf("-") + 1;

		String genderStr = jumin.substring(beginIdx, beginIdx + 1);
		int genderInt = Integer.parseInt(genderStr);

		if (genderInt == 1 || genderInt == 3) {
			returnStr = "남자";
		} else if (genderInt == 2 || genderInt == 4) {
			returnStr = "여자";
		} else {
			returnStr = "주민등록번호 입력 오류";
		}

		return returnStr;
	}

	public static String showGugudan(int limitDan) {
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<table border = '1'>");
			for (int i = 1; i <= limitDan; i++) {
				sb.append("<tr>");
				for (int j = 1; j <= 9; j++) {
					sb.append("<td>"+i+"*"+j+"="+(i*j)+"</td>");
				}
				sb.append("</tr>");
			}
			sb.append("</table>");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("구구단 예외 발생");
		}
		return sb.toString();
	}
}
