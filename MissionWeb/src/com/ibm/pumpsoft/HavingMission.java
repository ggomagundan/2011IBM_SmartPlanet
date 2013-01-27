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
 * Servlet implementation class HavingUserMission
 */
@WebServlet("/HavingUserMission")
public class HavingMission extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/MissionBean",beanInterface=MissionBeanLocal.class)
	private MissionBeanLocal ejb3Session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HavingMission() {
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
		
		ArrayList<String> list = ejb3Session.getUserHavingMission(id);
		
	
		
		JSONArray json = new JSONArray();
		
		for(String users : list){
			
			String[] comment = users.split("!PuMp!");
			JSONObject j = new JSONObject();
			j.put("name", comment[0]);
			j.put("type", comment[1]);
			j.put("goal", comment[2]);
			j.put("point", comment[3]);
			j.put("desc", comment[4]);
			j.put("url", comment[5]);
			j.put("ap", comment[6]);
			j.put("st", comment[7]);
		
			//j.put("rownum", comment[9]);
			
			
			json.add(j);
			
			
//			out.print("name : " + comment[0]);
//			out.print("    type : " + comment[1]);
//			out.print("    goal : " + comment[2]);
//			out.print("    point : " + comment[3]);
//			out.print("    desc : " + comment[4]);
//			out.print("    url : " + comment[5]);
//			out.print("    ap : " + comment[6]);
//			out.println("    st : " + comment[7]);
			
			//out.println("    rownum : " + comment[9]);
			
			
			
			
			
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
