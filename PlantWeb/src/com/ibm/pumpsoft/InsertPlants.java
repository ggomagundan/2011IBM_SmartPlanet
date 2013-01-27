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
 * Servlet implementation class InserstPlants
 */
@WebServlet("/InserstPlants")
public class InsertPlants extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/PlantBean",beanInterface=PlantBeanLocal.class)
	private PlantBeanLocal ejb3ssesion;  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPlants() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		String url = request.getParameter("url");
		int count = Integer.parseInt(request.getParameter("count"));
	
		int max_mature = Integer.parseInt(request.getParameter("max_mature"));
		int step = Integer.parseInt(request.getParameter("step"));
	
		int result =  ejb3ssesion.insertPlants(name, description, price, url, count, max_mature, step);
		
		JSONArray json = new JSONArray();
		JSONObject j = new JSONObject();
		
		j.put("result", result);
		
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
