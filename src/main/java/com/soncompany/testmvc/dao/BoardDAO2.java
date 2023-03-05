package com.soncompany.testmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.soncompany.testmvc.database.DBConnection2;
import com.soncompany.testmvc.vo.Board2;

public class BoardDAO2 {

	private static BoardDAO2 dao = null;
	
	private BoardDAO2() {
		
	}
	
	public static BoardDAO2 getInstance() {
		if(dao == null) {
			dao = new BoardDAO2();
		}
		return dao;
	}
	
	public ArrayList<Board2> getBoards() {		// list
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board2> list = null;
		
		try {
			conn = DBConnection2.getConnection();
			String query = "select * from board2";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			list = new ArrayList<Board2>();
			
			while(rs.next()) {
				Board2 board2 = new Board2();
				board2.setB_idx(rs.getInt("b_idx"));
				board2.setB_title(rs.getString("b_title"));
				board2.setB_content(rs.getString("b_content"));
				board2.setB_views(rs.getInt("b_views"));
				board2.setB_writer(rs.getString("b_writer"));
				board2.setB_date(rs.getString("b_date"));
				list.add(board2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}
}
