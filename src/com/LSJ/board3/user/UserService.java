package com.LSJ.board3.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.LSJ.board3.common.SecurityUtils;
import com.LSJ.board3.common.Utils;
import com.LSJ.board3.db.SQLInterUpdate;
import com.LSJ.board3.db.UserDAO;
import com.LSJ.board3.model.UserModel;

public class UserService {

//	회원가입 기능
	public static int join(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String nm = request.getParameter("nm");
		int gender = Utils.getIntParam(request, "gender");
		String phone = request.getParameter("phone");
		
		String salt = SecurityUtils.getSalt(); // 조미료
		
//		암호화된 비밀번호                                                                                재료    + 조미료  => 암호화 
		String encryptPw = SecurityUtils.getSecurePassword(user_pw, salt);
		
		System.out.println("salt:" + salt);
		System.out.println("enryptPw:" + encryptPw);
		
		UserModel model = new UserModel();
		model.setUser_id(user_id);
		model.setUser_pw(encryptPw); // => user_pw 
		model.setSalt(salt);
		model.setNm(nm);
		model.setGender(gender);
		model.setPhone(phone);
		
		String sql = " INSERT INTO t_user "
					 + " (user_id, user_pw, salt, nm, gender, phone) "
					 + " VALUES (?, ?, ?, ?, ?, ?) ";
		
		return UserDAO.executeUpdate(sql, new SQLInterUpdate() {
			
			@Override
			public void proc(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, model.getUser_id());
				pstmt.setString(2, model.getUser_pw());
				pstmt.setString(3, model.getSalt());
				pstmt.setString(4, model.getNm());
				pstmt.setInt(5, model.getGender());
				pstmt.setString(6, model.getPhone());
			}
		});
	}
	
//	로그인 기능  0 = 에러 / 1 = 성공 / 2 = 아이디 없음 / 3 = 비밀번호 틀림
	public static int login(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		UserModel m = new UserModel();
		m.setUser_id(user_id);
		m.setUser_pw(user_pw);
		
		UserModel loginModel = UserDAO.selUser(m);
		if(loginModel == null) {
			return 2; // 아이디없음
		}
		
		String encryptPw = SecurityUtils.getSecurePassword(user_pw, loginModel.getSalt());
	
//		암호화된 비밀번호와 로그인 폼에 입력한 비밀번호가 같으면 
		if(encryptPw.equals(loginModel.getUser_pw())) {
//			로그인 후 세션에 비밀번호가 남아있지않도록 설정(보안)
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginModel);
			loginModel.setSalt(null);
			loginModel.setUser_pw(null);
			
			return 1; // 로그인 성공
		}
		
		return 3; // 비밀번호 다름
	}
}
