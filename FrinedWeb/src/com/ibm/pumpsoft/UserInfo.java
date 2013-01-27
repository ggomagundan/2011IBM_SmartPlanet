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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(name="ejb/FriendBean",beanInterface=FriendBeanLocal.class)
	private FriendBeanLocal ejb3Session;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
	
		
		String list = ejb3Session.getUserInfo(id);
		PrintWriter out = response.getWriter();
		
		
		//out.println(id + "'s Info");
		
		
		
		JSONArray json = new JSONArray();
		
		String[] userinfo = list.split("!PuMp!");
		JSONObject j = new JSONObject();
		j.put("id", userinfo[0]);
		j.put("nickname",userinfo[1]);
	
		json.add(j);
		
		//out.print("ID : " + userinfo[0]);
		//out.println("  Nick : " + userinfo[1]);
			
			
		//out.println("Json is : " + j.toString());
		
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