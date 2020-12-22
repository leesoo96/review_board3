package com.LSJ.board3.board.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LSJ.board3.board.BoardService;
import com.LSJ.board3.common.Utils;

@WebServlet("/board/cmt/reg")
public class BoardCmtRegSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_board = Utils.getIntParam(request, "i_board");
		System.out.println(i_board+"dd");
//		미완

		
	}
}
