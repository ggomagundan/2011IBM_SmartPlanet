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
 * Servlet implementation class HavingMissionCount
 */
@WebServlet("/HavingMissionCount")
public class HavingMissionCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/MissionBean",beanInterface=MissionBeanLocal.class)
	private MissionBeanLocal ejb3Session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HavingMissionCount() {
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
		
		int count = ejb3Session.countUserHavingMission(id);
		
		
		JSONArray json = new JSONArray();
		JSONObject j = new JSONObject();
		
		j.put("count", count);
		json.add(j);
		JSONObject js =  new JSONObject();
		
		js.put("data", json);
		
		out.println(js);
		
		//out.println(id + " have " + count + " missions");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}