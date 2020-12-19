package com.LSJ.board3.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LSJ.board3.common.Utils;

@WebServlet("/board/bDel")
public class BoardDelSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = BoardService.delCtnt(request);
		
		int typ = Utils.getIntParam(request, "typ");
		response.sendRedirect("list?typ=" + typ);
	}
}
