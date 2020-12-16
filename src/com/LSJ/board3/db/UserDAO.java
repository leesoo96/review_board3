package com.LSJ.board3.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.LSJ.board3.model.UserModel;

public class UserDAO extends CommonDAO{

//	로그인 확인
	public static UserModel selUser(UserModel m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " SELECT i_user, nm, user_pw, salt "
					 + " FROM t_user WHERE user_id = ? ";
		
		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUser_id());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				UserModel u = new UserModel();
				u.setI_user(rs.getInt("i_user"));
				u.setNm(rs.getString("nm"));
				u.setUser_pw(rs.getString("user_pw"));
				u.setSalt(rs.getString("salt"));
				
				return u;
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			DBUtils.close(conn, pstmt, rs);
		}
		
		return null;
	}
}
