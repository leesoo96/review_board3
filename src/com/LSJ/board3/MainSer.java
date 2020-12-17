package com.LSJ.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LSJ.board3.common.Utils;

// 메인페이지 서블릿
@WebServlet("/main")
public class MainSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(Utils.isLogout(request)) { 
			response.sendRedirect("/login");
			return;
		} // 로그인 상태가 아닌 경우 로그인 페이지로 이동
                                      // 공통페이지               // 메인페이지
		Utils.forwardTemp("메인페이지", "temp/basic_temp", "main", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
