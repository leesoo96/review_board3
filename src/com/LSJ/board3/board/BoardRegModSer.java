package com.LSJ.board3.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LSJ.board3.common.SecurityUtils;
import com.LSJ.board3.common.Utils;

@WebServlet("/board/bRegmod")
public class BoardRegModSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int typ = Utils.getIntParam(request, "typ");
		
		if(SecurityUtils.isLogout(request)) {
			response.sendRedirect("/login");
			return;
		}
		
		int i_board = Utils.getIntParam(request, "i_board");
		if(i_board > 0) {
			request.setAttribute("data", BoardService.read(request));
		}
		
		request.setAttribute("jsList", new String[] {"board"});
		request.setAttribute("typ", typ);

		Utils.forwardTemp("등록/수정", "temp/basic_temp", "board/bRegmod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(BoardService.regMod(request));
	}

}
