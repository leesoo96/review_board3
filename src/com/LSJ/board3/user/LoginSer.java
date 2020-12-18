package com.LSJ.board3.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LSJ.board3.common.SecurityUtils;
import com.LSJ.board3.common.Utils;

@WebServlet("/login")
public class LoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!SecurityUtils.isLogout(request)) { 
			response.sendRedirect("/main");
			return;
		} // 로그인했을 경우 main으로 이동
		
		Utils.forward("로그인", "user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = UserService.login(request);
		
		if(result == 1) {
			response.sendRedirect("/main");
			return;
		}
		
		switch (result) {
		case 2:
			request.setAttribute("msg", "아이디를 확인해주세요!");
			break;
		case 3:
			request.setAttribute("msg", "비밀번호가 다릅니다!");
			break;
		}
		
//		로그인 실패 시 입력한 아이디 값 유지
		String user_id = request.getParameter("user_id");
		request.setAttribute("id", user_id);
		
		doGet(request, response);
		
		System.out.println("로그인result = " + result);
	}

}
