package com.ibm.pumpsoftejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ejb.Stateless;

import com.ibm.ws.batch.xJCL.beans.returnCodeExpression;






/**
 * Session Bean implementation class SessionBean
 */
@Stateless
public class SessionBean implements SessionBeanLocal {

	@Resource(name="pump_Database",type=javax.sql.DataSource.class)
	private javax.sql.DataSource ds;
	
    /**
     * Default constructor. 
     */
    public SessionBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String getString(){
    	return "EJB Session Test";
    	
    }
    
    /* (비Javadoc)
     * @see com.ibm.pumpsoftejb.SessionBeanLocal#readDB()
     */
    public String readDB(){
    	
    	String read_db = "select count(*) from friends where user_id1 = 'id'";
    	// Query String
    	String result = "";
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeQuery();
			
		
				
			while(rs.next()){
				result+="value : ";
				result += rs.getString("1")+ "\n";
				// Get Value By SQL Result Set
					
			}
		
			
		} catch (SQLException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!= null){
				
					pstmt.close();
				} 
			}catch (SQLException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
			
		
			try {
				if(conn!= null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
	
				
		}
		
		
		return result;
    	
    }
    
   
    public ArrayList<String> getUserList(){
    	
    	ArrayList<String> userList = new ArrayList<String>();
    	
    	String read_db = "select * from users";
    	// Query String
    	String result = "";
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeQuery();
			
			
				
			while(rs.next()){
				
				result += rs.getString("ID")+ "!PuMp!";
				result += rs.getString("NICKNAME")+ "!PuMp!";
				result += rs.getString("PASSWORD")+ "!PuMp!";
				result += Integer.toString(rs.getInt("POINT"))+ "!PuMp!";
				result += Short.toString(rs.getShort("GRADE"))+ "!PuMp!";
				
				result += Integer.toString(rs.getInt("PLANT_DONATION_COUNT"))+ "!PuMp!";
				userList.add(result);
				result = "";
				
				
				// Get Value By SQL Result Set
					
			}
		
			
		} catch (SQLException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!= null){
				
					pstmt.close();
				} 
			}catch (SQLException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
			
		
			try {
				if(conn!= null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
    	
    	
		}
    
		return userList;
    }
}
