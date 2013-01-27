package com.ibm.pumpsoftejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class LoginBean
 */
@Stateless
@LocalBean
public class LoginBean implements LoginBeanLocal {

    /**
     * Default constructor. 
     */
	
	@Resource(name=	"pump_Database",type=javax.sql.DataSource.class)
	private javax.sql.DataSource ds;
	
    public LoginBean() {
        // TODO Auto-generated constructor stub
    }
    
    public int login(String id, String password){
    	
    	String read_db = "select count(*) count from users where id = '" + id 
    					+ "' and password = encrypt('"
    					+ password + "','pumpsoft')";
    	
    	// Query String
    	int result = 0;
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeQuery();
			
		
				
			while(rs.next()){
				
				result = rs.getInt("count");
				// Get Value By SQL Result Set
					
			}
		
			
		} catch (SQLException e) {
			// TODO �ڵ� ������ catch ����
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!= null){
				
					pstmt.close();
				} 
			}catch (SQLException e) {
				// TODO �ڵ� ������ catch ����
				e.printStackTrace();
			}
			
		
			try {
				if(conn!= null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO �ڵ� ������ catch ����
				e.printStackTrace();
			}
	
				
		}
		
		return result;
		
    	
    }
    
    
    public String get(String id, String nickname, String passwd){
    	
    	return "insert into users(id, nickname, password)  values('" 
			+ id + "', '"+ nickname + "', encrypt('"+passwd + "','pumpsoft')";
    	
    }
    
    public int insertUser(String id, String nickname, String passwd){
    	
    	String read_db = "insert into users(id, nickname, password)  values('" 
    					+ id + "', '"+ nickname + "', encrypt('"+passwd + "','pumpsoft'))";
    	
    	// Query String
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	int rs = 0;
    	
    	try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeUpdate();
			
		
				
			
		
			
		} catch (SQLException e) {
			// TODO �ڵ� ������ catch ����
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!= null){
				
					pstmt.close();
				} 
			}catch (SQLException e) {
				// TODO �ڵ� ������ catch ����
				e.printStackTrace();
			}
			
		
			try {
				if(conn!= null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO �ڵ� ������ catch ����
				e.printStackTrace();
			}
	
				
		}
		
		return rs;
		
    	
    }
    
   public int updateUserPoint(int point, String id){
    	
    	String read_db = "update users set point = point + "  + point  + " where id = '" + id + "'";
    	
    	// Query String
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	int rs = 0;
    	
    	try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeUpdate();
			
		
				
			
		
			
		} catch (SQLException e) {
			// TODO �ڵ� ������ catch ����
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!= null){
				
					pstmt.close();
				} 
			}catch (SQLException e) {
				// TODO �ڵ� ������ catch ����
				e.printStackTrace();
			}
			
		
			try {
				if(conn!= null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO �ڵ� ������ catch ����
				e.printStackTrace();
			}
	
				
		}
		
		return rs;
		
    	
    }
   
   public int updateUserGrade(int grade, String id){
   	
   	String read_db = "update users set grade = "  + grade  + " where id = '" + id + "'";
   	
   	// Query String
   	
   	Connection conn = null;
   	PreparedStatement pstmt = null;
   	int rs = 0;
   	
   	try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeUpdate();
			
		
				
			
		
			
		} catch (SQLException e) {
			// TODO �ڵ� ������ catch ����
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!= null){
				
					pstmt.close();
				} 
			}catch (SQLException e) {
				// TODO �ڵ� ������ catch ����
				e.printStackTrace();
			}
			
		
			try {
				if(conn!= null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO �ڵ� ������ catch ����
				e.printStackTrace();
			}
	
				
		}
		
		return rs;
		
   	
   }


   
   public int getPoint(String id){
   	
   	String read_db = "select point from users " 
   					+ "where id = '" 
   					+ id +"'";

		// Query String
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeQuery();
		
		
		
			while(rs.next()){
			
				result = rs.getInt("point");
				// Get Value By SQL Result Set
				
			}
		
		
		} catch (SQLException e) {
			// TODO �ڵ� ������ catch ����
			e.printStackTrace();
			}finally {
			try {
				if(pstmt!= null){
			
					pstmt.close();
				} 
			}catch (SQLException e) {
					// TODO �ڵ� ������ catch ����
					e.printStackTrace();
			}
		
		
			try {
				if(conn!= null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO �ڵ� ������ catch ����
				e.printStackTrace();
			}
		
		
		}
		
		return result;

   	
   	
   }
   
   
}