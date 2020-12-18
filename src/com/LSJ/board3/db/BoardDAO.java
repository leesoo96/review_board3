package com.LSJ.board3.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.LSJ.board3.model.BoardParam;
import com.LSJ.board3.model.BoardSEL;

public class BoardDAO extends CommonDAO{

//	글 목록 확인하기
	public static List<BoardSEL> showListAll(BoardParam param){
		List<BoardSEL> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " SELECT A.i_board, A.seq, A.title, A.r_dt, "
					 + " A.hits, A.i_user, B.nm "
					 + " FROM t_board A "
					 + " INNER JOIN t_user B "
					 + " ON A.i_user = B.i_user " 
					 + " WHERE A.typ = ? "
					 + " ORDER BY A.seq DESC ";
//		ON A.i_user = B.i_user -> 같은 값을 가리키도록 함 
		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, param.getTyp());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardSEL sel = new BoardSEL();
				
				sel.setI_board(rs.getInt("i_board"));
				sel.setTyp(param.getTyp());
				sel.setSeq(rs.getInt("seq"));
				sel.setTitle(rs.getNString("title"));
				sel.setR_dt(rs.getString("r_dt"));
				sel.setHits(rs.getInt("hits"));
				sel.setI_user(rs.getInt("i_user"));
				sel.setNm(rs.getString("nm"));
				
				list.add(sel);
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			DBUtils.close(conn, pstmt, rs);
		}
		
		return list;
	}
}
