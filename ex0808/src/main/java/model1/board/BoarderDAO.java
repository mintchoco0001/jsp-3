package model1.board;

import java.util.*;

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
		String query = "select *from board";
		if (map.get("searchWord") != null) {
			query += " where " + map.get("searchField") + " like '%" + map.get("searchWord") + "%' ";
			query += " order by num desc";
		}

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

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

}