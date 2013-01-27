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

import net.sf.json.*;

/**
 * Servlet implementation class FriendsList
 */
@WebServlet("/FriendsList")
public class FriendsList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(name="ejb/FriendBean",beanInterface=FriendBeanLocal.class)
	private FriendBeanLocal ejb3Session;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public FriendsList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		int start, end;
		start = Integer.parseInt(request.getParameter("start"));
		end = Integer.parseInt(request.getParameter("end"));
		
		ArrayList<String> list = ejb3Session.getFriendsList(id, start, end);
		PrintWriter out = response.getWriter();
		
		
		//out.println(id + "'s Friends List");
		JSONArray json = new JSONArray();
		
		for(String users : list){
			
			String[] friendinfo = users.split("!PuMp!");
			JSONObject j = new JSONObject();
			j.put("id", friendinfo[0]);
			j.put("nickname",friendinfo[1]);
			j.put("point",friendinfo[2]);
			j.put("pdc", friendinfo[3]);
			j.put("rownum", friendinfo[4]);
			json.add(j);
			
			
//			out.print("ID : " + friendinfo[0]);
//			out.print("  Nick : " + friendinfo[1]);
//			out.print("  Point : " + friendinfo[2]);
//			out.print("  PDC : " + friendinfo[3]);
//			out.println("  RowNum : " + friendinfo[4]);
//			
			
			
		}
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
