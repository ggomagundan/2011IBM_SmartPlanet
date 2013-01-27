package com.ibm.pumpsoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.json.java.JSONObject;

/**
 * Servlet implementation class JsonGetting
 */
@WebServlet("/JsonGetting")
public class JsonGetting extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String str=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonGetting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		if(request != null)
			str += "header" + request.getParameter("header") + "\n id :  " 
				+ request.getParameter("id") + request.toString() + "\n"
				+  request.getParameter("one");
				
				
		 

		 
			
		out.println(str);
	}

	/**
	 * @see HttpServlst#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		if(request != null)
			str = request.toString();
		out.println(str);
	}

}
