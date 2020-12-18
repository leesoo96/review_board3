package com.LSJ.board3.board;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.LSJ.board3.common.SecurityUtils;
import com.LSJ.board3.common.Utils;
import com.LSJ.board3.db.BoardDAO;
import com.LSJ.board3.db.SQLInterUpdate;
import com.LSJ.board3.model.BoardParam;
import com.LSJ.board3.model.BoardSEL;

public class BoardService {
	
//	글 목록 
	public static List<BoardSEL> showList(HttpServletRequest request) {
		int typ = Utils.getIntParam(request, "typ");
		
		BoardParam param = new BoardParam();
		param.setTyp(typ);
		
		return BoardDAO.showListAll(param);
	}
	
	
//	글 등록 / 글 수정
	public static int regMod(HttpServletRequest request) {
		int i_board = Utils.getIntParam(request, "i_board");
		int typ = Utils.getIntParam(request, "typ");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int i_user = SecurityUtils.getLogin_user(request);
		
		if(i_board == 0) {
//			글 등록
			String sql = " INSERT INTO t_board "
					+ " (typ, seq, title, ctnt, i_user) "
					+ " SELECT ?, "
//					    seq가 NULL(글없음)이면 0으로 하고 +1
					+ " IFNULL(MAX(seq), 0) + 1, ?, ?, ? "
					+ " FROM t_board "
					+ " WHERE typ = ? ";
			
			BoardDAO.executeUpdate(sql, new SQLInterUpdate() {
				
				@Override
				public void proc(PreparedStatement pstmt) throws SQLException {
					pstmt.setInt(1, typ);
					pstmt.setNString(2, title);
					pstmt.setNString(3, ctnt);
					pstmt.setInt(4, i_user);
					pstmt.setInt(5, typ);
				}
			});
		}else {
//			TODO 글 수정
		}
		
		return 0;
	}
}
