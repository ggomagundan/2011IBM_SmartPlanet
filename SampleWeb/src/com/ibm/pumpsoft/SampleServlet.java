package com.ibm.pumpsoft;


import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.ejb.SessionBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.pumpsoftejb.SessionBeanLocal;
import com.ibm.ws.security.bind.EJB3ApplicationBinding;
import com.tivoli.pd.jras.pdjlog.jlog.NestedException;


/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(name="ejb/SessionBean",beanInterface=SessionBeanLocal.class)
	private SessionBeanLocal ebj3Session;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("%adf");
		// Print Simple Text
		out.println("EJB call: " + ebj3Session.getString());
		// Print Simple Text using method
		out.println("count : " + ebj3Session.readDB());
		// Print SQL Result
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
