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
 * Servlet implementation class UpdateUserPlant
 */
@WebServlet("/UpdateUserPlant")
public class UpdateUserPlant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/PlantBean",beanInterface=PlantBeanLocal.class)
	private PlantBeanLocal ejb3ssesion;  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserPlant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		int result = ejb3ssesion.updateUserPlant(id);
		
		PrintWriter out = response.getWriter();
		
		
		JSONArray json = new JSONArray();
		JSONObject j  = new JSONObject();
		j.put("result",result);
		json.add(j);
		JSONObject js =  new JSONObject();
		
		js.put("data", json);
		
		out.println(js);
		
		//out.println("result :" + result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}