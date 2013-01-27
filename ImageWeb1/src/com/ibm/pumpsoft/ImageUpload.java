package com.ibm.pumpsoft;

import java.util.Enumeration;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ImageUpload
 */
@WebServlet("/ImageUpload")
public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

    
  
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    static String im="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		im+= "get";
		out.println(im);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		im+= "post";
		
		PrintWriter out = response.getWriter();
		out.println(im);//+ request.toString());
		
		 response.setContentType("text/html;charset=euc-kr");
		 
		  request.setCharacterEncoding("euc-kr");
		  /*
		   //��Ĺ �÷������� ����ϴ� ���
		   String savePath = getServletContext().getRealPath("upfolder");
		   */

		  // Dynamic Web Project �� ��� : ���� ��θ� ����.
		  String savePath = "/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/installedApps/zvv172016000043Node01Cell/ImageEAR.ear/ImageWeb.war";
		  // out.println("savePath=" + savePath);//��� Ȯ��

		  int maxSize = 5 * 1024 * 1024; // �ִ� ���ε� ���� ũ�� 5MB(�ް�)�� ����
		  try {
		   // �ѱ� ���ϸ��� ���ε� �����ϴ� : euc-kr
		   // ������ �����δ� �ѱ� ���ϸ��� ó���� �����ϱ� ������ ���� ������ ����.
		   MultipartRequest multi = new MultipartRequest(request, savePath,
		     maxSize, "euc-kr", new DefaultFileRenamePolicy());
		   out.println("<html>");
		   out.println("<head><title>File Upload List</title></head>");
		   out.println("<body>");
		   out.println("<pre>");

		   Enumeration params = multi.getParameterNames(); // �Ķ���͸� ���

		   // �ݺ������� ��� ����ϱ�, �� �������� �ϳ����� ���߿� �������� ����� ���� �غ�

		   while (params.hasMoreElements()) {
		    String name = (String) params.nextElement();
		    String value = multi.getParameter(name);
		    out.println(name + " : " + value);
		   }//while
		   out.println("</pre>");

		   out.println("<h3>Desc</h3>");
		   out.println("<pre>");
		   out.println("<table border=1>");
		   out.println("<tr>");
		   out.println("<td width=150>File Name</td>");
		   out.println("<td width=100>File Size</td>");
		   out.println("<td width=150>File Format</td>");
		   out.println("<td width=150>parameter</td>");
		   out.println("</tr>");

		 

		   Enumeration files = multi.getFileNames(); // ���ϸ� ��� ���

		   // �ݺ������� ��� ���, ���� ���� ���� ���ε� ��츦 ���� �غ�

		   while (files.hasMoreElements()) {
		    String name = (String) files.nextElement();
		    String fileName = multi.getFilesystemName(name); // ���� ���ε�� ���ϸ�
		    String type = multi.getContentType(name);
		    File f = multi.getFile(name);
		    out.println("<tr>");
		    out.println("<td>" + fileName + "</td>");
		    if (f != null) {
		     out.println("<td>" + f.length() + "</td>");
		    }// if
		    out.println("<td>" + type + "</td>");
		    out.println("<td>" + name + "</td></tr>");
		   }// while

		   out.println("</table>");
		   out.println("</pre>");

		   out.println("<h3>UploadFile List</h3>");
		   out.println("<pre>");

		   File dirFile = new File(savePath); // ���ε� ���� ���
		   File[] fileList = dirFile.listFiles();  // ���� ������ ��� ���� ����Ʈ ���

		   // �ݺ������� �ٿ�ε� ��ũ �ɾ��ֱ�
		   for (int i = 0; i < fileList.length; i++) {
		    String fName = fileList[i].getName();
		    out.println("<a href='/Image/ImageDownload?file="
		      + fName + "'>" + fName + "</a><br>");
		   }// for
		   out.println("<pre>");
		  } catch (Exception e) {
		   out.print("���� �߻� : " + e);
		  }// catch
		
//		out.println("user => " +  request.getParameter("user"));
//		out.println("pass => " + request.getParameter("pass"));
		
//	    response.setContentType("text/plain");
//	    out.println("<h1>Servlet File Upload Example using Commons File Upload</h1>");
//	    out.println();
// 
//		DiskFileItemFactory  fileItemFactory = new DiskFileItemFactory ();
//		/*
//		 *Set the size threshold, above which content will be stored on disk.
//		 */
//		fileItemFactory.setSizeThreshold(1*1024*1024); //1 MB
//		/*
//		 * Set the temporary directory to store the uploaded files of size above threshold.
//		 */
//		fileItemFactory.setRepository(tmpDir);
// 
//		ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
//		try {
//			/*
//			 * Parse the request
//			 */
//			List items = uploadHandler.parseRequest(request);
//			Iterator itr = items.iterator();
//			while(itr.hasNext()) {
//				FileItem item = (FileItem) itr.next();
//				/*
//				 * Handle Form Fields.
//				 */
//				if(item.isFormField()) {
//					out.println("File Name = "+item.getFieldName()+", Value = "+item.getString());
//				} else {
//					//Handle Uploaded files.
//					out.println("Field Name = "+item.getFieldName()+
//						", File Name = "+item.getName()+
//						", Content type = "+item.getContentType()+
//						", File Size = "+item.getSize());
//					/*
//					 * Write file to the ultimate location.
//					 */
//					File file = new File(destinationDir,item.getName());
//					item.write(file);
//				}
//				out.close();
//			}
//		}catch(FileUploadException ex) {
//			log("Error encountered while parsing the request",ex);
//		} catch(Exception ex) {
//			log("Error encountered while uploading file",ex);
//		}
// 
		
	}

}


/*

import java.io.*;
import java.lang.*;
import java.util.*;
import java.sql.*;

class DtLob
{
  public static void main(String argv[])
  {
    try
    {
      Db db = new Db(argv);

      // connect to the 'sample' database
      db.connect();

      blobFileUse(db.con);
   

      // disconnect from the 'sample' database
      db.disconnect();
    }
    catch (Exception e)
    {
      JdbcException jdbcExc = new JdbcException(e);
      jdbcExc.handle();
    }
  } // main

  static void blobFileUse(Connection con)
  {
    try
    {
    	int article_id;
    	String photoFormat;
    	
    	article_id = 0;	//������ �߰��� article ID 

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
	    		"update photos set photo = ? where id = " + id);

	    pstmt.setBlob(1, photo);
	    pstmt.executeUpdate();
	    
	    rs.close();
	    pstmt.close();

    }
    catch (Exception e)
    {
      JdbcException jdbcExc = new JdbcException(e);
      jdbcExc.handle();
    }
  } // blobFileUse
}
*/