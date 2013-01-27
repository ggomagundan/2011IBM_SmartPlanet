package com.ibm.pumpsoft;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		
		PrintWriter out = response.getWriter();
		//out.println(im);//+ request.toString());
		
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
		   // �ѱ� ���ϸ� ���ε� �����ϴ� : euc-kr
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
		
	}

}
