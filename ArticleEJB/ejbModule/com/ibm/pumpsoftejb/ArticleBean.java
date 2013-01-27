package com.ibm.pumpsoftejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ibm.ObjectQuery.crud.util.Array;

/**
 * Session Bean implementation class ArticleEJB
 */
@Stateless
@LocalBean
public class ArticleBean implements ArticleBeanLocal {

	
	@Resource(name="pump_Database",type=javax.sql.DataSource.class)
	private javax.sql.DataSource ds;
	
    /**
     * Default constructor. 
     */
    public ArticleBean() {
        // TODO Auto-generated constructor stub
    }
    
    public int countArticles(){
    	
    	String read_db = "select count(*) count from articles";

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
    
    public String get(int start, int end){
    	return "select * from (select row_number() over (order by articles.id desc) as rownum, articles.id article_id, "
		+ "users.id, nickname, title, time, recommend_count rc, opposition_count oc, m.type, m.name from users, articles "
		+ "left outer join missions_users mu on articles.id = article_id full outer join mission_instances "
		+ "mi on mission_instance_id = mi.id full outer join missions m on mission_id = m.id "
		+ "where articles.user_id = users.id) as a where a.rownum "
		+ "between " + start + " and " + end; 
    }
    
    public ArrayList<String> getArticleList(int start, int end){
    	
    	
    	
    	String read_db = "select * from (select row_number() over (order by articles.id desc) as rownum, articles.id article_id, "
    					+ "users.id, nickname, title, time, recommend_count rc, opposition_count oc, m.type, m.name from users, articles "
    					+ "left outer join missions_users mu on articles.id = article_id full outer join mission_instances "
    					+ "mi on mission_instance_id = mi.id full outer join missions m on mission_id = m.id "
    					+ "where articles.user_id = users.id) as a where a.rownum "
    					+ "between " + start + " and " + end; 
    					
    					
		// Query String
		String result = "";
		
		ArrayList<String> list = new ArrayList<String>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeQuery();
		
		
			
			
			while(rs.next()){
			
				result += Integer.toString(rs.getInt("article_id")) +   "!PuMp!";
				result += rs.getString("id")  + "!PuMp!";
				result += rs.getString("nickname")  + "!PuMp!";
				result += rs.getString("title")  + "!PuMp!";
				result += rs.getString("time") + "!PuMp!";
				result += Integer.toString(rs.getInt("rc")) + "!PuMp!";
				result += Integer.toString(rs.getInt("oc")) + "!PuMp!";
				result += Short.toString(rs.getShort("type")) + "!PuMp!";
				result += rs.getString("name") + "!PuMp!";
				result += Integer.toString(rs.getInt("rownum")) + "!PuMp!";
				
			
				
			
				
				
				
				
				
				list.add(result);
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
		
		return list;

    	
    	
    }
    
    
    
    
    public String getArticleContent(int id){
    	
    	String read_db = "select article from articles " 
    					+ "where id = " 
    					+ id;

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
			
				result = rs.getString("article");
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
    
    
 public ArrayList<String> getArticlePhoto(int id){
    	
    	String read_db = "select url from photos where article_id = " 
    					+ id;

		// Query String
		String result = "";
		
		ArrayList<String> list = new ArrayList<String>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeQuery();
		
		
		
			while(rs.next()){
			
				result += rs.getString("url") +   "!PuMp!";
			
				
				list.add(result);
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
		
		return list;

    	
    	
    }
    
 
 
 public ArrayList<String> getArticleComments(int id){
 	
 	String read_db = "select user_id, comment, time from comments where article_id = " 
 					+ id;

		// Query String
		String result = "";
		
		ArrayList<String> list = new ArrayList<String>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeQuery();
		
		
		
			while(rs.next()){
			
				result += rs.getString("user_id") +   "!PuMp!";
				result += rs.getString("comment") +   "!PuMp!";
				result += rs.getString("time") +   "!PuMp!";
			
				
				list.add(result);
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
		
		return list;

 	
 	
 	}
 
 
 public int insertArticle(String id, String title, String article, String pic_name){
	 
 	String read_db = " insert into articles(user_id, title, article) values('" 
 					+ id + "', '"+ title + "', '" + article + "')";
 	
 	// Query String
 	
 	Connection conn = null;
 	PreparedStatement pstmt = null;
 	int rs = 0;
 	
 	try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(read_db);
			
			rs = pstmt.executeUpdate();
			
			String sql = "select id from articles order by id desc fetch first 1 rows only";
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
			int article_id = 0;
			
			while(rset.next()){
				article_id = rset.getInt("id");
			}
			if(!(pic_name.isEmpty()))
				insertPhoto(Integer.toString(article_id), pic_name);
			
				
			
		
			
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
 
 
 public int insertComment(String article_id, String user_id, String comment){
	 
	 	String read_db = " insert into articles(user_id, title, article) values('" 
	 					+ article_id + "', '"+ user_id + "', '" + comment + "')";
	 	
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
 
 	public int insertPhoto(String article_id , String url){
	 
	 	String read_db = " insert into photos(article_id, url) values(" 
	 					+ article_id + ", '"+ url + "')";
	 	
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
 	
 	
 	public int updateArticle(String title, String article, int article_id){
 		 
	 	String read_db = " update articles set title = '"+title + "', article = '" + article 
	 					+ "', time = default where id = "+ article_id + "";
	 	
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
 	
 	public int updateComment(String comment, int comment_id){
		 
	 	String read_db = "update comments set comment = '"+comment + "', time = default where id = " 
	 					+ comment_id ;
	 	
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
 	
 	
 	
	public int updateRCO_Or_OC(int article_id, String user_id, int isRCOrOC){
		String read_db, read_db1;
		if(isRCOrOC == 0){
			
			read_db = "update articles set recommend_count = recommend_count + 1 where id = " +  article_id ;
			read_db1 = "update users set point = point + 10  where id = '" + user_id + "'";
			
	 					
		}else {
			
			read_db = "update articles set opposition_count = opposition_count + 1 where id = " + article_id ;
			read_db1 = "update users set point = point - 5 where id = '" + user_id + "'";
						
		}
	 	
	 	// Query String
	 	
	 	Connection conn = null;
	 	PreparedStatement pstmt = null;
	 	int rs = 0, rs1 = 0,  rs2 =0;
	 	
	 	try {
				conn= ds.getConnection();
				
				String sql = "select count(*) count from evaluations where user_id = '" + user_id +  "' and article_id = " + article_id;
				pstmt = conn.prepareStatement(sql);
				
				ResultSet rss = pstmt.executeQuery();
				
				int result=0;
				
				while(rss.next()){
				
					result = rss.getInt("count");
					// Get Value By SQL Result Set
					
				}
				
				if(result >= 1){
					return 0;
				}
				
				pstmt = conn.prepareStatement(read_db);
				
				rs = pstmt.executeUpdate();
				
				pstmt = conn.prepareStatement(read_db1);
				
				rs1 = pstmt.executeUpdate();
			
				sql = "insert into evaluations(user_id, article_id) values('"+user_id+"', "+article_id + " )";
				
				pstmt = conn.prepareStatement(sql);
				rs2 = pstmt.executeUpdate();
				
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
			
			return rs&rs1&rs2;
			
	 	
	 }

}
