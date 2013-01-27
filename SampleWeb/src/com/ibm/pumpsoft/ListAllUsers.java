package com.ibm.pumpsoft;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.pumpsoftejb.SessionBeanLocal;

/**
 * Servlet implementation class ListAllUsers
 */
@WebServlet("/ListAllUsers")
public class ListAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/SessionBean",beanInterface=SessionBeanLocal.class)
	private SessionBeanLocal ebj3Session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("User List");
		ArrayList<String> userList = ebj3Session.getUserList();
		
		
		
		
		for(String users : userList){
			
			String[] list = users.split("!PuMp!");
			out.println(users);
			out.print("ID : " + list[0]);
			out.print("  Nick : " + list[1]);
			out.print("  PASSWORD : " + list[2]);
			out.print("  POINT : " + list[3]);
			out.print("  GRADE : " + list[4]);
			out.println("  PLANT_DOANATION_COUNT : " + list[5]);
			
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
