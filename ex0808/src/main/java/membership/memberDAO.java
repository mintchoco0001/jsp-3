package membership;

import common.JDBConnect;

public class memberDAO extends JDBConnect {
	public memberDAO(String driver, String url, String id, String pw) {
		super(driver, url, id, pw);
	}

	public memberDTO getMemberDTO(String uid, String upass) {
		memberDTO dto = new memberDTO();
		String query = "select * from member where id = ? and pass = ?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	// 회원 추가를 위한 메소드
	public int setMemberDTO(String uid, String upass, String uname, String today) {
		memberDTO dto = new memberDTO();
		String query = "insert into member (id, pass, name) values (?,?,?,?)";
		int result = 0;
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			psmt.setString(3, uname);
			psmt.setString(4, today);
			result = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
