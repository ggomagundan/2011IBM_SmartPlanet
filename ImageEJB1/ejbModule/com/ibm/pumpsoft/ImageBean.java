package com.ibm.pumpsoft;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ImageBean
 */
@Stateless
@LocalBean
public class ImageBean implements ImageBeanLocal {

    /**
     * Default constructor. 
     */
	
	@Resource(name="pump_Database",type=javax.sql.DataSource.class)
	private javax.sql.DataSource ds;
	
    public ImageBean() {
        // TODO Auto-generated constructor stub
    }
    
    public int UploadImg(int article_id){
    	
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
    	try {
			conn= ds.getConnection();
		} catch (SQLException e) {
			// TODO �ڵ� ������ catch ���
			e.printStackTrace();
		}
    	
    	 blobFileUse(conn, article_id);
    	return 0;
    }
    
    static void blobFileUse(Connection con, int article_id)
    {
      try
      {
      	
      	String photoFormat;
      	
      	//article_id = 0;	//������ �߰��� article ID 

  	    PreparedStatement pstmt = con.prepareStatement(
  	    		"insert into photos(article_id) values(" + article_id + ")");
  	    pstmt.executeQuery();
  	    
  	    pstmt = con.prepareStatement(
  	    		"select id, photo from photos order by id desc fetch first 1 rows only");
  	    ResultSet rs = pstmt.executeQuery();
  	    rs.next();
  	    int id = rs.getInt("id");
  	    Blob photo = rs.getBlob("photo");
  	    
  	    photo.setBinaryStream(0);
  	    // photo�� �̹��� �ø���������ؼ� ����
  	    
  	    pstmt = con.prepareStatement(
  	    		"update photos set photo = " + photo +" where id = " + id);

  	    pstmt.setBlob(1, photo);
  	    pstmt.executeUpdate();
  	    
  	    rs.close();
  	    pstmt.close();

      }
      catch (Exception e)
      {
//        JdbcException jdbcExc = new JdbcException(e);
//        jdbcExc.handle();
      }
    } // blobFileUse

}
