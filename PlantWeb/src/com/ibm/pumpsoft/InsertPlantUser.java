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
 * Servlet implementation class InsertItemUser
 */
@WebServlet("/InsertItemUser")
public class InsertPlantUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/PlantBean",beanInterface=PlantBeanLocal.class)
	private PlantBeanLocal ejb3ssesion; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPlantUser() {
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
		int plant_id = Integer.parseInt(request.getParameter("plant_id"));
		String plant_article = request.getParameter("plant_article");

		int result =  ejb3ssesion.insertPlantUser(id, plant_id, plant_article);
		
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
