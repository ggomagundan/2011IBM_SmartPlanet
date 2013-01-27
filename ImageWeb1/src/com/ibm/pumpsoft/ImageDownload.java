package com.ibm.pumpsoft;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageDownload
 */
@WebServlet("/ImageDownload")
public class ImageDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 /*
		  // 톰캣 플러그인을 사용하는 경우
		  String dir = getServletContext().getRealPath("WebContent/upfolder");
		  */
		  
		  String dir = "/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/installedApps/zvv172016000043Node01Cell/ImageEAR.ear/ImageWeb.war";
		  response.setContentType("euc-kr");
		  String filename = request.getParameter("file");
		  response.setContentType("application/octet;charset=euc-kr");

		  response.setHeader("Content-Disposition", "attachment;filename=" + filename);

		 

		  // 자바 I/O 를 이용하여 다운로드해 준다.
		  byte[] buffer = new byte[1024];
		  ServletOutputStream out = response.getOutputStream();
		  BufferedInputStream in = null;

		  try {
		   in = new BufferedInputStream(new FileInputStream(dir + "\\"
		     + filename));
		   int n = 0;
		   while ((n = in.read(buffer, 0, 1024)) != -1) {
		    out.write(buffer, 0, n);
		   }//while
		  } catch (Exception e) {
		   out.println("다운로드 예외 발생 : " + e);
		   e.printStackTrace();
		  } finally {
		    if (in != null) try { in.close(); } catch(Exception e) { }
		    if (out != null) try { out.close(); } catch(Exception e) { }
		  }// finally
	 }// service
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
