package TOEIC_WORD_900;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class LoginReq {

	static final String id = "root";
	static final String pass = "root";
	String url = "jdbc:mysql://127.0.0.1:3306/java?serverTimezone=UTC";
	
	LoginReq(){
		System.out.println("MySQL JDBC 드라이버 로딩중...");
		try {
			///////////////////////////////////////
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("MySQL JDBC 드라이버 로딩 성공...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void registerUser(String name, String idL, String passL) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//중복 아이디 존재
		if(idExist(idL)) {
			System.out.println("invaild id");
			JOptionPane.showMessageDialog(null, "아이디 중복");
			return;
		}else {
		
			try {
				conn = DriverManager.getConnection(url,id,pass);
				String query = "insert into mem(name,id,pass) values (?,?,?)";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, name);
				pstmt.setString(2, idL);
				pstmt.setString(3, passL);
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
	
	//아이디 있는지 확인
	public boolean idExist(String usrid) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url,id,pass);
			String query = "select * from mem where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, usrid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	
		//12.01
	  //모든 유저 아이디 반환
	   public AdvanceUserArray getAllUser() {
	      AdvanceUserArray aua=new AdvanceUserArray();
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         conn = DriverManager.getConnection(url,id,pass);
	         String query = "select * from mem";
	         pstmt = conn.prepareStatement(query);
	         rs = pstmt.executeQuery();
	         UserInfo uu;
	         while(rs.next()) {
					uu=new UserInfo(rs.getString("id"),rs.getString("pass"),rs.getString("id"));
					aua.setUserInfo(uu);
				}
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	         } catch(Exception e) {
	            e.printStackTrace();
	         }
	      }
	      return aua;
	   }
	
	public UserInfo loginReq(String usrid, String usrpass) {
		UserInfo uifo=new UserInfo(usrid,usrpass);
		boolean isExist = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url,id,pass);
			String query = "select* from mem where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, usrid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs != null) {
					if(usrpass.equals(rs.getString("pass"))){
						uifo.setName(rs.getString("name"));
					}
					else {
						//Not equal Password
						return uifo; //name == null
					}
					isExist=true;
				}
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(isExist)
			return uifo;
		else {
			return uifo;
			//this 'uifo' : 'name' == null 
		}
			
	}
	
}
