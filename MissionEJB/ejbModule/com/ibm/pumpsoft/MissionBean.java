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
 * Session Bean implementation class MissionBean
 */
@Stateless
@LocalBean
public class MissionBean implements MissionBeanLocal {

	@Resource(name="pump_Database",type=javax.sql.DataSource.class)
	private javax.sql.DataSource ds;
	
    /**
     * Default constructor. 
     */
    public MissionBean() {
        // TODO Auto-generated constructor stub
    }
    
    public int countMission(){
    	
    	String read_db = "select count(*) count from missions";
    	
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
    
    public int countMissionType(short type){
    	
    	String read_db = "select count(*) count from missions where type= " + type;
    	
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

    public ArrayList<String> getMissionList(short type, int start, int end){
    	
    	
    	
    	
    	String read_db = "select * from (select row_number() over (order by id desc) as rownum, id, name, point, url " 
    					+ "from missions where type = " 
    					+ type
    					+ ") as a where a.rownum between "
    					+ start + " and  " + end;
    	
    	// Query String
    	ArrayList<String> list = new ArrayList<String>();
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
				result += rs.getString("name") + "!PuMp!";
				result += Integer.toString(rs.getInt("point")) + "!PuMp!";
				result += rs.getString("url") + "!PuMp!";
				result += Integer.toString(rs.getInt("rownum")) + "!PuMp!";
				
				// Get Value By SQL Result Set
				list.add(result);
				result= "";
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
		
		return list;
		
    	
    }

    public String getMissionContent(int id){
    	
    	String read_db = "select description from missions where id = " + id;
    	
    	// Query String
    	String result = null ;
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeQuery();
			
		
				
			while(rs.next()){
				
				result = rs.getString("description");
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
    
    
    
    
    public String getLatelyMissionInstance(){
    	
    	String read_db = "select id from mission_instances order by id desc fetch first 1 rows only";
    	
    	// Query String
    	String result = null ;
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeQuery();
			
		
				
			while(rs.next()){
				
				result = rs.getString("id");
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
    
    
    
    public int countUserHavingMission(String id){
    	
    	String read_db = "select count(*) count from missions m, mission_instances mi, missions_users mu" 
    					+ "where mu.user_id = " + id
    					+ "and mu.mission_instance_id = mi.id and "
    					+ "mi.mission_id = m.id and goal > achievement_point";
    	
    	// Query String
    	int result =0;
    	
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
   
    public ArrayList<String> getUserHavingMission(String id){

    	
    	String read_db = "select name, type, goal, point, description desc, url, achievement_point ap, "
    					+ "start_time st from missions m, mission_instances mi, missions_users mu " 
    					+ "where mu.user_id = '" + id 
    					+ "' and mu.mission_instance_id = mi.id and mi.mission_id = m.id and goal > achievement_point";
    	
    	// Query String
    	ArrayList<String> list = new ArrayList<String>();
    	String result = "";
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeQuery();
			
		
				
			while(rs.next()){
				
				result += rs.getString("name") + "!PuMp!";
				result += Short.toString(rs.getShort("type")) + "!PuMp!";
				result += Integer.toString(rs.getInt("goal")) + "!PuMp!";
				result += Integer.toString(rs.getInt("point")) + "!PuMp!";
				result += rs.getString("desc") + "!PuMp!";
				result += rs.getString("url") + "!PuMp!";
				result += Integer.toString(rs.getInt("ap")) + "!PuMp!";
				result += rs.getString("st") + "!PuMp!";
				
				// Get Value By SQL Result Set
				list.add(result);
				result= "";
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
		
		return list;
		
    	
    }

    public int countUserHadMission(String id){
    	
    	String read_db = "select count(*) count from missions m, mission_instances mi, missions_users mu  "
    					+ "where mu.user_id = "+ id  
    					+ " and mu.mission_instance_id = mi.id and mi.mission_id = m.id and goal = achievement_point";
    	
    	// Query String
    	int result =0;
    	
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
    
    public ArrayList<String> getUserHadMission(String id, int start, int end){

    	
    	String read_db = "select * from (select row_number() over (order by mi.id desc) as rownum, name, type, goal, "
    					+ "point, description desc, url, achievement_point ap, start_time st, end_time et " 
    					+ "from missions m, mission_instances mi, missions_users mu where mu.user_id = " + id  
    					+ "and mu.mission_instance_id = mi.id and mi.mission_id = m.id and goal = achievement_point) as a " 
    					+ " where a.rownum between " + start + " and  " + end;
    	
    	// Query String
    	ArrayList<String> list = new ArrayList<String>();
    	String result = "";
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeQuery();
			
		
				
			while(rs.next()){
				
				result += rs.getString("name") + "!PuMp!";
				result += Short.toString(rs.getShort("type")) + "!PuMp!";
				result += Integer.toString(rs.getInt("goal")) + "!PuMp!";
				result += Integer.toString(rs.getInt("point")) + "!PuMp!";
				result += rs.getString("desc") + "!PuMp!";
				result += rs.getString("url") + "!PuMp!";
				result += Integer.toString(rs.getInt("ap")) + "!PuMp!";
				result += rs.getString("st") + "!PuMp!";
				result += rs.getString("et") + "!PuMp!";
				result += Integer.toString(rs.getInt("rownum")) + "!PuMp!";
				
				
				// Get Value By SQL Result Set
				list.add(result);
				result= "";
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
		
		return list;
		
    	
    }
    
    public int countUserMission(String id){
    	
    	String read_db = "select count(*) count from missions_users where user_id = "+ id;  
    					
    	
    	// Query String
    	int result =0;
    	
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

    public ArrayList<String> getUserMission(String id, int start, int end){

    	
    	String read_db = "select * from (select row_number() over (order by mi.id desc) as rownum, name, type, goal, point, "
    					+ "description desc, url, achievement_point ap, start_time st, end_time et "
    					+ "from missions m, mission_instances mi, missions_users mu where mu.user_id = + id" 
    					+ " and mu.mission_instance_id = mi.id and mi.mission_id = m.id) as a " 
    					+ " where a.rownum between " + start + " and  " + end;
    	
    	// Query String
    	ArrayList<String> list = new ArrayList<String>();
    	String result = "";
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeQuery();
			
		
				
			while(rs.next()){
				
				result += rs.getString("name") + "!PuMp!";
				result += Short.toString(rs.getShort("type")) + "!PuMp!";
				result += Integer.toString(rs.getInt("goal")) + "!PuMp!";
				result += Integer.toString(rs.getInt("point")) + "!PuMp!";
				result += rs.getString("desc") + "!PuMp!";
				result += rs.getString("url") + "!PuMp!";
				result += Integer.toString(rs.getInt("ap")) + "!PuMp!";
				result += rs.getString("st") + "!PuMp!";
				result += rs.getString("et") + "!PuMp!";
				result += Integer.toString(rs.getInt("rownum")) + "!PuMp!";
				
				
				// Get Value By SQL Result Set
				list.add(result);
				result= "";
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
		
		return list;
		
    	
    }

    
    public ArrayList<String> getHavingMissionS(String id){
    	
    	String read_db = "select name, type from missions m, mission_instances mi, missions_users mu "
    					+ "where mu.user_id = "+ id 
    					+ " and mu.mission_instance_id = mi.id and mi.mission_id = m.id and goal > achievement_point";
    	
    	// Query String
    	ArrayList<String> list = new ArrayList<String>();
    	String result = "";
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeQuery();
			
		
				
			while(rs.next()){
				
				result += rs.getString("name") + "!PuMp!";
				result += Short.toString(rs.getShort("type")) + "!PuMp!";
				
				// Get Value By SQL Result Set
				list.add(result);
				result= "";
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
		
		return list;
		
    	
    }
    
    
    
    
    public int insertMission(String name, Short type, int goal, int point, String url, String  description){
    	
    	String read_db = "insert into missions(name, type, goal, point, url, description) values('" 
    					+ name + "', "+ type + ", " + goal + ", " + point + " , '" + url + "',  '"+ description + "')"; 
    	
    	// Query String
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	int rs = 0;
    	
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
    
    
    
   public int insertMissionInstance(String id){
    	
    	String read_db = "insert into mission_instances(mission_id) values(" 
    					+ id + ")";
    	
    	// Query String
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	int rs = 0;
    	
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
   
   public int insertMissionUser(String id, String instance_id, String article_id){
	   
   	String read_db = "insert into missions_users(user_id, mission_instance_id, article_id) values('" 
   					+ id + "', '"+ instance_id + "', '" + article_id + "')";
   	
   	// Query String
   	
   	Connection conn = null;
   	PreparedStatement pstmt = null;
   	int rs = 0;
   	
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
   
   public int updateMissionAP(int point, int mission_id){
	   
	   	String read_db = "update mission_instances set achievement_point = achievement_point + "
	   					+ point + " where id = "+ mission_id ;
	   	
	   	// Query String
	   	
	   	Connection conn = null;
	   	PreparedStatement pstmt = null;
	   	int rs = 0;
	   	
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
   
   public int updateMissionET(int mission_id){
	   
	   	String read_db = "update mission_instances set end_time = default where id = "+ mission_id;
	   	
	   	// Query String
	   	
	   	Connection conn = null;
	   	PreparedStatement pstmt = null;
	   	int rs = 0;
	   	
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
