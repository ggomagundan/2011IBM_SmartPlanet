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
 * Servlet implementation class PlantList
 */
@WebServlet("/PlantList")
public class PlantList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/PlantBean",beanInterface=PlantBeanLocal.class)
	private PlantBeanLocal ejb3ssesion;  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlantList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		


		int start, end;
		start = Integer.parseInt(request.getParameter("start"));
		end = Integer.parseInt(request.getParameter("end"));
		
		ArrayList<String> list = ejb3ssesion.getPlantList(start, end);
		
		JSONArray json 	= new JSONArray();
		
		for(String users : list){
			
			String[] comment = users.split("!PuMp!");
			JSONObject j = new JSONObject();
			j.put("id", comment[0]);
			j.put("name", comment[1]);
			j.put("desc", comment[2]);
			j.put("price", comment[3]);
			j.put("url", comment[4]);
			j.put("count", comment[5]);
			j.put("mm", comment[6]);
			j.put("step", comment[7]);
			j.put("rownum", comment[8]);
			
			
			
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
