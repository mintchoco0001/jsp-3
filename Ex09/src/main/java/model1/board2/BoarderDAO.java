package model1.board2;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;

import common.JDBConnect;

public class BoarderDAO extends JDBConnect {
	public BoarderDAO(ServletContext application) {
		super(application);
	}

	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;

		String query = "select count(*) from board";

		if (map.get("searchWord") != null) {
			query += " where " + map.get("searchField") + " like '%" + map.get("searchWord") + "%' ";
		}

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query); // 쿼리문 결과 값 구하기
			rs.next(); // 결과의 첫번째 행으로 이동
			totalCount = rs.getInt(1); // 첫번째 데이터를 총개수 변수에 대입

		} catch (Exception e) {
			System.out.println("게시글 개수 구하기 실패");
			e.printStackTrace();
		}
		return totalCount;
	}

	public List<BoarderDTO> selectList(Map<String, Object> map) {
		List<BoarderDTO> bbs = new Vector<BoarderDTO>();
		String query = "select * from ( select Tb.*, rownum rNum from ( select * from board ";
		
		if (map.get("searchWord") != null) {
			query += " where " + map.get("searchField") + " like '%" + map.get("searchWord") + "%' ";
		}
		query += " order by num desc ) Tb ) where rNum between ? and ?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoarderDTO dto = new BoarderDTO();
				dto.setNum(rs.getNString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));
				bbs.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시글 조회 실패");
			e.printStackTrace();
		}
		return bbs;

	}

	// 게시판 글 추가하기
	public int insertWrite(BoarderDTO dto) {
		int result = 0;

		try {
			String query = "insert into board(num,title,content,id,visitcount) "
					+ "values(seq_board_num.nextval,?,?,?,0)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시글 추가하기 오류");
			e.printStackTrace();
		}

		return result;
	}

	// 게시글의 세부내용 출력하기
	public BoarderDTO selectView(String num) {
		BoarderDTO dto = new BoarderDTO();

		String query = "select B.*, M.name from member M inner join board B on M.id=b.id where num=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));
				dto.setName(rs.getString("name"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시물 출력 오류");
		}
		return dto;
	}

	// 게시물의 조회수 증가
	public void updateVisitCount(String num) {
		String query = "update board set visitcount = visitcount+1 where num=?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			psmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시물 조회수 증가 오류");
		}
	}

	public int updateEdit(BoarderDTO dto) {
		int result = 0;
		
		try {
			String query = "update board set title = ?, content = ? where num = ?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNum());
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시물 수정 오류");
		}
		return result;
	}
	
	public int deletePost(String num) {
		int result = 0;
		
		String query = "delete from board where num = ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시물 삭제 오류");
		}
		return result;
	}
	

}