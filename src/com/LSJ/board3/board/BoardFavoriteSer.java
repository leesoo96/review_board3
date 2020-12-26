package com.LSJ.board3.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LSJ.board3.common.Utils;

@WebServlet("/board/ajax_thumbsUp")
public class BoardFavoriteSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int state = Utils.getIntParam(request, "state");
		System.out.println("state = " + state);
//		1 좋아요 안누름 / 0 좋아요 누름상태 
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().write(BoardService.ajax_thumbsUp(request));
	}
}
