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
 * Servlet implementation class CurrentUserPlant
 */
@WebServlet("/CurrentUserPlant")
public class CurrentUserPlant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/PlantBean",beanInterface=PlantBeanLocal.class)
	private PlantBeanLocal ejb3ssesion;  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentUserPlant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		


		String id;
		id = request.getParameter("id");
		
		
		ArrayList<String> list = ejb3ssesion.getCurrentPlantList(id);
		
		JSONArray json 	= new JSONArray();
		
		for(String users : list){
			
			String[] comment = users.split("!PuMp!");
			JSONObject j = new JSONObject();
			j.put("id", comment[0]);
			j.put("name", comment[1]);
			j.put("desc", comment[2]);
			j.put("url", comment[3]);
			j.put("mm", comment[4]);
			j.put("step", comment[5]);
			j.put("ap", comment[6]);
			j.put("lat", comment[7]);
			j.put("long", comment[8]);
			j.put("pa", comment[9]);
			
			
			json.add(j);
			
			
//			out.print("name : " + comment[0]);
//			out.print("    desc : " + comment[1]);
//			out.print("    price : " + comment[2]);
//			out.println("    url : " + comment[3]);
//			out.println("    count : " + comment[4]);
//			out.println("    mm : " + comment[5]);
//			out.println("    step : " + comment[6]);
//			out.println("    rownum : " + comment[7]);
		
			
			
			
			
			
			
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
