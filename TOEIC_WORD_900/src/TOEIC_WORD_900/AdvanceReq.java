package TOEIC_WORD_900;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdvanceReq {
   static final String id = "root";
   static final String pass = "root";
   String url = "jdbc:mysql://127.0.0.1:3306/java?serverTimezone=UTC";
   
   AdvanceReq(){
      System.out.println("MySQL JDBC 드라이버 로딩중...");
      try {
         ///////////////////////////////////////
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         System.out.println("MySQL JDBC 드라이버 로딩 성공...");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   
   //챕터 반환
   public int getNowChap(String usrid) {
      int chap=0;
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         conn = DriverManager.getConnection(url,id,pass);
         String query = "select * from test where id = ?";
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, usrid);
         rs = pstmt.executeQuery();
         while(rs.next()) {
            if(rs!=null && rs.getBoolean("pass")) {
               chap=rs.getInt("unit");
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
      return chap;
   }
   
 
   
   
   	//주어진 유닛 정답률 반환 
 	public int getAnsRatio(String usrid, int unit) {
 		int ansRatio=0;
 		Connection conn = null;
 		PreparedStatement pstmt = null;
 		ResultSet rs = null;
 		try {
 			conn = DriverManager.getConnection(url,id,pass);
 			String query = "select * from test where id = ? and unit = ?";
 			pstmt = conn.prepareStatement(query);
 			pstmt.setString(1, usrid);
 			pstmt.setInt(2, unit);
 			rs = pstmt.executeQuery();
 			while(rs.next()) {
 				if(rs!=null && rs.getBoolean("pass")) {
 					ansRatio=rs.getInt("ansRatio");
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
 		return ansRatio;
 	}
   
 	//주어진 유닛 틀린것 반환 
 	 	public String getWrong(String usrid, int unit) {
 	 		String wrong="";
 	 		Connection conn = null;
 	 		PreparedStatement pstmt = null;
 	 		ResultSet rs = null;
 	 		try {
 	 			conn = DriverManager.getConnection(url,id,pass);
 	 			String query = "select * from test where id = ? and unit = ?";
 	 			pstmt = conn.prepareStatement(query);
 	 			pstmt.setString(1, usrid);
 	 			pstmt.setInt(2, unit);
 	 			rs = pstmt.executeQuery();
 	 			while(rs.next()) {
 	 				if(rs!=null && rs.getBoolean("pass")) {
 	 					wrong=rs.getString("wrong");
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
 	 		return wrong;
 	 	}
   
   
   public void insertInfo(String usrid,int unit,int ansRatio,Boolean passf,String wrong) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      try {
         
         conn = DriverManager.getConnection(url,id,pass);
         String query = "insert into test(id,unit,ansRatio,pass,wrong) values (?,?,?,?,?)";
         pstmt = conn.prepareStatement(query);   
         pstmt.setString(1, usrid);
         pstmt.setInt(2, unit);
         pstmt.setInt(3, ansRatio);
         pstmt.setBoolean(4, passf);
         pstmt.setString(5, wrong);
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