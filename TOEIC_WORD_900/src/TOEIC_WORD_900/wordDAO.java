package TOEIC_WORD_900;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class wordDAO {
	public static File file;
	public static FileReader filereader;
	public static BufferedReader bufReader;
	static final String id = "root";
	static final String pass = "1234";
	static String url = "jdbc:mysql://127.0.0.1:3306/java?serverTimezone=UTC";

public wordDAO() {
	System.out.println("MySQL JDBC 드라이버 로딩중...");
	try {
		///////////////////////////////////////
		Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("MySQL JDBC 드라이버 로딩 성공...");
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public static word_unit getUnit(int unit)  {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	word_unit result=new word_unit(unit);
	try {
		conn = DriverManager.getConnection(url,id,pass);
		String query = "select * from words";
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			wordDTO dto = new wordDTO();
			dto.setunit(rs.getInt("unit"));
			if(dto.getunit()!=unit) {
				continue;
			}
			dto.setword(rs.getString("word"));
			dto.setmean(rs.getString("mean"));
			result.get_DTO(dto);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	return result;
}
public static word_unit getWrongUnit(int unit,String wrong)  {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	word_unit result=new word_unit(unit);
	try {
		conn = DriverManager.getConnection(url,id,pass);
		String query = "select * from words";
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();
		int i=0;
		while(rs.next()) {
			
			wordDTO dto = new wordDTO();
			dto.setunit(rs.getInt("unit"));
			if(dto.getunit()!=unit) {
				continue;
			}
			if(wrong.charAt(i)=='1') {
				dto.setword(rs.getString("word"));
				dto.setmean(rs.getString("mean"));
				result.get_DTO(dto);
			}
			i++;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	return result;
		
}
public static void insert(int unit,String word,String mean) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		
		conn = DriverManager.getConnection(url,id,pass);
		String query = "insert into words(unit,word,mean) values (?,?,?)";
		pstmt = conn.prepareStatement(query);	
		pstmt.setInt(1, unit);
		pstmt.setString(2, word);
		pstmt.setString(3, mean);
		pstmt.executeUpdate();
				
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

}
