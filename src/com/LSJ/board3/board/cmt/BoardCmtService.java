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

//	댓글 목록 확인 - 미완
	public static List<BoardCmtSEL> showCmtList(HttpServletRequest request){
		int i_cmt = Utils.getIntParam(request, "i_cmt");
		
		BoardParam param = new BoardParam();
		param.setI_cmt(i_cmt);
		
		return BoardCmtDAO.showCmtList(param);
	}
	
//	댓글 쓰기 - 미완
	public static int insertCmt(HttpServletRequest request) {
		int i_cmt = Utils.getIntParam(request, "i_cmt");
		int i_board = Utils.getIntParam(request, "i_board");
		int i_user = Utils.getIntParam(request, "i_user");
		String ctnt = request.getParameter("ctnt");
		String r_dt = request.getParameter("r_dt");
		
		String sql = " INSERT INTO t_board_cmt "
					 + " (i_user, ctnt, r_dt) "
					 + " VALUES (?, ?, ?) "
					 + " WHERE i_board = ? ";
		
		return BoardDAO.executeUpdate(sql, new SQLInterUpdate() {
			
			@Override
			public void proc(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, i_user);
				pstmt.setString(2, ctnt);
				pstmt.setNString(3, r_dt);
				pstmt.setInt(4, i_board);
			}
		});
	}
}
