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

/**
 * Servlet implementation class InsertFriend
 */
@WebServlet("/InsertFriend")
public class InsertFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/FriendBean",beanInterface=FriendBeanLocal.class)
	private FriendBeanLocal ejb3Session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFriend() {
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
		String f_id = request.getParameter("f_id");
		
	
		
		JSONArray json = new JSONArray();
		JSONObject j = new JSONObject();
		int result = ejb3Session.insertFriend(id, f_id);
		if(id.equals(f_id)) result = 0;
		if(result == 1){
			j.put("result", true);
		}else{
			j.put("result", false);
		}
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
