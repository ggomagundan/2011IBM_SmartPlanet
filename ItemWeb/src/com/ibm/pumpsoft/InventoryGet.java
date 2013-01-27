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
 * Servlet implementation class InventoryGet
 */
@WebServlet("/InventoryGet")
public class InventoryGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/ItemBean",beanInterface=ItemBeanLocal.class)
	private ItemBeanLocal ejb3Session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryGet() {
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
		String id = request.getParameter("id");
		start = Integer.parseInt(request.getParameter("start"));
		end = Integer.parseInt(request.getParameter("end"));
	
		ArrayList<String> list = ejb3Session.getUserInventory(id, start, end);
		
		JSONArray json 	= new JSONArray();
		
		for(String users : list){
			
			String[] comment = users.split("!PuMp!");
			JSONObject j = new JSONObject();
			
			j.put("id", comment[0]);
			j.put("name", comment[1]);
			j.put("count", comment[2]);
			j.put("desc", comment[3]);
			j.put("effect", comment[4]);
			j.put("url", comment[5]);
			
			
			
			json.add(j);
			
			
//			out.print("name : " + comment[0]);
//			out.print("    count : " + comment[1]);
//			out.print("    desc : " + comment[2]);
//			out.println("    url : " + comment[3]);
			
		
			
			
			
			
			
			
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