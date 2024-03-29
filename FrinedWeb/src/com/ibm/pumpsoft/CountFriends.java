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

import com.ibm.ws.security.bind.EJB3ApplicationBinding;



/**
 * Servlet implementation class CountFriends
 */
@WebServlet("/CountFriends")
public class CountFriends extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB(name="ejb/FriendBean",beanInterface=FriendBeanLocal.class)
	private FriendBeanLocal ejb3Session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountFriends() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		int count = ejb3Session.getCountFriends(id);

		JSONArray json = new JSONArray();
		JSONObject j = new JSONObject();
		j.put("count", count);
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
