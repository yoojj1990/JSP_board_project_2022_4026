package com.yjj.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class BDao {

	static String driverName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/webdb";
	static String user = "root";
	static String password = "yoojj1990";
	
public void write(String bid, String bname, String btitle, String bcontent) {
		
		String sql = "INSERT INTO jsp_board(bid, bname, btitle, bcontent, bhit) VALUES('" + bid + "','" + bname + "','" + btitle + "','" + bcontent + "',0)";
		
		int dbFlag = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;//sql 실행 객체
		
		try {
			Class.forName(driverName);//jdbc 드라이버 로딩
			conn = DriverManager.getConnection(url, user, password);//DB 연동			
			pstmt = conn.prepareStatement(sql);
			
			dbFlag = pstmt.executeUpdate();//sql실행->실행 성공시 1 반환
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}			
			
		}
		

		
	}
	
}
