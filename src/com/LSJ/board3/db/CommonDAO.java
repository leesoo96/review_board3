package com.LSJ.board3.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CommonDAO {

	public static int executeUpdate(String sql, SQLInterUpdate siu) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			siu.proc(pstmt);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			DBUtils.close(conn, pstmt);
		}
		
		return 0;
	}
}
