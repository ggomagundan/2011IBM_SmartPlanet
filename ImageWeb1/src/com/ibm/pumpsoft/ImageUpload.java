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
		   //톰캣 플러그인을 사용하는 경우
		   String savePath = getServletContext().getRealPath("upfolder");
		   */

		  // Dynamic Web Project 의 경우 : 절대 경로를 쓴다.
		  String savePath = "/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/installedApps/zvv172016000043Node01Cell/ImageEAR.ear/ImageWeb.war";
		  // out.println("savePath=" + savePath);//경로 확인

		  int maxSize = 5 * 1024 * 1024; // 최대 업로드 파일 크기 5MB(메가)로 제한
		  try {
		   // 한글 파일명도 업로드 가능하다 : euc-kr
		   // 하지만 실제로는 한글 파일명은 처리가 불편하기 때문에 영문 파일을 쓴다.
		   MultipartRequest multi = new MultipartRequest(request, savePath,
		     maxSize, "euc-kr", new DefaultFileRenamePolicy());
		   out.println("<html>");
		   out.println("<head><title>File Upload List</title></head>");
		   out.println("<body>");
		   out.println("<pre>");

		   Enumeration params = multi.getParameterNames(); // 파라미터명 얻기

		   // 반복문으로 모두 출력하기, 현 예제에는 하나지만 나중에 여러개일 경우을 위해 준비

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

		 

		   Enumeration files = multi.getFileNames(); // 파일명 모두 얻기

		   // 반복문으로 모두 출력, 역시 여러 파일 업로드 경우를 위해 준비

		   while (files.hasMoreElements()) {
		    String name = (String) files.nextElement();
		    String fileName = multi.getFilesystemName(name); // 실제 업로드된 파일명
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

		   File dirFile = new File(savePath); // 업로드 폴더 얻기
		   File[] fileList = dirFile.listFiles();  // 현재 폴더의 모든 파일 리스트 얻기

		   // 반복문으로 다운로드 링크 걸어주기
		   for (int i = 0; i < fileList.length; i++) {
		    String fName = fileList[i].getName();
		    out.println("<a href='/Image/ImageDownload?file="
		      + fName + "'>" + fName + "</a><br>");
		   }// for
		   out.println("<pre>");
		  } catch (Exception e) {
		   out.print("예외 발생 : " + e);
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
    	
    	article_id = 0;	//사진을 추가할 article ID 

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
	    // photo에 이미지 시리얼라이즈해서 저장
	    
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
