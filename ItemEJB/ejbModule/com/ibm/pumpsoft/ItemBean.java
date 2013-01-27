package com.ibm.pumpsoft;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ibm.disthub2.impl.matching.SchemaTarget.Results;

/**
 * Session Bean implementation class ItemBean
 */
@Stateless
@LocalBean
public class ItemBean implements ItemBeanLocal {
	
	@Resource(name="pump_Database",type=javax.sql.DataSource.class)
	private javax.sql.DataSource ds;

    /**
     * Default constructor. 
     */
    public ItemBean() {
        // TODO Auto-generated constructor stub
    }

    public String getLatelyItem(){
    	
    	
      	String read_db = "select id from items order by id desc fetch first 1 rows only";

		// Query String
		String result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
		
			rs = pstmt.executeQuery();
				
			while(rs.next()){
		
				result = Integer.toString(rs.getInt("id"));
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
    
    public int countItem(){
    	
    	
      	String read_db = "select count(*) count from items, plants where items.id <> plants.id";

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
    
    public ArrayList<String> getItemList(int start, int end){
    	
    	
    	
    	
    	    	
    	String read_db = "select * from (select row_number() over (order by items.id desc) as rownum, items.id, name, " 
    					+ "description desc, price, effect, url, count from items, plants where items.id <> plants.id) as a " 
    					+ " where a.rownum "
    					+ " between " + start + " and " + end;
    	
    	
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
				result += Integer.toString(rs.getInt("effect")) + "!PuMp!";
				result += Integer.toString(rs.getInt("price")) + "!PuMp!";
				result += rs.getString("url") + "!PuMp!";
				result += Integer.toString(rs.getInt("count")) + "!PuMp!";
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
    
    public int countUserItem(String id){
    	
    	
      	String read_db = "select count(*) count from inventories inv, items, plants " 
      					+ "where inv.item_id = items.id and inv.user_id = " + id
      					+ "and items.id <> plants.id";

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
    
    
    
    public ArrayList<String> getUserInventory(String id, int start, int end){
    	
    	   	
    	
    	String read_db = "select * from (select row_number() over (order by item_id desc) as rownum, items.id, name, item_count count, "
    					+ "description desc, effect, url from inventories inv, items, plants "
    					+ "where inv.item_id = items.id and inv.user_id = '"+  id
    					+ "' and items.id <> plants.id) as a " 
    					+ " where a.rownum "
    					+ " between " + start + " and " + end;
    	
    	
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
				result += Integer.toString(rs.getInt("count")) + "!PuMp!";
				result += rs.getString("desc") + "!PuMp!";
				result += Integer.toString(rs.getInt("effect")) + "!PuMp!";
				result += rs.getString("url") + "!PuMp!";
			
				
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
    
    public int insertItem(String name, String description, int price, String url, int count){
 	   
       	String read_db = "insert into items(name, description, price, url, count) values('" 
       					+ name + "', '"+ description + "', " + price + ", '"+url + "', "+count+")";
       	
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
    
    
    public int insertItemUser(String id, int plant_id){
  	   
       	String read_db = "insert into inventories(user_id, item_id) values('" 
       					+ id + "', "+ plant_id +", 1)";
       	
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
    
    
    public int buyItem(int count,int item_id, String user_id){
   	   
    	
    	String iOrP = "select count(*) count from items, plants where items.id = plants.id and items.id = "+ item_id;
    	
    	
    	
    	
    	String userCount = "select count(*) count from users_plants, plants where plant_id = plants.id " 
    					+ "and user_id = '" + user_id + "' and max_mature > achievement_point";
    	
    	
       	String read_db = "update items set count = count - "+ count + " where id = "+item_id;
       	
       	String read_db1 = "update inventories set item_count = item_count + "+count 
       					+ " where user_id = '"+user_id+"' and item_id = "+ item_id;
       	
       	String read_db2 = "select point from users " 
				+ "where id = '" 
				+ user_id +"'";
       	
       	String read_db3 = "select price from items where id = " + item_id;
       	
       	ResultSet rset;
       	
       	// Query String
       	
       	Connection conn = null;
       	PreparedStatement pstmt = null;
       	int rs = 0, rs1 =0;
       	int point = 0, item_point = 0;
       	
       	try {
    			conn= ds.getConnection();
    			
    			pstmt = conn.prepareStatement(iOrP);
    			rset = pstmt.executeQuery();
    			int ip = 0;
    			
    			while(rset.next()){
    			
    				ip = rset.getInt("count");
    				// Get Value By SQL Result Set
    				
    			}
    			
    			if(ip ==0){
    				
    				
    				
    				rset = pstmt.executeQuery();
        			int userplant = 0;
        			
        			while(rset.next()){
        			
        				userplant = rset.getInt("count");
        				// Get Value By SQL Result Set
        				
        			}
        			
        			if( userplant ==0){
	        			String inPlnat = "insert into users_plants(user_id, plant_id, plant_article) values('"
	        							+ user_id + "', "+ item_id + ", '')";
	        			
	        			pstmt = conn.prepareStatement(inPlnat);
	        			rs = pstmt.executeUpdate();
	        			
	        			
	        			pstmt = conn.prepareStatement(read_db3);
	        			rset = pstmt.executeQuery();
	        			   			
	        			
	        			while(rset.next()){
	        			
	        				item_point = rset.getInt("price");
	        				// Get Value By SQL Result Set
	        				
	        			}
	        			
	        			if(point < item_point)
	        				return 0;
	        			
	        			
	        			String read_db4 = "update users set point = point - "+ item_point + " where id = '"+user_id + "'";
	        			
	        			pstmt = conn.prepareStatement(read_db4);
	        			
	        			rs1 = pstmt.executeUpdate();
	        			
	        			pstmt = conn.prepareStatement(read_db);
	        			rs = pstmt.executeUpdate();

        			}else{
        				return 0;
        			}
        			
    			}else{
    				pstmt = conn.prepareStatement(read_db2);
        			
        			rset = pstmt.executeQuery();
        			   			
        			
        			while(rset.next()){
        			
        				point = rset.getInt("point");
        				// Get Value By SQL Result Set
        				
        			}
        			
        			pstmt = conn.prepareStatement(read_db3);
        			rset = pstmt.executeQuery();
        			   			
        			
        			while(rset.next()){
        			
        				item_point = rset.getInt("price");
        				// Get Value By SQL Result Set
        				
        			}
        			
        			if(point < item_point)
        				return 0;
        			
        			
        			String read_db4 = "update users set point = point - "+ item_point + " where id = '"+user_id + "'";
        			
        			pstmt = conn.prepareStatement(read_db);
        			rs = pstmt.executeUpdate();
        			
        			pstmt = conn.prepareStatement(read_db1);
        			
        			rs1 = pstmt.executeUpdate();
        		
        				
        			pstmt = conn.prepareStatement(read_db4);
        			
        			rs1 = pstmt.executeUpdate();
        		
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
    		
    		return rs;
    		
       	
       }
    
    public int useItem(int count,String user_id, int item_id, int point,  int user_plant_id){
    	   
       	String read_db = "update inventories set item_count = item_count - "+count 
       					+ " where user_id = '" + user_id + "' and item_id = "+item_id;
       	String read_db1 = "update users_plants set achievement_point = achievement_point + " + point 
       					+ " where id = "+ user_plant_id;
       	// Query String
       	
       	Connection conn = null;
       	PreparedStatement pstmt = null;
       	int rs = 0, rs1 =0;
       	
       	try {
    			conn= ds.getConnection();
    			pstmt = conn.prepareStatement(read_db);
    			
    			rs = pstmt.executeUpdate();
    			
    			pstmt = conn.prepareStatement(read_db1);
    			
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
    		
    		return rs1*rs;
    		
       	
       }
}
