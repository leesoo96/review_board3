package com.LSJ.board3.user;

import javax.servlet.http.HttpServletRequest;

import com.LSJ.board3.common.SecurityUtils;
import com.LSJ.board3.common.Utils;
import com.LSJ.board3.model.UserModel;

public class UserService {

	public static int join(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String nm = request.getParameter("nm");
		int gender = Utils.getIntParam(request, "gender");
		String phone = request.getParameter("phone");
		
		byte[] salt = SecurityUtils.getSalt();
		String enryptPw = SecurityUtils.getSecurePassword(user_pw, salt);
		
		UserModel model = new UserModel();
		model.setUser_id(user_id);
		model.setUser_pw(user_pw);
		model.setNm(nm);
		model.setGender(gender);
		model.setPhone(phone);
		
		return 0;
	}
}
