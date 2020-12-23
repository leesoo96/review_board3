package com.LSJ.board3.board.cmt;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.LSJ.board3.common.SecurityUtils;
import com.LSJ.board3.common.Utils;
import com.LSJ.board3.db.BoardCmtDAO;
import com.LSJ.board3.db.BoardDAO;
import com.LSJ.board3.db.SQLInterUpdate;
import com.LSJ.board3.model.BoardCmtSEL;
import com.LSJ.board3.model.BoardParam;

public class BoardCmtService {

//	댓글 목록 확인
	public static List<BoardCmtSEL> showCmtList(BoardParam param){
		return BoardCmtDAO.showCmtList(param);
	}
	
//	댓글 쓰기 
	public static String insertCmt(HttpServletRequest request) {
		int i_board = Utils.getIntParam(request, "i_board");
		int i_user = SecurityUtils.getLogin_user(request);
		String ctnt = request.getParameter("ctnt");
		
		String sql = " INSERT INTO t_board_cmt "
					 + " (i_board, i_user, ctnt) "
					 + " VALUES (?, ?, ?) ";
		
		BoardDAO.executeUpdate(sql, new SQLInterUpdate() {
			
			@Override
			public void proc(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, i_board);
				pstmt.setInt(2, i_user);
				pstmt.setString(3, ctnt);
			}
		});
	  return "../bDetail?i_board=" + i_board;
	}
	
//	댓글 수정
	
//	댓글 삭제
	public static String del(HttpServletRequest request) {
		int i_cmt = Utils.getIntParam(request, "i_cmt");
		int i_board = Utils.getIntParam(request, "i_board");
		int i_user = SecurityUtils.getLogin_user(request);
		
		String sql = " DELETE FROM t_board_cmt "
					 + " WHERE i_cmt = ? "
					 + " AND i_user = ? ";
		
		BoardDAO.executeUpdate(sql, new SQLInterUpdate() {
			
			@Override
			public void proc(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, i_cmt);
				pstmt.setInt(2, i_user);
			}
		});
		
		return " ../bDetail?i_board=" + i_board;
	}
}
