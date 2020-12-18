package com.LSJ.board3.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LSJ.board3.common.SecurityUtils;
import com.LSJ.board3.common.Utils;

@WebServlet("/join")
public class JoinSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!SecurityUtils.isLogout(request)) { 
			response.sendRedirect("/main");
			return;
		} // 로그인했을 경우 main으로 이동
		
		Utils.forward("회원가입", "user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = UserService.join(request);
		
		response.sendRedirect("/login");
	}

}
