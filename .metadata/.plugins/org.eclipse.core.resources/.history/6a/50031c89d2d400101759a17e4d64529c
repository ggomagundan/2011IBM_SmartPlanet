package com.ibm.pumpsoft;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class FriendBean
 */
@Stateless
@LocalBean
public class FriendBean implements FriendBeanLocal {

	
	@Resource(name="pump_Database",type=javax.sql.DataSource.class)
	private javax.sql.DataSource ds;
    /**
     * Default constructor. 
     */
    public FriendBean() {
        // TODO Auto-generated constructor stub
    }

    public int getCountFriends(String id){
    	
    	String read_db = "select count(*) count from friends where user_id1 = '"+id +"'";

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
    
    public String getSQL(String id, int start, int end){
    	
    	String read_db = "select * from "
			+ "(select row_number() over (order by id asc)" 
			+ "as rownum, id, id, nickname, point, plant_donation_count pdc" 
			+ " from friends, users where user_id1 = '"
			+ id 
			+ "' and user_id2 = users.id) as a where a.rownum between " 
			+ start + " and  " +  end;
    	
    	return read_db;
    	
    }
    
    
	public ArrayList<String> getFriendsList(String id, int start, int end){
	    	
		ArrayList<String> friendList = new ArrayList<String>();
		
	    	String read_db = "select * from "
	    					+ "(select row_number() over (order by id asc)" 
	    					+ "as rownum, id, id, nickname, point, plant_donation_count pdc" 
							+ " from friends, users where user_id1 = '"
							+ id 
							+ "' and user_id2 = users.id) as a where a.rownum between " 
							+ start + " and  " +  end;
	
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
					
					result += rs.getString("id") + "!PuMp!";
					result += rs.getString("nickname") + "!PuMp!";
					result += Integer.toString(rs.getInt("point")) + "!PuMp!";
					result += Integer.toString(rs.getInt("pdc")) + "!PuMp!";
					result += Integer.toString(rs.getInt("rownum")) + "!PuMp!";
					
					// Get Value By SQL Result Set
					friendList.add(result);
					result = "";
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
			
			return friendList;
	
	    	
    }

	public int isFriend(String id, String fid){
		
		
		
		String read_db = "select count(*) count from friends where user_id1 = '"
						+ id
						+ "' and user_id2 = '"
						+ fid + "'"; 
	
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

	@Override
	public String getUserInfo(String id) {
		// TODO 자동 생성된 메소드 스텁
		
    	String read_db = "select id, nickname from users where id = '" 
    					+ id 
    					+ "'";

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
				
				result += rs.getString("id") + "!PuMp!";
				result += rs.getString("nickname") + "!PuMp!";
				
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
    
	
	 public int insertFriend(String id, String f_id){
		
	    	String read_db = "insert into friends(user_id1, user_id2) values('" 
	    					+ id + "', '"+ f_id + "')";
	    	
	    	// Query String
	    	
	    	Connection conn = null;
	    	PreparedStatement pstmt = null;
	    	int rs = 0, rs1=0;
	    	
	    	rs1 = isFriend(id, f_id);
	    	try {
				conn= ds.getConnection();
				pstmt = conn.prepareStatement(read_db);
				
				rs = pstmt.executeUpdate();
				
			
					
				
			
				
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
			
			return rs;
			
	    	
	    }
}
