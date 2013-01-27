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
 * Session Bean implementation class PlantBean
 */
@Stateless
@LocalBean
public class PlantBean implements PlantBeanLocal {
	
	@Resource(name="pump_Database",type=javax.sql.DataSource.class)
	private javax.sql.DataSource ds;

    /**
     * Default constructor. 
     */
    public PlantBean() {
        // TODO Auto-generated constructor stub
    }

    public int countPlant(){
    	
    	String read_db = "select count(*) count from items, plants where items.id = plants.id";
	
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
    
    public ArrayList<String> getPlantList(int start, int end){
    	
    	
    	
    	
    	String read_db = "select * from (select row_number() over (order by items.id desc) as rownum,  plants.id, name, "
    					+ "description desc, price, url, count, max_mature mm, step "
    					+ "from items, plants where items.id = plants.id) as a "
    					+ "where a.rownum between "+ start + " and  " + end;
    	
	
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
				result += rs.getString("desc") + "!PuMp!";
				result += Integer.toString(rs.getInt("price")) + "!PuMp!";
				result += rs.getString("url") + "!PuMp!";
				result += Integer.toString(rs.getInt("count")) + "!PuMp!";
				result += Integer.toString(rs.getInt("mm")) + "!PuMp!";
				result += Short.toString(rs.getShort("step")) + "!PuMp!";
				result += Integer.toString(rs.getInt("rownum")) + "!PuMp!";
				
				// Get Value By SQL Result Set
				list.add(result);
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
		
		return list;
    }
    
    public int countUsePlant(String id){
    	
    	String read_db = "select count(*) count from items, plants where items.id = plants.id"
    					+ " and user_id = " + id;
	
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
    
    public ArrayList<String> getUserPlantList(String id){
    	
    	
    	
    	
    	
    	String read_db = "select * from (select row_number() over (order by up.id desc) as rownum, name, " 
    					+ " description desc, url, max_mature mm, step, achievement_point ap, long, lat, plant_article pa "
    					+ " from items, plants, users_plants up where items.id = plants.id and plants.id = plant_id "
    					+ "and user_id = '"+ id + "') as a where a.rownum between 0 and 100";
    	
	
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
				result += rs.getString("desc") + "!PuMp!";
				result += rs.getString("url") + "!PuMp!";
				result += Integer.toString(rs.getInt("mm")) + "!PuMp!";
				result += Short.toString(rs.getShort("step")) + "!PuMp!";
				result += Integer.toString(rs.getInt("ap")) + "!PuMp!";
				result += Double.toString(rs.getDouble("lat")) + "!PuMp!";
				result += Double.toString(rs.getDouble("pa")) + "!PuMp!";
				
				// Get Value By SQL Result Set
				list.add(result);
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
		
		return list;
    }
    
    
 public ArrayList<String> getCurrentPlantList(String id){
    	
    	
	
    	
    	String read_db = "select * from (select row_number() over (order by up.id desc) as rownum, up.id, name, " 
    					+ "description desc, url, max_mature mm, step, achievement_point ap, long, lat, plant_article pa "
    					+ "from items, plants, users_plants up where items.id = plants.id and plants.id = plant_id "
    					+ " and user_id = '"+ id + "' and max_mature > achievement_point) as a where a.rownum "
    					+ "between 0 and 100";
    	
	
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
				
				
			
				
				
				result += Integer.toString(rs.getInt("id")) + "!PuMp!";
				result += rs.getString("name") + "!PuMp!";
				result += rs.getString("desc") + "!PuMp!";
				result += rs.getString("url") + "!PuMp!";
				result += Integer.toString(rs.getInt("mm")) + "!PuMp!";
				result += Short.toString(rs.getShort("step")) + "!PuMp!";
				result += Integer.toString(rs.getInt("ap")) + "!PuMp!";
				result += Double.toString(rs.getDouble("lat")) + "!PuMp!";
				result += Double.toString(rs.getDouble("long")) + "!PuMp!";
				result += Double.toString(rs.getDouble("pa")) + "!PuMp!";
				
				// Get Value By SQL Result Set
				list.add(result);
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
		
		return list;
    }
 
 
 
 public ArrayList<String> getPrePlantList(String id){
 	
	
 	
 	
 	String read_db = "select * from (select row_number() over (order by up.id desc) as rownum, name, " 
 					+ "description desc, url, max_mature mm, step, achievement_point ap, long, lat, plant_article pa "
 					+ "from items, plants, users_plants up where items.id = plants.id and plants.id = plant_id "
 					+ "and user_id = '"+ id + "' and max_mature <= achievement_point) as a where a.rownum "
 					+ "between 0 and 100";
 	
	
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
				result += rs.getString("desc") + "!PuMp!";
				result += rs.getString("url") + "!PuMp!";
				result += Integer.toString(rs.getInt("mm")) + "!PuMp!";
				result += Short.toString(rs.getShort("step")) + "!PuMp!";
				result += Integer.toString(rs.getInt("ap")) + "!PuMp!";
				result += Double.toString(rs.getDouble("lat")) + "!PuMp!";
				result += Double.toString(rs.getDouble("long")) + "!PuMp!";
				result += Double.toString(rs.getDouble("pa")) + "!PuMp!";
				
				// Get Value By SQL Result Set
				list.add(result);
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
		
		return list;
 }
 
    
  
    
    public int insertPlants(String name, String description, int price, String url, int count,  int max_mature, int step){
 	   
       	String read_db = "insert into items(name, description, price, url, count) values('" 
       					+ name + "', '"+ description + "', " + price +  ", '" + url + "', " + count  + ")";
       	
       
       	// Query String
       	
       	Connection conn = null;
       	PreparedStatement pstmt = null;
       	int rs = 0, rs1=0;
       	
       	try {
    			conn= ds.getConnection();
    			pstmt = conn.prepareStatement(read_db);
    			
    			rs = pstmt.executeUpdate();
    			
    			String read_id = "select id from items where name='" + name +"'";
    			pstmt = conn.prepareStatement(read_id);
    			
    			ResultSet rset = pstmt.executeQuery();
    			
    			//rset.next();
    			
    			
    			int item_id = rset.getInt("id");
    		       	
    		    String read_db_1 = "insert into plants(id, max_mature, step) values("
    		       					+ item_id + ", " + max_mature + ", " + step + ")";
    			
    			pstmt = conn.prepareStatement(read_db_1);
    			
    			rs1 = pstmt.executeUpdate();
    				
    			
    		
    			
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
    		
    		return rs + rs1;
    		
       	
       }
    
    
    public int insertPlantUser(String id,int plant_id,String plant_article){
  	   
       	String read_db = "insert into users_plants(user_id, plant_id, plant_article) values('" 
       					+ id + "', "+ plant_id + ", '" + plant_article + "')";
       	
       	
    
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

    
    public int updateUserPlant(String id){
   	   
       	String read_db = "update users set plant_donation_count = plant_donation_count + 1 where id = '" +id  + "'";
       	
       	
    
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
    
    public int PlantUserTree(int id, double long_value, double lat_value, String article){
    	   
       	String read_db = "update users_plants set long = "+long_value+", lat = "+lat_value
       					+ ", plant_article = '"+ article +"' where id = " + id;
       	
       	
    
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
