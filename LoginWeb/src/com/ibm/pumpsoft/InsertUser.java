package com.ibm.pumpsoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.ibm.pumpsoftejb.LoginBeanLocal;

/**
 * Servlet implementation class InserUser
 */
@WebServlet("/InserUser")
public class InsertUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(name="ejb/LoginBean",beanInterface=LoginBeanLocal.class)
	private LoginBeanLocal ejb3Session;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUser() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String nick = request.getParameter("nickname");
		String passwd = request.getParameter("passwd");
		int result = ejb3Session.insertUser(id, nick, passwd);
		JSONArray json = new JSONArray();
		JSONObject j  = new JSONObject();
		j.put("result",result);
		json.add(j);
		JSONObject js =  new JSONObject();
		
		js.put("data", json);
		
		out.println(js);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}