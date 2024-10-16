package common;

import java.sql.*;

import javax.servlet.ServletContext;

public class JDBConnect {
	public Connection con;
	public Statement stmt; //정적 쿼리
	public PreparedStatement psmt; //동적 쿼리
	public ResultSet rs;

	public JDBConnect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// 오라클 드라이버
			// mysql 드라이버는 com.mysql.jdbc.Driver 임

			// db 연결 정보 작성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "musthave";
			String pw = "1234";
			con = DriverManager.getConnection(url, id, pw);

			System.out.println("연결 성공");
		} catch (Exception e) {
			System.out.println("연결실패");
		}
	}

	public JDBConnect(String driver, String url, String id, String pw) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("웹파일을 이용한 DB연결 성공");
		} catch (Exception e) {
			System.out.println("웹파일을 이용한 DB연결 실패");
		}
	}

	public JDBConnect(ServletContext application) {
		try {
			String driver = application.getInitParameter("OracleDriver");
			Class.forName(driver);

			String url = application.getInitParameter("OracleURL");
			String id = application.getInitParameter("OracleId");
			String pw = application.getInitParameter("OraclePw");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("웹파일을 이용한 DB연결 2 성공");

		} catch (Exception e) {
			System.out.println("웹파일을 이용한 DB연결 2 실패");
		}
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
			System.out.println("정상적으로 데이터베이스 종료");
		} catch (Exception e) {
			System.out.println("데이터베이스 종료 오류");
		}

	}

}
