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
 * Servlet implementation class MissionList
 */
@WebServlet("/MissionList")
public class MissionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/MissionBean",beanInterface=MissionBeanLocal.class)
	private MissionBeanLocal ejb3Session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MissionList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		short type = Short.parseShort(request.getParameter("type"));
		int start, end;
		start = Integer.parseInt(request.getParameter("start"));
		end = Integer.parseInt(request.getParameter("end"));
		
		ArrayList<String> list = ejb3Session.getMissionList(type, start, end);
		
		JSONArray json 	= new JSONArray();
		
		for(String users : list){
			
			String[] comment = users.split("!PuMp!");
			JSONObject j = new JSONObject();
			j.put("id",comment[0]);
			j.put("name", comment[1]);
			j.put("point", comment[2]);
			j.put("url", comment[3]);
			j.put("rownum", comment[4]);
			
			
			json.add(j);
			
			
			
			
			
			
			
			
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
